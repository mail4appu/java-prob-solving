package com.checkpoint.fcmserver;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.MongoTemplate;
@Configuration
@ComponentScan({
        "com.checkpoint.fcmserver"
})
public class AppConfig {

    @Value("${mongo.db.con.string}")
    String conStr;
    @Value("${mongo.db.name}")
    String dbName;

    @Bean
    public MongoClient mongo() {
        System.out.println("connection string is *****:  "+conStr+"  dbName is "+dbName);
        ConnectionString connectionString = new ConnectionString(conStr);

        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    @Scope("prototype")
    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), dbName);
    }


}
