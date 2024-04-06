package com.example.se2.user.repository;


import com.example.se2.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
     User findByUsername(String username);
}
