package com.itheima;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SpringBootTest
class SpringbootRedis01ApplicationTests {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;


    @Test
    void testHash(){

        HashOperations<String, Object, Object> sooho = redisTemplate.opsForHash();


        Map<String, String> animeMap = new HashMap<>();

        animeMap.put("name01","Alicization");
        animeMap.put("name02","guilty crown");

        animeMap.put("time","2011");


        sooho.putAll("h1",animeMap);

        Map<Object, Object> h1 = sooho.entries("h1");
        System.out.println();
        System.out.println();
        System.out.println();
        h1.entrySet().forEach(System.out::println);

    }


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
