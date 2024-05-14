package com.example.se2.user.service;

import com.example.se2.user.dto.UserDto;
import com.example.se2.user.dto.UserReturnDto;
import com.example.se2.user.model.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    User save(UserDto userDto);
//     User findUserByUsername(String username);
     User findUserById(Long id);
    User update(User user);
    UserReturnDto getUserByUsername(String username);
    UserReturnDto getUserById(long id);
}
