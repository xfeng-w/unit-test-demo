package com.xfeng.unit;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan("com.xfeng.unit.mapper")
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

}
