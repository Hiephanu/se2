package com.example.se2.user.service;

import com.example.se2.share.exception.NotFoundException;
import com.example.se2.user.dto.UserDto;
import com.example.se2.user.dto.UserReturnDto;
import com.example.se2.user.model.User;
import com.example.se2.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.NotReadablePropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
// <<<<<<< duy_anh

//     @Override
//     public User findUserByUsername(String username) {
//         return userRepository.findByUsername(username);
//     }

     @Override
     public User findUserById(Long id) {
         return userRepository.findById(id).get();
     }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }
    @Override
    public UserReturnDto getUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        UserReturnDto userReturnDto = new UserReturnDto();
        userReturnDto.setId(user.getId());
        userReturnDto.setUsername(user.getUsername());
        userReturnDto.setAge(user.getAge());
        userReturnDto.setFullName(user.getFullName());
        userReturnDto.setAvatar(user.getAvatar());
        if(user != null) {
            return  userReturnDto;
        } else {
            throw new NotFoundException("User not found");
        }
    }

    public UserReturnDto getUserById(long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            UserReturnDto userReturnDto = new UserReturnDto();
            userReturnDto.setId(id);
            userReturnDto.setAge(user.get().getAge());
            userReturnDto.setAddress(user.get().getAddress());
            userReturnDto.setUsername(user.get().getUsername());
            userReturnDto.setFullName(user.get().getFullName());
            userReturnDto.setAvatar(user.get().getAvatar());
            return userReturnDto;
        } else {
            throw new NotFoundException("User not found");
        }
    }
}
