package com.openpolicy.service.impl;

import com.openpolicy.entity.User;
//import com.openpolicy.repository.RoleRepository;
import com.openpolicy.repository.UserRepository;
import com.openpolicy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{

//    @Autowired
//    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User result = userRepository.getUserByLogin(login);
        if (result==null) {
            throw new UsernameNotFoundException("User with name: " + login + " not found");
        }
        return result;
    }
}
