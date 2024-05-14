package com.example.se2.user.service;

import com.example.se2.user.dto.UserDto;
import com.example.se2.user.model.User;
import com.example.se2.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private PasswordEncoder passwordEncoder;

    private UserRepository userRepository;


    @Override
    public User save(UserDto userDto) {
        User user = new User(userDto.getFullName(), userDto.getUsername(), userDto.getAge(), userDto.getAddress(), userDto.getAvatar(), passwordEncoder.encode(userDto.getPassword()) );
        return userRepository.save(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }
}
