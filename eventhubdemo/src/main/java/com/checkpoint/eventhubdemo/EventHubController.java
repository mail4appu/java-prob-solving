package com.checkpoint.eventhubdemo;

import com.microsoft.azure.eventhubs.EventData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventHubController {

    private Logger log = LoggerFactory.getLogger(EventHubController.class);

    @Autowired
    private EventHubService eventHubService;


    @PostMapping(path = "/eventhub/send")
    public ResponseEntity sendEvent(@RequestBody ProductDTO payload) {
        try {
            log.info("Eventhub send endpoint called, sending {} to event hub..", payload.toString());
            eventHubService.sendEvent(payload);
        } catch (Exception e) {
            log.error("An error arose sending a message to event hub: " + e);
            return new ResponseEntity<Exception>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
