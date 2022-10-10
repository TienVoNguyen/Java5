package com.vont.myshopping.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.vont.myshopping.models.entity.Order;

import java.util.List;

public interface IOrderService {
    Order save(Order order);
    void delete(long[] ids);
    Order findById(Long id);
//    List<Order> findByCategory(Long id);

    Order save(JsonNode orderData);

    List<Order> findAllByUsername(String username);
}
