package com.checkpoint.springredis.rest.impl;

import com.checkpoint.springredis.dao.MongoEpcsRepository;
import com.checkpoint.springredis.dao.RedisEpicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/epcs")
public class EpcResource {

    @Autowired
    RedisEpicsRepository redisEpicsRepository;

    @Autowired
    MongoEpcsRepository mongoEpcsRepository;

    @RequestMapping(value = "/data-dump", method = RequestMethod.POST)
    public ResponseEntity exportData(){
        redisEpicsRepository.exportEpcCurrentStateToRedis();
        return new ResponseEntity(HttpStatus.CREATED);

    }


    @RequestMapping(value = "/data-dump/cc-staging-item", method = RequestMethod.POST)
    public ResponseEntity exportEpcStagingItems(){
        redisEpicsRepository.exportCCStagingItemToRedis();
        return new ResponseEntity(HttpStatus.CREATED);

    }

    @RequestMapping(value = "/data-dump-mongo/cc-staging-item", method = RequestMethod.POST)
    public ResponseEntity exportEpcStagingItemsToMongo(){
        redisEpicsRepository.exportCCStagingItemToMongo();
        return new ResponseEntity(HttpStatus.CREATED);

    }


    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Collection<String> checkEpcExist(@RequestBody  List<String> epcs, @RequestParam(value = "fromMongo", required = false) String fromMongo){
        if(StringUtils.isEmpty(fromMongo) || fromMongo.equals("false")){
       // return redisEpicsRepository.fetchEpcStatus(epcs);
            return redisEpicsRepository.fetchEpcStatusFromMap(epcs);
        }
        else{
            return mongoEpcsRepository.fetchEpcState(epcs);
        }


    }


}
