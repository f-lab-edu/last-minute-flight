package com.flight.core.repository.flightsInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flight.core.entity.FlightsInfoOption;

public interface FlightsInfoOptionRepository extends JpaRepository<FlightsInfoOption, Long>, FlightsInfoOptionRepositoryCustom {

	@Modifying
	@Query("UPDATE FlightsInfoOption fio SET fio.availableSeats = fio.availableSeats - :seatCount "
		+ "WHERE fio.id = :id AND fio.availableSeats >= :seatCount")
	int decreaseSeatsInAvailable(@Param("id") Long flightsInfoOptionId, @Param("seatCount") int seatCount);
}
