package com.checkpoint.eventhubdemo;

import com.azure.core.util.IterableStream;
import com.azure.messaging.eventhubs.EventHubConsumerClient;
import com.azure.messaging.eventhubs.models.ErrorContext;
import com.azure.messaging.eventhubs.models.EventContext;
import com.azure.messaging.eventhubs.models.EventPosition;
import com.azure.messaging.eventhubs.models.PartitionEvent;
import com.azure.storage.blob.BlobContainerAsyncClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;

import java.time.Duration;
import java.util.function.Consumer;

@Component
@EnableScheduling
public class Receiver {

    private Logger log = LoggerFactory.getLogger(Receiver.class);

    @Value("${eventHub.connectionString}")
    private String eventHubConnString;
    @Value("${eventHub.name}")
    private String eventHubName;

    @Autowired
    BlobContainerAsyncClient blobContainerAsyncClient;

    @Autowired
    EventHubConsumerClient eventHubConsumerClient;


    @Scheduled(cron = "* * * * * *")
    public void receiveData() {

        /*EventProcessorClientBuilder eventProcessorClientBuilder = new EventProcessorClientBuilder()
                .connectionString(eventHubConnString, eventHubName)
                .consumerGroup(EventHubClientBuilder.DEFAULT_CONSUMER_GROUP_NAME)
                .processEvent(PARTITION_PROCESSOR)
                .processError(ERROR_HANDLER)
                .checkpointStore(new BlobCheckpointStore(blobContainerAsyncClient));

        log.info("Before receiving the event from event hub");
        EventProcessorClient eventProcessorClient = eventProcessorClientBuilder.buildEventProcessorClient();
        try {
            log.info("Starting event processor");
            eventProcessorClient.start();

            log.info("Press enter to stop.");

            System.in.read();

            log.info("Stopping event processor");
            eventProcessorClient.stop();
            log.info("Event processor stopped.");

            log.info("Exiting process");
        } catch (IOException e) {
            log.error("Exception occurred", e);
        } catch (Exception ex){
            log.error("Exception occurred", ex);
        }
*/


        IterableStream<PartitionEvent> events = eventHubConsumerClient.receiveFromPartition("30", 15,
                EventPosition.latest(), Duration.ofSeconds(100));
        for (PartitionEvent event : events) {
            log.debug("event type is {} ", event.getClass());
            //String s=DatatypeConverter.printBase64Binary(event.getData().getBody());
            Object deserialize = SerializationUtils.deserialize(event.getData().getBody());
            log.debug("Latest event  from event hub is : " + (ProductDTO)deserialize);
           
        }

    }


    public final Consumer<EventContext> PARTITION_PROCESSOR = eventContext -> {
        log.debug("Processing event from partition {} with sequence number {}  with body: {} %n",
                eventContext.getPartitionContext().getPartitionId(), eventContext.getEventData().getSequenceNumber(), SerializationUtils.deserialize(eventContext.getEventData().getBody()).toString());
        if (eventContext.getEventData().getSequenceNumber() % 10 == 0) {
            eventContext.updateCheckpoint();
        }
    };

    public final Consumer<ErrorContext> ERROR_HANDLER = errorContext -> {
        log.debug("Error occurred in partition processor for partition {}, {} .%n",
                errorContext.getPartitionContext().getPartitionId(),
                errorContext.getThrowable());
    };

}
