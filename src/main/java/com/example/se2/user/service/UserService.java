package com.example.se2.user.service;

import com.example.se2.user.dto.UserDto;
import com.example.se2.user.dto.UserReturnDto;
import com.example.se2.user.model.User;

public interface UserService {
    User save(UserDto userDto);
    UserReturnDto getUserById(long id);
}
