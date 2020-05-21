package com.gly.rocketmq;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RocketmqAssemblyApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RocketmqAssemblyApplicationTests {

    @Test
    void contextLoads() {
    }

}
