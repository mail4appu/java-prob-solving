package com.checkpoint.springredis.dao;

import com.checkpoint.springredis.model.EpcState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MongoEpcsRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public Collection<String> fetchEpcState(List<String> epcs){
        Set<String> epcSet= new HashSet<>();
        epcSet.addAll(epcs);

            Collection<EpcState> epcStates = mongoTemplate.find(new Query(Criteria.where("epc").in(epcs)), EpcState.class, "epcCurrentState");
            for(EpcState epcState:epcStates) {
                if (Objects.nonNull(epcState) && epcSet.contains(epcState.getEpc())) {
                    epcSet.remove(epcState.getEpc());
                    epcSet.add(epcState.getEpc() + ":" + epcState.getState());
                }

            }
        return epcSet;
    }

}
