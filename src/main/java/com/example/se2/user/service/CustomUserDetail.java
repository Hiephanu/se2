package com.example.se2.user.service;

import com.example.se2.user.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;

public class CustomUserDetail implements UserDetails{

    private User user;

    public CustomUserDetail(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> user.getUsername());
    }

    public String getFullName() {
        return user.getFullName();
    }
    public String getAge() {
        return user.getAge();
    }
    public String getAddress() {
        return user.getAddress();
    }
    public String getAvatar() {
        return user.getAvatar();
    }
    public void setFullName(String fullName) {
        this.user.setFullName(fullName);
    }
    public void setAge(String age) {
        this.user.setAge(age);
    }
    public void setAddress(String address) {
        this.user.setAddress(address);
    }
    public void setAvatar(String avatar) {
        this.user.setAvatar(avatar);
    }
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
