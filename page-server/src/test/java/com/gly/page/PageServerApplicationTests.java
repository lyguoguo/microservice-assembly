package com.gly.page;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PageServerApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PageServerApplicationTests {

    @Test
    public void contextLoads() {
    }

}
