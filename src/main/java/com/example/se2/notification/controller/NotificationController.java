package com.example.se2.notification.controller;

import com.example.se2.notification.model.Notification;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
    private SimpMessagingTemplate simpMessagingTemplate;

    @PostMapping("/sendNotification")
    public String sendNotification(@RequestBody Notification notification){
        String userChannel = "/user/"+ notification.getUserId() + "/notification";

        simpMessagingTemplate.convertAndSend(userChannel, notification);
        return  "Send success";
    }
}
