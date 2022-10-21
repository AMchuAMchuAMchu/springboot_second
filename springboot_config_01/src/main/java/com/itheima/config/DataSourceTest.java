package com.itheima.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Description ==> TODO
 * BelongsProject ==> springboot_second
 * BelongsPackage ==> com.itheima.config
 * Version ==> 1.0
 * CreateTime ==> 2022-10-21 08:28:51
 * Author ==> _02雪乃赤瞳楪祈校条祭_艾米丽可锦木千束木更七草荠_制作委员会_start
 */
@Component
@ConfigurationProperties(prefix = "datasource")
@Data
public class DataSourceTest {

    private String driverClassName;

    private String url;

    private String username;

    private String password;


}

