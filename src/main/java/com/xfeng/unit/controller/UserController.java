package com.xfeng.unit.controller;

import com.xfeng.unit.model.entity.User;
import com.xfeng.unit.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuefeng.wang
 * @date 2020-09-24
 */
@RestController
@RequestMapping("portal/users/v1")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Integer> insert(@RequestBody User user) {
        return new ResponseEntity<>(userService.insert(user), HttpStatus.OK);
    }
}
