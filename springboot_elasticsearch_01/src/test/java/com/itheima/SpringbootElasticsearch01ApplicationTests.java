package com.itheima;

import com.google.gson.Gson;
import com.itheima.dao.AnimeInfoDao;
import com.itheima.pojo.AnimeInfo;
import com.itheima.pojo.AnimeInfoOO;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.mapper.DynamicTemplate;
import org.elasticsearch.search.SearchHits;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
class SpringbootElasticsearch01ApplicationTests {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Autowired
    private AnimeInfoDao animeInfoDao;

    @Test
    void testSearch() throws IOException {

        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("anime02");
        SearchResponse search = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits hits = search.getHits();

        hits.forEach(System.out::println);

    }

    @Test
    void testBulkInsert() throws IOException {

        BulkRequest bulkRequest = new BulkRequest();

        List<AnimeInfo> animeInfos = animeInfoDao.selectList(null);

        animeInfos.forEach((animeInfo)->{
            IndexRequest indexRequest = new IndexRequest();
            Gson gson = new Gson();

            String s = gson.toJson(animeInfo);
            indexRequest.index("anime02").id(animeInfo.getId().toString()).source(s,XContentType.JSON);

            bulkRequest.add(indexRequest);

        });

        restHighLevelClient.bulk(bulkRequest,RequestOptions.DEFAULT);

    }


    @Test
    void testGet() throws IOException {

        GetRequest getRequest = new GetRequest();
        getRequest.index("anime01").id("1");
        GetResponse documentFields = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);

        System.out.println(documentFields);


    }

    @Test
    void testInsert() throws IOException {

//        CreateIndexRequest createIndexRequest = new CreateIndexRequest("anime01");
//
//        restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
//
        AnimeInfoOO animeInfo = new AnimeInfoOO();
        animeInfo.setName("???????????????????????????????????????");
        animeInfo.setTime(2015);
        Gson gson = new Gson();
        String s = gson.toJson(animeInfo);
        IndexRequest indexRequest = new IndexRequest("anime01");
        indexRequest.id("1").source(s,XContentType.JSON);
        restHighLevelClient.index(indexRequest,RequestOptions.DEFAULT);





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
