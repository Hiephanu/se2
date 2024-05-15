package com.example.se2.notification.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NotificationSaveDto {
    private long userId;
    private long origin;
    private NotificationType notificationType;
    private String content;
    private long postId;
}
