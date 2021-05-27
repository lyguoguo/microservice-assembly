package com.example.sharding.web;

import com.example.sharding.entity.OrderItem;
import com.example.sharding.mapper.OrderItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class OrderItemController {
    @Autowired
    private OrderItemDao orderItemDao;

    @RequestMapping(value = "/orderItem", method = RequestMethod.GET)
    public Optional<OrderItem> getOrderItemById(@RequestParam(name = "id") Long id) {
        return this.orderItemDao.findById(id);
    }

    @RequestMapping(value = "/orderItem/save", method = RequestMethod.POST)
    public OrderItem saveOrderItem(@RequestParam("item") String item, @RequestParam("userid") Long userId, @RequestParam("orderid") Long orderId) {
        OrderItem orderItem = new OrderItem();
        orderItem.setUserId(userId);
        orderItem.setItem(item);
        orderItem.setOrderId(orderId);
        return this.orderItemDao.save(orderItem);
    }

    @RequestMapping(value = "/orderItem/query", method = RequestMethod.GET)
    public Optional<OrderItem> getOrderItemByOrderId(@RequestParam(name = "orderid") Long orderId) {
        return this.orderItemDao.getOrderItemByOrderId(orderId);
    }
}
