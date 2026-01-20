package com.example.distributedlock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

    @Autowired
    MongoTemplate mongoTemplate;


    public void addUser(){


    }

}
