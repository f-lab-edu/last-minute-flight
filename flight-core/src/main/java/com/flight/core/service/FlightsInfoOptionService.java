package com.flight.core.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flight.common.exception.CheckedException;
import com.flight.common.exception.InsufficientSeatsException;
import com.flight.core.dto.FlightsInfoOptionDomainResponse;
import com.flight.core.repository.RedisLockManager;
import com.flight.core.repository.flightsInfo.FlightsInfoOptionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FlightsInfoOptionService {

	private final FlightsInfoOptionRepository flightsInfoOptionRepository;
	private final RedisLockManager lockManager;

	public List<FlightsInfoOptionDomainResponse> search(String departures, String arrivals, LocalDate departureDate) {

		return flightsInfoOptionRepository.search(departures, arrivals, departureDate);
	}

	public Optional<FlightsInfoOptionDomainResponse> getFlightsInfoOptionById(Long flightsInfoOptionId) {

		return flightsInfoOptionRepository.findFlightsInfoById(flightsInfoOptionId);
	}

	@Transactional(rollbackFor = CheckedException.class)
	public void decreaseSeats(Long flightsInfoOptionId, int seatCount) throws CheckedException {

		if (!lockManager.executeWithLock("flightsSeatLock:" + flightsInfoOptionId, 3, 1, TimeUnit.SECONDS, () ->
			flightsInfoOptionRepository.decreaseSeatsInAvailable(flightsInfoOptionId, seatCount) > 0
		)) {
			throw new InsufficientSeatsException(flightsInfoOptionId);
		}
	}
}
