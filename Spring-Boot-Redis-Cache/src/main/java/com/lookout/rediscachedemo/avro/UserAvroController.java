package com.lookout.rediscachedemo.avro;

import com.lookout.rediscachedemo.RedisConnectionUtil;
import com.lookout.rediscachedemo.User;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.ByteArrayCodec;
import org.redisson.client.codec.StringCodec;
import org.redisson.codec.CompositeCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.SerializationUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(path="/customers")
public class UserAvroController {
    @Autowired
    RedisConnectionUtil redisConnectionUtil;
    private final Logger LOG = LoggerFactory.getLogger(getClass());
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String createUser(@RequestBody User user) {
        LOG.info("creating customer in redis {} ", user.getName());
        RedissonClient redissonClient = redisConnectionUtil.getRedissonClient();
        redissonClient.getConfig().setCodec(new CompositeCodec(StringCodec.INSTANCE, ByteArrayCodec.INSTANCE));
        RMap<Object, Object> userMap = redissonClient.getMap("customers");
        UUID uuid = UUID.randomUUID();
        LOG.info("UUID generated {}", uuid);
        user.setId(uuid.toString());
        userMap.put(uuid.toString(), SerializationUtils.serialize(user));
        return "created user with id:  "+uuid.toString();


    }
}
