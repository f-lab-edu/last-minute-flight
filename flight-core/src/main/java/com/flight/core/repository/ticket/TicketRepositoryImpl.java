package com.flight.core.repository.ticket;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.flight.core.entity.Ticket;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class TicketRepositoryImpl implements TicketRepositoryCustom {

	private static final int DEFAULT_BATCH_SIZE = 10;
	private final JdbcTemplate jdbcTemplate;

	@Transactional
	public void saveAllTickets(Collection<Ticket> tickets) {

		String sql =
			"INSERT INTO ticket (flights_info_option_id, booking_id, original_price, discount_price, ticket_number, created_at, updated_at) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

		Timestamp now = Timestamp.valueOf(LocalDateTime.now());

		jdbcTemplate.batchUpdate(sql,
			tickets,
			DEFAULT_BATCH_SIZE,
			(ps, ticket) -> {
				ps.setLong(1, ticket.getFlightsInfoOptionId());
				ps.setLong(2, ticket.getBookingId());
				ps.setInt(3, ticket.getOriginalPrice());
				ps.setInt(4, ticket.getDiscountPrice());
				ps.setString(5, ticket.getTicketNumber());
				ps.setTimestamp(6, now);
				ps.setTimestamp(7, now);
			});
	}
}
