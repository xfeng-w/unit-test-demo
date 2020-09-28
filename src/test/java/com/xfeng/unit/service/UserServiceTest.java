package com.xfeng.unit.service;

import com.xfeng.unit.mapper.UserMapper;
import com.xfeng.unit.model.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

/**
 * @author xuefeng.wang
 * @date 2020-09-24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {
    @MockBean
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    void insert() {
        User user = new User();
        when(userMapper.insert(Mockito.anyObject())).thenReturn(1);
        int n = userService.insert(user);
        assert (n == 1);
    }
}