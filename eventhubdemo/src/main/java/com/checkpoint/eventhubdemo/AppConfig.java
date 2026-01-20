package com.checkpoint.eventhubdemo;

import com.azure.messaging.eventhubs.EventHubClientBuilder;
import com.azure.messaging.eventhubs.EventHubConsumerClient;
import com.azure.messaging.eventhubs.EventHubProducerClient;
import com.azure.messaging.eventhubs.EventProcessorClientBuilder;
import com.azure.messaging.eventhubs.checkpointstore.blob.BlobCheckpointStore;
import com.azure.storage.blob.BlobContainerAsyncClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import com.microsoft.azure.eventhubs.EventHubClient;
import com.microsoft.azure.eventhubs.EventHubException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.concurrent.Executors;

@Configuration
public class AppConfig {

    @Value("${eventHub.connectionString}")
    private String connectionString;

    @Value("${storage.account.connection.string}")
    private String storageAccountUrl;

    @Value("${eventHub.name}")
    private String eventHubName;


    @Bean
    public EventHubClient setupEventHubConnection() throws IOException, EventHubException {
        return EventHubClient.createFromConnectionStringSync(connectionString,
                Executors.newSingleThreadScheduledExecutor());

    }


    @Bean
    public BlobContainerAsyncClient createBlobClient() {
        return new BlobContainerClientBuilder()
                .connectionString(storageAccountUrl)
                .containerName("devtestcnahhstorage")
                .buildAsyncClient();
    }

    @Bean
    public EventHubProducerClient createProducerClient(){
        return new EventHubClientBuilder()
                .connectionString(connectionString, eventHubName)
                .buildProducerClient();
    }

    @Bean
    public EventHubConsumerClient createConsumerClient(){
        return new EventHubClientBuilder()
                .connectionString(connectionString)
                .consumerGroup(EventHubClientBuilder.DEFAULT_CONSUMER_GROUP_NAME)
                .buildConsumerClient();
    }


}
