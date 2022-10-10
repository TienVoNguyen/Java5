package com.vont.myshopping.controller.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.vont.myshopping.service.IOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/order")
public class OrderAPI {
    private final IOrderService orderService;

    public OrderAPI(IOrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<?> saveOrder(@RequestBody JsonNode orderData) {
        return ResponseEntity.ok(orderService.save(orderData));
    }
}
