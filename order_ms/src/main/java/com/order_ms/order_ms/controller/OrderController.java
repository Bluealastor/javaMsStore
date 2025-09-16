package com.order_ms.order_ms.controller;

import com.order_ms.order_ms.dto.OrderDto;
import com.order_ms.order_ms.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createOrder (@RequestBody OrderDto orderDto){
        orderService.placeOrder(orderDto);
        return "Succcesfully";
    }

}
