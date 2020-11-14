package com.example.redislearning.service;

import com.example.redislearning.pojo.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Cacheable(value = "user", key = "#userId")
    public User doCacheable(long userId) {
        System.out.println("do cacheable");
        return new User(userId, String.valueOf(userId));
    }

    @CachePut(value = "user", key = "#userId")
    public User doCachePut(long userId) {
        System.out.println("do CachePut");
        return new User(userId, String.valueOf(userId));
    }

    @CacheEvict(value = "user", allEntries = true)
    public void delete(long userId) {
        System.out.println("delete user by id: " + userId);
    }

}
