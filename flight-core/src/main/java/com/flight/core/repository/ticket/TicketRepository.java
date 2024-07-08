package com.flight.core.repository.ticket;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.core.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>, TicketRepositoryCustom {

	boolean existsByTicketNumber(String ticketNumber);

}
