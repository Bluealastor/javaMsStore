package com.order_ms.order_ms.service;

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

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    public void createOrder (OrderDto orderDto){
        OrderEntity orderEntity = modelMapper.map(orderDto, OrderEntity.class);
        orderRepository.save(orderEntity);
        log.info("Product created success");
    }

}
