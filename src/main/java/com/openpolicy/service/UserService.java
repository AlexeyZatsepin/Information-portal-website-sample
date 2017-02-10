package com.openpolicy.service;

import com.openpolicy.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService{
    void save(User user);
    User findByUsername(String username);
}
