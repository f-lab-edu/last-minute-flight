package com.flight.core.repository.booking;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.core.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
