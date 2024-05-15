package com.example.se2.notification.controller;

import com.example.se2.notification.model.Notification;
import com.example.se2.notification.model.NotificationSaveDto;
import com.example.se2.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification")
@AllArgsConstructor
public class NotificationRestController {
    private SimpMessagingTemplate simpMessagingTemplate;
    private NotificationService notificationService;

    @PostMapping("/sendNotification")
    public String sendNotification(@RequestBody Notification notification){
        String userChannel = "/user/"+ notification.getUserId() + "/notification";

        simpMessagingTemplate.convertAndSend(userChannel, notification);
        return  "Send success";
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAllNotificationByUserId(@PathVariable long id) {
        try {
            return ResponseEntity.ok().body(notificationService.findAllNotificationByUserId(id));
        } catch (Exception e) {
            return  ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping("")
    public ResponseEntity<?> saveNotification(@RequestBody NotificationSaveDto notification) {
        try {
            return ResponseEntity.ok().body(notificationService.saveNotification(notification));
        } catch (Exception e) {
            return  ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
