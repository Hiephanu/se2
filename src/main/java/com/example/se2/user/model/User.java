package com.example.se2.user.model;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="user", uniqueConstraints = {@UniqueConstraint(columnNames = "username")})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Length(min = 3, max = 20)
    private String fullName;
    private String username;
    private String age;
    private String address;
    private String avatar;
    private String password;

    public User() {
    }
    public User(String fullName, String username, String age, String address, String avatar, String password) {
        super();
        this.fullName = fullName;
        this.username = username;
        this.age = age;
        this.address = address;
        this.avatar = avatar;
        this.password = password;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
