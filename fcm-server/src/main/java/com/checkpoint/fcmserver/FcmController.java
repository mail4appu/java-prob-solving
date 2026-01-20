package com.checkpoint.fcmserver;

import com.google.firebase.messaging.*;
import com.mongodb.client.FindIterable;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fcm")
public class FcmController {

    static String FCM_TOKEN = "f3jFo2NASLeV_72g5uOkkJ:APA91bHd38pJ-HdXLGPp51-YkfLpy_YSlfeMFeOF7Ps1ogedIR1x0S70zmHj1TuuDwdaCogVbuRxM-5pa_JuIj-HSarwghI9R3KZwREDf4zfldFeBssRX04VK6MgSeV_9YQ3dMJ1ksLz";

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    FCMToken fcmToken;

    @PostMapping(value = "/token", consumes = "application/json", produces = "application/json")
    public ResponseEntity saveFcmToken(FCMToken fcmToken) {
        mongoTemplate.save(fcmToken);
        return ResponseEntity.ok("Successfully created token");

    }


    @GetMapping(value = "/token")
    public ResponseEntity getToken() {
        System.out.println("In gettin token");
        FindIterable<Document> fcmtoken = mongoTemplate.getCollection("fcmtoken").find();
        if (fcmtoken.cursor().hasNext()) {
            Document next = fcmtoken.cursor().next();
            return (ResponseEntity) next.get("token");
        }
        return null;
    }

    @PostMapping(value = "/push-notification", consumes = "application/json", produces = "application/json")
    public ResponseEntity sendNotification(@RequestBody PushNotification pushNotification) {

        com.google.firebase.messaging.Notification notification= com.google.firebase.messaging.Notification.builder()
                .setTitle(pushNotification.getTitle())
                .setBody(pushNotification.getText())
                .setImage("")
                .build();

        fcmToken.setToken(FCM_TOKEN);
        FcmOptions fcmOptions= FcmOptions.builder().build();
        AndroidConfig androidConfig = AndroidConfig.builder().setPriority(AndroidConfig.Priority.NORMAL)
         .setTtl(12000)
        .build();
        Message message = Message.builder()
                .putData("noOfItems",pushNotification.getData().get("noOfItems"))
                .putData("price", pushNotification.getData().get("price"))
                .setToken(fcmToken.getToken())
                .setNotification(notification)
                .setAndroidConfig(androidConfig)
                .build();

             // Send a message to the device corresponding to the provided
             // registration token.
        String response = null;
        try {
            System.out.println("Message sent to FCM"+message);
            response = FirebaseMessaging.getInstance().send(message);
        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
        }
        System.out.println("Successfully sent message: " + response);
        return ResponseEntity.ok(response);

    }


    @PostMapping(value = "/data-notification", consumes = "application/json", produces = "application/json")
    public ResponseEntity sendDataNotification(@RequestBody PushNotification pushNotification) {
        com.google.firebase.messaging.Notification notification1= com.google.firebase.messaging.Notification.builder()
                .setTitle(pushNotification.getTitle())
                .setBody(pushNotification.getText())
                .build();

        fcmToken.setToken(FCM_TOKEN);
        Message message = Message.builder()
                .putData("noOfItems", pushNotification.getData().get("noOfItems"))
                .putData("price", pushNotification.getData().get("price"))
                .setToken(fcmToken.getToken())
                .build();

        // Send a message to the device corresponding to the provided
        // registration token.
        String response = null;
        try {
            response = FirebaseMessaging.getInstance().send(message);
        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
        }
        System.out.println("Successfully sent message: " + response);
        return ResponseEntity.ok(response);

    }

}
