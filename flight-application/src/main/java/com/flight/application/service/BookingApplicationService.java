package com.flight.application.service;

import org.springframework.stereotype.Service;

import com.flight.application.dto.BookingApplicationRequest;
import com.flight.application.mapper.TicketApplicationMapper;
import com.flight.common.dto.SessionInfoThreadLocal;
import com.flight.common.exception.CheckedException;
import com.flight.common.exception.InsufficientSeatsException;
import com.flight.common.exception.InternalBookingFailedException;
import com.flight.common.exception.ResourceNotFoundException;
import com.flight.core.dto.BookingDomainRequest;
import com.flight.core.dto.FlightsInfoOptionDomainResponse;
import com.flight.core.service.BookingService;
import com.flight.core.service.FlightsInfoOptionService;
import com.flight.core.service.TicketService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookingApplicationService {

	private final FlightsInfoOptionService flightsInfoOptionService;
	private final BookingService bookingService;
	private final TicketService ticketService;
	private final TicketApplicationMapper ticketApplicationMapper;

	public void book(BookingApplicationRequest request) {

		Long memberId = SessionInfoThreadLocal.get().memberId();
		Long flightsInfoOptionId = request.flightsInfoOptionId();
		int headCount = request.headCount();

		FlightsInfoOptionDomainResponse flightsInfoOption = flightsInfoOptionService.getFlightsInfoOptionById(
				flightsInfoOptionId)
			.orElseThrow(() -> new ResourceNotFoundException("flightsInfoOption"));
		int availableSeats = flightsInfoOption.availableSeats();

		try {
			tryToDecreaseSeats(flightsInfoOptionId, headCount, availableSeats);
		} catch (CheckedException e) {
			throw new InternalBookingFailedException(e);
		}

		Long bookingId = bookingService.createAndSaveBooking(memberId, new BookingDomainRequest(headCount));

		ticketService.createAndSaveTicket(
			ticketApplicationMapper.toTicketCreateDomainRequest(flightsInfoOptionId, bookingId,
				flightsInfoOption.originalPrice(), flightsInfoOption.discountPrice(), headCount)
		);
	}

	private void tryToDecreaseSeats(Long flightsInfoOptionId, int headCount, int availableSeats) throws
		CheckedException {
		if (availableSeats >= headCount) {
			flightsInfoOptionService.decreaseSeats(flightsInfoOptionId, headCount);
		} else {
			throw new InsufficientSeatsException(flightsInfoOptionId);
		}
	}
}
