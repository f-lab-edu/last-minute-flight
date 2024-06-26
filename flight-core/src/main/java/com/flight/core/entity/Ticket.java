package com.flight.core.entity;

import org.hibernate.annotations.Comment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Ticket extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Comment("티켓 id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "flights_info_id", nullable = false)
	private FlightsInfo flightsInfo;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "booking_id", nullable = false)
	private Booking booking;

	@Column(nullable = false)
	@Comment("기존 가격")
	private int originalPrice;

	@Column(nullable = false)
	@Comment("할인된 가격")
	private int discountPrice;

	@Column(nullable = false, unique = true, length = 13)
	@Comment("티켓 번호")
	private String ticketNumber;

	public Ticket(FlightsInfo flightsInfo, Booking booking, int originalPrice, int discountPrice, String ticketNumber) {
		this.flightsInfo = flightsInfo;
		this.booking = booking;
		this.originalPrice = originalPrice;
		this.discountPrice = discountPrice;
		this.ticketNumber = ticketNumber;
	}
}
