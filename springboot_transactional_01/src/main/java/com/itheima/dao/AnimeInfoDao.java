package com.itheima.dao;

import com.itheima.pojo.AnimeInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Description ==> TODO
 * BelongsProject ==> springboot_second
 * BelongsPackage ==> com.itheima.dao
 * Version ==> 1.0
 * CreateTime ==> 2022-10-23 07:05:11
 * Author ==> _02雪乃赤瞳楪祈校条祭_艾米丽可锦木千束木更七草荠_制作委员会_start
 */
@Mapper
public interface AnimeInfoDao {

    @Select("select name, release_time, character01, character02, id from anime_info")
    List<AnimeInfo> selectAll();

    @Update("update anime_info set name = #{name},release_time = #{releaseTime},character01 = #{character01},character02 = #{character02},id = #{id} where id = #{id} ")
    Integer updateById(AnimeInfo animeInfo);

    @Insert("insert into anime_info values(#{name},#{releaseTime},#{character01},#{character02},#{id})")
    Integer insertOne(AnimeInfo animeInfo);

}
