package com.flight.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.core.entity.TestEntity;

public interface TestRepository extends JpaRepository<TestEntity, Long> {
}
