package com.itheima;

import com.itheima.pojo.AnimeInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@SpringBootTest
class SpringbootMongodb01ApplicationTests {

    @Autowired
    private MongoTemplate mongoTemplate;



    @Test
    void testFind(){

        List<AnimeInfo> all = mongoTemplate.findAll(AnimeInfo.class,"anime01");

        all.forEach(System.out::println);



    }

    @Test
    void testInsertOne() {

        AnimeInfo animeInfo = new AnimeInfo();

        animeInfo.setName("在地下城邂逅是否搞错了什么...");
        animeInfo.setTime(2022);
        mongoTemplate.insert(animeInfo,"anime01");

    }

}
