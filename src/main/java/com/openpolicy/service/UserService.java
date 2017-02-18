package com.openpolicy.service;

import com.openpolicy.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends UserDetailsService{
    void save(User user);
    User findByUsername(String username);
    List<User> getAll();
}
