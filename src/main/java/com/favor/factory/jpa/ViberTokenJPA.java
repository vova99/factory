package com.favor.factory.jpa;

import com.favor.factory.entity.ViberToken;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ViberTokenJPA extends JpaRepository<ViberToken,Integer> {
}
