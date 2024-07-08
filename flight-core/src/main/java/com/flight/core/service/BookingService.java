package com.flight.core.service;

import org.springframework.stereotype.Service;

import com.flight.core.dto.BookingDomainRequest;
import com.flight.core.entity.Booking;
import com.flight.core.repository.booking.BookingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookingService {

	private final BookingRepository bookingRepository;

	public Long createAndSaveBooking(Long memberId, BookingDomainRequest request) {

		return bookingRepository.save(
			new Booking(memberId, request.headCount())
		).getId();
	}
}
