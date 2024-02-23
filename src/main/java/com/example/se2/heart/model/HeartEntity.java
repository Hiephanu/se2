package com.example.se2.heart.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HeartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long heartId;
    @Column(name = "userId")
    private Long userId;
    @Column(name = "postId")
    private Long postId;
    @Column(name = "createdAt")
    private LocalDate createdAt;
}
