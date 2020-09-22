package com.xfeng.unit.controller;

import com.xfeng.unit.model.entity.Store;
import com.xfeng.unit.service.StoreService;
import com.xfeng.unit.util.JacksonUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author xuefeng.wang
 * @date 2020-09-22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class StoreControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StoreService storeService;

    @Test
    void selectAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/portal/store/v1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void sync() throws Exception {
        Store store = new Store();
        store.setCreatedTime(new Date());
        store.setUpdatedTime(new Date());
        store.setCode("test");
        store.setName("test");
        store.setTel("13456859845");
        List<Store> storeList = Collections.singletonList(store);
        String content = JacksonUtils.write2JsonString(storeList);
        mockMvc.perform(post("/portal/store/v1").contentType(MediaType.APPLICATION_JSON_UTF8).content(content)).andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}