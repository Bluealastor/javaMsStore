package com.order_ms.order_ms.service;

import com.order_ms.order_ms.client.InventoryClient;
import com.order_ms.order_ms.dto.OrderDto;
import com.order_ms.order_ms.entity.OrderEntity;
import com.order_ms.order_ms.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {

    private final ModelMapper modelMapper;
    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;


    public void placeOrder (OrderDto orderDto){
        OrderEntity orderEntity = modelMapper.map(orderDto, OrderEntity.class);
        var result = inventoryClient.isInStock(orderEntity.getSkuCode(), orderEntity.getQuantity());
        if (result) {
            orderRepository.save(orderEntity);
        } else {
            throw new RuntimeException("Product with Skucode: " + orderDto.getSkuCode() + " Not in Stock");
        }


    }

}
