package com.example.sharding.mapper;

import com.example.sharding.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface OrderItemDao extends JpaRepository<OrderItem, Long> {
    //为了测试绑定表
    @Query(value = "select n from Order t inner join OrderItem n on t.orderId = n.orderId where n.orderId=:orderId")
    Optional<OrderItem> getOrderItemByOrderId(@Param("orderId") Long orderId);
}

