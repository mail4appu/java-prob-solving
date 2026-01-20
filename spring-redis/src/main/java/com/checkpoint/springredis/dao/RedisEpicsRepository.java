package com.checkpoint.springredis.dao;

import com.checkpoint.springredis.model.EpcCCStagingItem;
import com.checkpoint.springredis.model.EpcState;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisZSetCommands;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class RedisEpicsRepository {

    Logger logger = LoggerFactory.getLogger(RedisEpicsRepository.class);

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    RedisTemplate redisTemplate;


    public void exportEpcCurrentStateToRedis() {
        logger.debug("Before dumping epcCurrentState into redis");
        int k = 0;
        while (true) {
            List<EpcState> epcList = mongoTemplate.find(new Query().limit(50000).skip(k * 50000), EpcState.class, "epcCurrentState");
            int size = epcList.size();
            if (size == 0 && k == 20) {
                break;
            }
            logger.debug("Starting to dump {} records  into redis", size);
            long start = System.nanoTime();
            //saveAllInSortedSet(epcList);
            saveEpcCurrentStateInMapWithIndexOnEpc(epcList);
            logger.debug("time taken to insert {} records in redis {} ", size, (System.nanoTime() - start));
            k++;
        }


    }


    public void saveAllInMap(List<EpcState> epcStateList) {
        ObjectMapper objectMapper = new ObjectMapper();
        redisTemplate.executePipelined(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                for (EpcState epcState : epcStateList) {
                    //EpcState epcState = objectMapper.treeToValue(node, EpcState.class);
                    prepareIndexOnEpc(redisConnection, epcState);
                    if (Objects.nonNull(epcState)) {
                        redisConnection.hashCommands().hSet("checkpoint:epcstate:map".getBytes(), String.valueOf(epcState.getObjectId()).getBytes(), new Jackson2JsonRedisSerializer(EpcState.class).serialize(epcState));

                    }
                }
                return null;
            }


        });

    }


    public void saveEpcCurrentStateInMapWithIndexOnEpc(List<EpcState> epcStateList) {
        ObjectMapper objectMapper = new ObjectMapper();
        redisTemplate.executePipelined(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                for (EpcState epcState : epcStateList) {
                    //EpcState epcState = objectMapper.treeToValue(node, EpcState.class);
                    prepareIndexOnEpc(redisConnection, epcState);
                    if (Objects.nonNull(epcState)) {
                        redisConnection.hashCommands().hSet("checkpoint:epcstate:epcIndex:map".getBytes(), String.valueOf(epcState.getEpc()).getBytes(), new Jackson2JsonRedisSerializer(EpcState.class).serialize(epcState));

                    }
                }
                return null;
            }


        });

    }


    public void saveAllEpcStagingItemsInMap(List<EpcCCStagingItem> epcStateList) {
        redisTemplate.executePipelined(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                for (EpcCCStagingItem epcStagingItem : epcStateList) {
                    if (Objects.nonNull(epcStagingItem)) {
                        redisConnection.hashCommands().hSet("checkpoint:epcStatingItem:map".getBytes(), String.valueOf(epcStagingItem.getObjectId()).getBytes(), new Jackson2JsonRedisSerializer(EpcCCStagingItem.class).serialize(epcStagingItem));

                    }
                }
                return null;
            }


        });

    }


    private void prepareIndexOnEpc(RedisConnection redisConnection, EpcState epcState) {
        redisConnection.zSetCommands().zAdd("checkpoint.epcindex".getBytes(), 0, String.valueOf(epcState.getEpc() + ":" + epcState.getObjectId()).getBytes());
    }


    public Map<String, String> checkEpcsState(List<String> epcs) {
        Map<String, String> epcNState = new HashMap<>();
        List<String> epcsNObjectIds = new ArrayList<>();
        redisTemplate.setValueSerializer(null);
        Collection<Collection<byte[]>> results = (Collection<Collection<byte[]>>) redisTemplate.executePipelined(new RedisCallback<Object>() {
            @Override
            public Collection<byte[]> doInRedis(RedisConnection redisConnection) throws DataAccessException {
                for (String epc : epcs) {
                    RedisZSetCommands.Range range = RedisZSetCommands.Range.range().gte(epc).lt(getMax(epc));
                    redisConnection.zSetCommands().zRangeByLex("checkpoint.epcindex".getBytes(), range);
                }
                return null;

            }
        });


        Collection<byte[]> results2 = (Collection<byte[]>) redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                for (Collection<byte[]> collection : results) {
                    for (byte[] epcNObjectid : collection) {
                        String strEpcNObjectId = new Jackson2JsonRedisSerializer<>(String.class).deserialize(epcNObjectid);
                        String epcId = strEpcNObjectId.split(":")[0];
                        String objectId = strEpcNObjectId.split(":")[1];
                        redisConnection.hashCommands().hGet("checkpoint:epcstate:map".getBytes(), objectId.getBytes());


                    }
                }

                return null;
            }

        });
        for (byte[] result2 : results2) {
            EpcState deserialize = new Jackson2JsonRedisSerializer<>(EpcState.class).deserialize(result2);
            //epcNState.put(epcId, deserialize.getState());
        }

        return epcNState;

    }


    public Map<String, String> checkEpcsStateV2(List<String> epcs) {

        Map<String, String> epcNState = new HashMap<>();

        SessionCallback<List<String>> callback = new SessionCallback<List<String>>() {
            @Override
            public List<String> execute(RedisOperations operations)
                    throws DataAccessException {
                // Read
                operations.multi();
                for (String epc : epcs) {
                    RedisZSetCommands.Range range = RedisZSetCommands.Range.range().gte(epc).lt(getMax(epc));

                    Set<String> set = operations.opsForZSet().rangeByLex("checkpoint.epcindex", range);
                    for (String epcNObjectId : set) {
                        String epcStr = epcNObjectId.split(":")[0];
                        String objectid = epcNObjectId.split(":")[1];
                        EpcState epcState = (EpcState) operations.opsForHash().get("checkpoint:epcstate:map", objectid);
                        epcNState.put(epcStr, epcState.getState());

                    }
                    // Write operations

                }
                return operations.exec();
            }
        };
        redisTemplate.setValueSerializer(null);
        redisTemplate.execute(callback);
        return epcNState;
    }


    private Object getMax(String epc) {
        if (epc == "") {
            return "a";
        }

        int i = epc.length() - 1;
        while (epc.charAt(i) == 'z' && i >= 0) {
            i--;
        }

        if (i == -1) {
            epc = epc + 'a';
        } else {
            epc = epc.substring(0, i) +
                    (char) ((int) (epc.charAt(i)) + 1) +
                    epc.substring(i + 1);
        }
        return epc;
    }


    public void saveAllInSortedSet(List<EpcState> epcStateList) {
        redisTemplate.executePipelined(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                for (EpcState epcState : epcStateList) {
                    // prepareIndexOnEpc(redisConnection, epcState);
                    if (Objects.nonNull(epcState)) {
                        redisConnection.zSetCommands().zAdd("checkpoint:epcstate:set".getBytes(), 0, (epcState.getObjectId() + ":" + epcState.getState()).getBytes());

                    }
                }
                return null;
            }


        });

    }


    public Collection<String> fetchEpcStatus(List<String> epcs) {
        Set<String> epcSet = new HashSet<>();
        epcSet.addAll(epcs);

        redisTemplate.setValueSerializer(null);
        Collection<Set<byte[]>> epcsNStates = redisTemplate.executePipelined(new RedisCallback<Object>() {

            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {

                for (String epc : epcs) {
                    RedisZSetCommands.Range range = RedisZSetCommands.Range.range().gte(epc).lt(getMax(epc));
                    redisConnection.zSetCommands().zRangeByLex("checkpoint:epcstate:set".getBytes(), range);
                }
                return null;
            }
        });

        for (Set<byte[]> epcNState : epcsNStates) {
            Iterator<byte[]> iterator = epcNState.iterator();
            while (iterator.hasNext()) {
                String deserialize = new String(iterator.next());
                String epcId = deserialize.split(":")[0];
                if (epcSet.contains(epcId)) {
                    epcSet.remove(epcId);
                    epcSet.add(deserialize);
                }
            }

        }

        return epcSet;


    }


    public Collection<String> fetchEpcStatusFromMap(List<String> epcs) {
        Set<String> epcSet = new HashSet<>();
        epcSet.addAll(epcs);

        redisTemplate.setValueSerializer(null);
        Collection<byte[]> epcStates = redisTemplate.executePipelined(new RedisCallback<Object>() {

            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {

                for (String epc : epcs) {
                    RedisZSetCommands.Range range = RedisZSetCommands.Range.range().gte(epc).lt(getMax(epc));
                    redisConnection.hashCommands().hGet("checkpoint:epcstate:epcIndex:map".getBytes(), epc.getBytes());
                }
                return null;
            }
        });

        for (byte[] epcState : epcStates) {
            EpcState deserialize = new Jackson2JsonRedisSerializer<>(EpcState.class).deserialize(epcState);
            if (Objects.nonNull(deserialize) && epcSet.contains(deserialize.getEpc())) {
                epcSet.remove(deserialize.getEpc());
                epcSet.add(deserialize.getEpc() + ":" + deserialize.getState());
            }
        }


        return epcSet;


    }


    public void exportCCStagingItemToRedis() {
        logger.debug("Before dumping cc-staging-item collection into redis");
        int k = 0;
        while (true) {
            List<EpcCCStagingItem> epcCCStagingItems = mongoTemplate.find(new Query().limit(20000).skip(k * 20000), EpcCCStagingItem.class, "ccStagingItem");
            int dumpSize = epcCCStagingItems.size();
            if (dumpSize == 0 || dumpSize == 500000) {
                break;
            }
            logger.debug("===CCStagingItem=== Starting to dump {} records  into redis", dumpSize);
            long start = System.nanoTime();
            saveAllEpcStagingItemsInMap(epcCCStagingItems);
            logger.debug("===CCStagingItem=== time taken to insert {} records in redis {} ", dumpSize, (System.nanoTime() - start));
            k++;
        }


    }


    public void exportCCStagingItemToMongo() {
        logger.debug("Before dumping cc-staging-item collection into Mongo");
        long count = 20000;
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(EpcCCStagingItem.class));

        try(Cursor<Map.Entry<String, EpcCCStagingItem>> scan = redisTemplate.opsForHash().scan("checkpoint:epcStatingItem:map", ScanOptions.scanOptions().count(count).match("*").build())) {
            long firstCursor = scan.getCursorId();
            long oldCursorId = firstCursor, newCursorId = firstCursor;
            List<EpcCCStagingItem> itemList = new ArrayList<>();
            while (scan.hasNext() && newCursorId == oldCursorId) {

                Map.Entry<String, EpcCCStagingItem> next = scan.next();
                EpcCCStagingItem value = next.getValue();
                newCursorId = scan.getCursorId();
                if (oldCursorId != newCursorId) {
                    oldCursorId = newCursorId;
                    logger.debug("===CCStagingItem=== Starting to dump {} records  into Mongo", itemList.size());
                    long start = System.nanoTime();
                    saveAllEpcStagingItemsInMongo(itemList);
                    logger.debug("===CCStagingItem=== time taken to insert {} records in Mongo {} ", itemList.size(), (System.nanoTime() - start));
                    itemList = new ArrayList<>();
                }
                itemList.add(value);

            }
        } catch (IOException e) {
            logger.error("Exception occurred while writing records to mongo", e);
        }

    }



    private void saveAllEpcStagingItemsInMongo(List<EpcCCStagingItem> values) {
        BulkOperations bulkOperations = mongoTemplate.bulkOps(BulkOperations.BulkMode.UNORDERED, "ccStagingItemNew");
        bulkOperations.insert(values);
        bulkOperations.execute();
    }
}
