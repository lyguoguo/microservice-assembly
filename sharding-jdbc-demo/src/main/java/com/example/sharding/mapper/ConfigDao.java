package com.example.sharding.mapper;

import com.example.sharding.entity.TConfig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigDao extends JpaRepository<TConfig, Integer> {
}

