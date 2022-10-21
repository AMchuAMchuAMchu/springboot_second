package com.itheima;

import com.itheima.config.DataSourceTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootConfig01ApplicationTests {

    @Autowired
    private DataSourceTest dataSourceTest;

    @Test
    void contextLoads() {

        System.out.println(dataSourceTest);

    }

}
