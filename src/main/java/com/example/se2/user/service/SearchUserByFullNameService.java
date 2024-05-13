package com.example.se2.user.service;

import com.example.se2.user.dto.UserReturnDto;
import com.example.se2.user.model.User;
import com.example.se2.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SearchUserByFullNameService {
    private final UserRepository userRepository;

    public List<UserReturnDto> searchUserByFullName(String keyword) {
        Pageable pageable= PageRequest.of(0,8);
        List<User> users = userRepository.searchAllUserByFullName(keyword, pageable);
        List<UserReturnDto> userReturnDtos= users.stream().map(user -> {
            UserReturnDto userReturnDto = new UserReturnDto();
            userReturnDto.setId(user.getId());
            userReturnDto.setFullName(user.getFullName());
            userReturnDto.setAge(user.getAge());
            userReturnDto.setAvatar(user.getAvatar());
            userReturnDto.setAddress(user.getAddress());
            return userReturnDto;
        }).toList();
        return  userReturnDtos;
    }
}
