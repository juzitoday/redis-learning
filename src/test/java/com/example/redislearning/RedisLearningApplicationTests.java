package com.example.redislearning;

import com.example.redislearning.pojo.User;
import com.example.redislearning.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;

@SpringBootTest
class RedisLearningApplicationTests {

    @Autowired
    UserService userService;
    @Autowired
    RedisTemplate<String, Serializable> lettuceRedisTemplate;
    @Autowired
    RedisTemplate<String, Serializable> jedisRedisTemplate;

    @Test
    void contextLoads() {
        long uid = System.currentTimeMillis();
        User user = userService.doCacheable(uid);
        System.out.println(user.getUid());
        user = userService.doCacheable(uid);
        System.out.println(user.getUid());
        userService.delete(uid);

        System.out.println();

        long uid2 = System.currentTimeMillis();
        User user2 = userService.doCachePut(uid2);
        System.out.println(user2.getUid());
        user2 = userService.doCachePut(uid2);
        System.out.println(user2.getUid());
        userService.delete(uid2);
    }

    @Test
    void testLettuce() {
        lettuceRedisTemplate.opsForValue().set("lettuce-key", "lettuce-value");
        System.out.println(lettuceRedisTemplate.opsForValue().get("test-key"));
    }

    @Test
    void testJedis() {
        jedisRedisTemplate.opsForValue().set("jedis-key", "jedis-value");
        System.out.println(jedisRedisTemplate.opsForValue().get("jedis-key"));
    }


}
