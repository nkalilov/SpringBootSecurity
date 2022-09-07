package com.example.springbootsecurity.service.serviceimpl;

import com.example.springbootsecurity.entity.SecurityUser;
import com.example.springbootsecurity.entity.User;
import com.example.springbootsecurity.repository.repositoryimpl.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepositoryImpl userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("Could not found user");
        }
        return new SecurityUser(user);
    }
}
