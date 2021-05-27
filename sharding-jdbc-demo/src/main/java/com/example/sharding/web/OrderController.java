package com.example.sharding.web;

import com.example.sharding.entity.Order;
import com.example.sharding.mapper.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class OrderController {
    @Autowired
    private OrderDao orderDao;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public Optional<Order> getOrderById(@RequestParam("id") Long id) {
        return this.orderDao.findById(id);
    }

    @RequestMapping(value = "/order/save", method = RequestMethod.POST)
    public Order saveOrder(@RequestParam("name") String name, @RequestParam("userid") Long userId) {
        Order order = new Order();
        order.setName(name);
        order.setUserId(userId);
        return this.orderDao.save(order);
    }
}

