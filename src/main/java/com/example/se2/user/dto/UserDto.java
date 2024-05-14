package com.example.se2.user.dto;

import org.hibernate.validator.constraints.Length;

public class UserDto {
    @Length(min = 3, max = 20)
    private String fullName;
    private String username;
    private String age;
    private String address;
    private String avatar;
    @Length(min = 8, max = 15)
    private String password;

    public UserDto(String fullName, String username, String age, String address, String avatar, String password) {
        super();
        this.fullName = fullName;
        this.username = username;
        this.age = age;
        this.address = address;
        this.avatar = avatar;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
