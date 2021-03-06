package com.favor.factory.jpa;

import com.favor.factory.entity.ViberUserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViberUserProfileJPA extends JpaRepository<ViberUserProfile,String> {
}
