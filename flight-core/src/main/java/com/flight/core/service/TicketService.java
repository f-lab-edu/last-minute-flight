package com.flight.core.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.flight.core.dto.TicketCreateDomainRequest;
import com.flight.core.entity.Ticket;
import com.flight.core.mapper.TicketDomainMapper;
import com.flight.core.repository.ticket.TicketRepository;
import com.flight.core.util.TicketNumberGenerator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TicketService {

	private final TicketRepository ticketRepository;
	private final TicketDomainMapper mapper;

	public void createAndSaveTicket(TicketCreateDomainRequest request) {

		int headCount = request.headCount();
		List<Ticket> tickets = IntStream.range(0, headCount)
			.mapToObj(i -> createTicket(request))
			.collect(Collectors.toList());

		ticketRepository.saveAllTickets(tickets);
	}

	private Ticket createTicket(TicketCreateDomainRequest request) {

		String ticketNumber = TicketNumberGenerator.generate();

		for(int i = 0 ; i < Integer.MAX_VALUE ; i++) {
			if(checkTicketNumberDuplicated(ticketNumber)){
				ticketNumber = TicketNumberGenerator.generate();
			} else break;
		}

		return mapper.domainRequestToEntity(request, ticketNumber);
	}

	private boolean checkTicketNumberDuplicated(String ticketNumber) {

		return ticketRepository.existsByTicketNumber(ticketNumber);
	}
}
