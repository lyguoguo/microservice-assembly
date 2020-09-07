package com.gly.event;

import com.gly.event.service.OrderService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderTest extends BaseTest{

    @Autowired
    private OrderService orderService;

    @Test
    public void testSpringEvent() {
        orderService.order();
    }
}
