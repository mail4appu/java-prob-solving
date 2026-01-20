package com.checkpoint.eventhubdemo;

import com.azure.messaging.eventhubs.EventData;
import com.azure.messaging.eventhubs.EventDataBatch;
import com.azure.messaging.eventhubs.EventHubProducerClient;
import com.azure.messaging.eventhubs.models.CreateBatchOptions;
import org.apache.commons.lang3.SerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventHubService {



    @Autowired
    EventHubProducerClient eventHubProducerClient;
    private Logger log = LoggerFactory.getLogger(EventHubService.class);


    public void sendEvent(ProductDTO productDTO) {

        byte[] bytes = SerializationUtils.serialize(productDTO);


        log.info("Sending message to the event hub {}", eventHubProducerClient.getEventHubName());
        try {

            CreateBatchOptions createBatchOptions = new CreateBatchOptions().setPartitionId("30");
            //createBatchOptions.setPartitionKey("first test");
            EventDataBatch batchData = eventHubProducerClient.createBatch(createBatchOptions);
            batchData.tryAdd(new EventData(bytes));
            batchData.tryAdd(new EventData(bytes));
            batchData.tryAdd(new EventData(bytes));
            batchData.tryAdd(new EventData(bytes));

            log.debug(" event hub information is {}", eventHubProducerClient.getEventHubName());
            log.debug("Batch  Data information is {} ", batchData.getSizeInBytes());
            eventHubProducerClient.send(batchData);


        } catch (Exception ex) {
            log.error("Exception occurred", ex);
        }

    }
}
