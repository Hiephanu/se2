package com.example.se2.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserReturnDto {
    private long id;
    private String fullName;
    private String username;
    private String age;
    private String address;
    private String avatar;

    public String getUserAvatar() {
        return this.avatar;
    }
}
