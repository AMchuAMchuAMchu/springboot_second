package com.itheima;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class SpringbootMockmvc01ApplicationTests {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void testJJson() throws Exception {

        MockHttpServletRequestBuilder mvc = MockMvcRequestBuilders.get("/animeInfo");

        ResultActions perform = mockMvc.perform(mvc);

        ContentResultMatchers content = MockMvcResultMatchers.content();

        ResultMatcher json = content.json("{\"name\":\"Lycoris recoil\",\"id\":2022}");

        perform.andExpect(json);


    }


    @Test
    void testString() throws Exception {

        MockHttpServletRequestBuilder mvc = MockMvcRequestBuilders.get("/animeInfo");

        ResultActions perform = mockMvc.perform(mvc);

        ContentResultMatchers content = MockMvcResultMatchers.content();

        ResultMatcher string = content.string("Lycoris recoil && Alicization");

        perform.andExpect(string);



    }



    @Test
    void contextLoads() throws Exception {

        MockHttpServletRequestBuilder mvc = MockMvcRequestBuilders.get("/animeInfo");

        ResultActions perform = mockMvc.perform(mvc);

        StatusResultMatchers status = MockMvcResultMatchers.status();

        ResultMatcher ok = status.isOk();

        perform.andExpect(ok);


    }

}
