package com.itheima;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;

import java.util.List;
import java.util.Set;

@SpringBootTest
class SpringbootRedis01ApplicationTests {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;



    @Test
    void testSet(){

        SetOperations<String, String> ssso = redisTemplate.opsForSet();

        ssso.add("s1","ryo","EGOIST","chelly","chelly");

        Set<String> l1 = ssso.members("s1");

        l1.forEach(System.out::println);


    }

    @Test
    void testList(){

        ListOperations<String, String> sslo = redisTemplate.opsForList();

        sslo.leftPushAll("l1","爱丽丝滋贝鲁库萨提","Eugeo","kirito","asuna","诗乃");

        List<String> l1 = sslo.range("l1", 0, -1);
        System.out.println();
        System.out.println();
        System.out.println();
        l1.forEach(System.out::println);

    }

    @Test
    void testValue() {

        ValueOperations<String, String> ssvo = redisTemplate.opsForValue();

        ssvo.set("name01","alicization");

        String name02 = ssvo.get("name01");

        System.out.println(name02);


    }

}
