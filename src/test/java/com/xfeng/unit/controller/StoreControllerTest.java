package com.xfeng.unit.controller;

import com.xfeng.unit.model.entity.Store;
import com.xfeng.unit.service.StoreService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

/**
 * @author xuefeng.wang
 * @date 2020-09-21
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = StoreController.class)
class StoreControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StoreService storeService;

    @Test
    void sync() throws Exception {
        Store store = new Store();
        Mockito.when(storeService.sync(Collections.singletonList(store))).thenReturn(Collections.singletonList(store));
        mockMvc.perform(MockMvcRequestBuilders.post("portal/store/v1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("杭州")));
    }
}