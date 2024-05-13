package com.example.se2.user.repository;


import com.example.se2.user.dto.UserDto;
import com.example.se2.user.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
     User findByUsername(String username);

     @Query("SELECT u FROM User u WHERE u.fullName LIKE %:keyword%")
     List<User> searchAllUserByFullName(@Param("keyword") String keyword, Pageable pageable);
}
