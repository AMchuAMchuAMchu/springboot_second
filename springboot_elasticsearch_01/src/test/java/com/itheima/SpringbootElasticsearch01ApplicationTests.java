package com.itheima;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class SpringbootElasticsearch01ApplicationTests {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Test
    void testInsert() throws IOException {

        CreateIndexRequest createIndexRequest = new CreateIndexRequest("anime01");
        restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);




    }

}
