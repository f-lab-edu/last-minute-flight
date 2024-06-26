package com.flight.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.core.entity.FlightsInfoOption;

public interface FlightsInfoOptionRepository extends JpaRepository<FlightsInfoOption, Long>, FlightsInfoOptionRepositoryCustom {
}
