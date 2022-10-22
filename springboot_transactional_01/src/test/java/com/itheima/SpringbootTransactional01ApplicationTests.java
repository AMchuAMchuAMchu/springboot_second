package com.itheima;

import com.itheima.config.AnimeConfig;
import com.itheima.dao.AnimeInfoDao;
import com.itheima.pojo.AnimeInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
class SpringbootTransactional01ApplicationTests {

    @Autowired
    private AnimeInfoDao animeInfoDao;

    @Autowired
    private AnimeConfig animeConfig;

    @Test
    void testAnimeConfig(){

        System.out.println(animeConfig);

    }

    @Test
    void contextLoads() {

        AnimeInfo animeInfo = new AnimeInfo();
        animeInfo.setName("在地下城邂逅是否搞错了什么...");
        animeInfo.setReleaseTime(2015);
        animeInfo.setCharacter01("贝尔克朗尼松冈祯丞04");
        animeInfo.setCharacter02("希尔石上静香04");

        animeInfo.setId(33);
//        Integer integer = animeInfoDao.insertOne(animeInfo);
        Integer integer = animeInfoDao.updateById(animeInfo);

//                int i = 10/0;



        AnimeInfo animeInfo02 = new AnimeInfo();
        animeInfo02.setName("在地下城邂逅是否搞错了什么...");
        animeInfo02.setReleaseTime(2015);
        animeInfo02.setCharacter01("贝尔克朗尼松冈祯丞04");
        animeInfo02.setCharacter02("希尔石上静香04");

        animeInfo02.setId(34);
//        Integer integer = animeInfoDao.insertOne(animeInfo);
        Integer integer02 = animeInfoDao.updateById(animeInfo);


    }

}
