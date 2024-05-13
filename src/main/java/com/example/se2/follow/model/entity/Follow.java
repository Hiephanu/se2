package com.example.se2.follow.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity()
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "followerId")
    private long followerId;
    @Column(name = "followedId")
    private long followedId;
    @Column(name="created_at")
    private LocalDateTime createdAt;
    @PrePersist
    private void create(){
        createdAt= LocalDateTime.now();
    }
}
