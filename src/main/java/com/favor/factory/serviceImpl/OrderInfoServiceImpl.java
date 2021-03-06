package com.favor.factory.serviceImpl;

import com.favor.factory.entity.OrderInfo;
import com.favor.factory.jpa.OrderInfoJPA;
import com.favor.factory.service.OrderInfoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderInfoServiceImpl implements OrderInfoService {
    private OrderInfoJPA orderInfoJPA;


    @Override
    public OrderInfo save(OrderInfo orderInfo) {
        return orderInfoJPA.save(orderInfo);
    }

    @Override
    public List<OrderInfo> findAll() {
        return orderInfoJPA.findAll();
    }

    @Override
    public void deleteByID(UUID id) {
        orderInfoJPA.deleteById(id);
    }
}
