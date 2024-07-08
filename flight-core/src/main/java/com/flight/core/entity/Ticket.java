package com.flight.core.entity;

import org.hibernate.annotations.Comment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

	@Column(nullable = false, updatable = false)
	@Comment("운항 정보 옵션 id")
	private Long flightsInfoOptionId;

	@Column(nullable = false, updatable = false)
	@Comment("예매 id")
	private Long bookingId;

	@Column(nullable = false)
	@Comment("기존 가격")
	private int originalPrice;

	@Column(nullable = false)
	@Comment("할인된 가격")
	private int discountPrice;

	@Column(nullable = false, unique = true, length = 13)
	@Comment("티켓 번호")
	private String ticketNumber;

	public Ticket(Long flightsInfoOptionId, Long bookingId, int originalPrice, int discountPrice, String ticketNumber) {
		this.flightsInfoOptionId = flightsInfoOptionId;
		this.bookingId = bookingId;
		this.originalPrice = originalPrice;
		this.discountPrice = discountPrice;
		this.ticketNumber = ticketNumber;
	}
}
