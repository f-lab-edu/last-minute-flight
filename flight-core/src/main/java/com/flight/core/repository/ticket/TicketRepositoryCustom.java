package com.flight.core.repository.ticket;

import java.util.Collection;

import com.flight.core.entity.Ticket;

public interface TicketRepositoryCustom {

	void saveAllTickets(Collection<Ticket> tickets);
}
