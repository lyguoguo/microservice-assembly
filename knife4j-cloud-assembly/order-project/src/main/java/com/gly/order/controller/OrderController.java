package com.gly.order.controller;

import com.gly.order.domain.OrderInfo;
import com.gly.order.response.ResultVo;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: knife4j-cloud-assembly
 * @Package: com.gly.order.controller
 * @ClassName: OrderController
 * @Author: lvye.guo
 * @Description: 订单控制器
 * @Date: 2020/6/5 16:04
 * @Version: 1.0
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @PostMapping("/getOrderByOrderNo")
    public ResultVo<OrderInfo> getOrderByOrderNo(String orderNo){
        OrderInfo order = new OrderInfo().setOrderName("发夹").setOrderNo("G001002");
        return new ResultVo<>(order);
    }
}
