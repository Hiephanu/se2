package com.example.se2.notification.service;

import com.example.se2.notification.model.Notification;
import com.example.se2.notification.model.NotificationSaveDto;
import com.example.se2.notification.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NotificationService {
    private NotificationRepository notificationRepository;

    public List<Notification> findAllNotificationByUserId(long id) {
        return  notificationRepository.findAllByUserId(id);
    }

    public Notification saveNotification(NotificationSaveDto notificationSave) {
        Notification notification = new Notification();
        notification.setUserId(notificationSave.getUserId());
        notification.setOrigin(notificationSave.getOrigin());
        notification.setNotificationType(notificationSave.getNotificationType());
        notification.setContent(notificationSave.getContent());
        notification.setPostId(notificationSave.getPostId());
        return notificationRepository.save(notification);
    }
}
