package com.itheima.dao;

import com.itheima.pojo.AnimeInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Description ==> TODO
 * BelongsProject ==> springboot_second
 * BelongsPackage ==> com.itheima.dao
 * Version ==> 1.0
 * CreateTime ==> 2022-10-21 06:31:29
 * Author ==> _02雪乃赤瞳楪祈校条祭_艾米丽可锦木千束木更七草荠_制作委员会_start
 */
@Mapper
public interface AnimeInfoDao {

    @Select("select * from anime_info")
    List<AnimeInfo> selectAll();

}
