package com.itheima.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.validation.annotation.Validated;

import javax.sql.DataSource;
import javax.validation.constraints.Max;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * Description ==> TODO
 * BelongsProject ==> springboot_second
 * BelongsPackage ==> com.itheima.config
 * Version ==> 1.0
 * CreateTime ==> 2022-10-21 08:28:51
 * Author ==> _02雪乃赤瞳楪祈校条祭_艾米丽可锦木千束木更七草荠_制作委员会_start
 */
@Component
@Data
@ConfigurationProperties(prefix = "datasource")
@Validated
public class DataSourceTest {

    private String driverClassName;

    private String url;

    private String username;

    private String password;

    @Max(value = 100,message = "超时了....")
    @DurationUnit(ChronoUnit.MINUTES)
    private Duration timeout;

    @Max(value = 100,message = "Stack Overflow && memory flow !!fuck!fuck!!")
    @DataSizeUnit(DataUnit.MEGABYTES)
    private DataSize dataSize;


//
//    @Bean
//    public DataSource getDruidDataSource(){
//
//        return new DruidDataSource();
//
//    }


}

