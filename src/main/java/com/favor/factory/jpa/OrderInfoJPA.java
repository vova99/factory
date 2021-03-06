package com.favor.factory.jpa;

import com.favor.factory.entity.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderInfoJPA extends JpaRepository<OrderInfo, UUID> {
}
