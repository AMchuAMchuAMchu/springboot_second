package com.itheima;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class SpringbootRedis01ApplicationTests {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Test
    void contextLoads() {

        ValueOperations<String, String> ssvo = redisTemplate.opsForValue();

        ssvo.set("name01","alicization");

        String name02 = ssvo.get("name02");

        System.out.println(name01);


    }

}
