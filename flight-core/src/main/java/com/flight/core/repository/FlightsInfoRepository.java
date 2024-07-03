package com.flight.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.core.entity.FlightsInfo;

public interface FlightsInfoRepository extends JpaRepository<FlightsInfo, Long> {

}
