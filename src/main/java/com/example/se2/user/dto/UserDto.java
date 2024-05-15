package com.example.se2.user.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import org.springframework.boot.context.properties.bind.DefaultValue;

public class UserDto {
    @Length(min = 3, max = 20)
    private String fullName;
    private String username;
    private String age;
    private String address;
    private String avatar;
    private String password;

    public UserDto(String fullName, String username, String age, String address, String avatar, String password) {
        super();
        this.fullName = fullName;
        this.username = username;
        this.age = age;
        this.address = address;
        if(avatar != null) {
            this.avatar = avatar;
        } else {
            this.avatar = "https://st3.depositphotos.com/9998432/13335/v/450/depositphotos_133351928-stock-illustration-default-placeholder-man-and-woman.jpg";
        }
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
