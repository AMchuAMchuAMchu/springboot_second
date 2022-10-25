package com.itheima;

import com.google.gson.Gson;
import com.itheima.pojo.AnimeInfo;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.mapper.DynamicTemplate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class SpringbootElasticsearch01ApplicationTests {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Test
    void testInsertJson() throws IOException {

        AnimeInfo animeInfo = new AnimeInfo();
        animeInfo.setName("我的青春恋爱物语果然有问题");
        animeInfo.setTime(2015);
//        restHighLevelClient.
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("anime01");
        Gson gson = new Gson();
        String s = gson.toJson(animeInfo);
        createIndexRequest.source(s,XContentType.JSON);
//        restHighLevelClient.indices()


    }


    @Test
    void testInsert() throws IOException {
//
//        CreateIndexRequest createIndexRequest = new CreateIndexRequest("anime01");
//
//        restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);

        IndexRequest indexRequest = new IndexRequest();

        indexRequest.index("anime01").id("1").source();

        restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);



    }


    @AfterEach
    void closeRest(){

        try {
            restHighLevelClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
