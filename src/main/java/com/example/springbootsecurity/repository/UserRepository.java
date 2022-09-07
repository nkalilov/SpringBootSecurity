package com.example.springbootsecurity.repository;

import com.example.springbootsecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository {

    User getUserByUsername(String name);


}