package com.itheima;

import com.itheima.config.DataSourceTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class SpringbootConfig01ApplicationTests {

    @Autowired
    private DataSourceTest dataSourceTest;

    @Test
    void contextLoads() throws SQLException {

        System.out.println(dataSourceTest);

    }

}
