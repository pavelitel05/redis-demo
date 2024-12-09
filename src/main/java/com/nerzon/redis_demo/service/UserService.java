package com.nerzon.redis_demo.service;

import com.nerzon.redis_demo.entity.User;
import com.nerzon.redis_demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User save(User user) {
        return userRepo.save(user);
    }
    @Cacheable(value = "users", key="#id")
    public User getById(Integer id) {
        return userRepo.findById(id).orElse(null);
    }

}
