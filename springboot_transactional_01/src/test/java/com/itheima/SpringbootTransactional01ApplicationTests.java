package com.itheima;

import com.itheima.dao.AnimeInfoDao;
import com.itheima.pojo.AnimeInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootTransactional01ApplicationTests {

    @Autowired
    private AnimeInfoDao animeInfoDao;



    @Test
    void contextLoads() {

        AnimeInfo animeInfo = new AnimeInfo();
        animeInfo.setName("在地下城邂逅是否搞错了什么...");
        animeInfo.setReleaseTime(2015);
        animeInfo.setCharacter01("贝尔克朗尼松冈祯丞");
        animeInfo.setCharacter02("希尔");
        animeInfo.setId(33);
//        Integer integer = animeInfoDao.insertOne(animeInfo);
        Integer integer = animeInfoDao.updateById(animeInfo);
        System.out.println(">>>"+integer);


    }

}
