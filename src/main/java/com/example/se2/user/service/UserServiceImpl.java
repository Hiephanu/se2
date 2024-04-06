package com.example.se2.user.service;

import com.example.se2.user.dto.UserDto;
import com.example.se2.user.model.User;
import com.example.se2.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Override
    public User save(UserDto userDto) {
        User user = new User(userDto.getFullName(), userDto.getUsername(), userDto.getAge(), userDto.getAddress(), userDto.getAvatar(), passwordEncoder.encode(userDto.getPassword()) );
        return userRepository.save(user);
    }
}
