package com.itheima;

import com.itheima.dao.AnimeInfoDao;
import com.itheima.pojo.AnimeInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootHotDeploy01ApplicationTests {

    @Autowired
    private AnimeInfoDao animeInfoDao;

    @Test
    void contextLoads() {

        List<AnimeInfo> animeInfos = animeInfoDao.selectAll();

        animeInfos.forEach(System.out::println);

    }

}
