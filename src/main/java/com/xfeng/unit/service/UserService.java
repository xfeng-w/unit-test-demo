package com.xfeng.unit.service;

import com.xfeng.unit.mapper.UserMapper;
import com.xfeng.unit.model.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author xuefeng.wang
 * @date 2020-09-24
 */
@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    public int insert(User user) {
        user.setCreatedBy(1L);
        user.setUpdatedBy(1L);
        user.setVersion(1);
        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());
        user.setDeleted(false);
        logger.info("user insert");
        return userMapper.insert(user);
    }
}
