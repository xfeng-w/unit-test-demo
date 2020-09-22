package com.xfeng.unit.service;

import com.xfeng.unit.mapper.StoreMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author xuefeng.wang
 * @date 2020-09-22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class StoreServiceTest {

    @MockBean
    private StoreMapper storeMapper;

    @Autowired
    private StoreService storeService;

    @Test
    void sync() {
    }

    @Test
    void selectAll() {
        storeService.selectAll();
    }

    @Test
    void selectById() {
        storeService.selectById(1L);
    }
}