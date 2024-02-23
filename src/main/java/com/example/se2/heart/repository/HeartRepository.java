package com.example.se2.heart.repository;

import com.example.se2.heart.model.HeartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeartRepository extends JpaRepository<HeartEntity,Long> {

}
