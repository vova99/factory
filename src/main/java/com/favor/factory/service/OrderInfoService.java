package com.favor.factory.service;


import com.favor.factory.entity.OrderInfo;

import java.util.List;
import java.util.UUID;

public interface OrderInfoService {
    OrderInfo save(OrderInfo orderInfo);;
    List<OrderInfo> findAll();
    void deleteByID(UUID id);
}
