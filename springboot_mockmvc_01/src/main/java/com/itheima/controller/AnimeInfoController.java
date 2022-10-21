package com.itheima.controller;

import com.google.gson.Gson;
import com.itheima.pojo.Anime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description ==> TODO
 * BelongsProject ==> springboot_second
 * BelongsPackage ==> com.itheima.controller
 * Version ==> 1.0
 * CreateTime ==> 2022-10-21 09:42:08
 * Author ==> _02雪乃赤瞳楪祈校条祭_艾米丽可锦木千束木更七草荠_制作委员会_start
 */
@RequestMapping("/animeInfo")
@RestController
public class AnimeInfoController {

    @GetMapping
    public String test01(){

        System.out.println("Lycoris Recoil && Alicization");

        Anime anime = new Anime();
        anime.setId(2022);
        anime.setName("Lycoris recoil");
        Gson gson = new Gson();
        String s = gson.toJson(anime);

//        return "{name01:Lycoris recoil && Alicization}";
        return  s;
    }
}
