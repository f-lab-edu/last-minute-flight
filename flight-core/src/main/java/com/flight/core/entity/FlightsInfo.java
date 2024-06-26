package com.flight.core.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.Comment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(indexes = @Index(name = "idx_departures_arrivals_departure_time", columnList = "departures, arrivals, departure_time"))
@Getter
public class FlightsInfo extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Comment("운항 정보 id")
	private Long id;

	@Column(nullable = false, length = 100)
	@Comment("출발지")
	private String departures;

	@Column(nullable = false, length = 100)
	@Comment("도착지")
	private String arrivals;

	@Column(nullable = false, columnDefinition = "TIMESTAMP")
	@Comment("출발 시간")
	private LocalDateTime departureTime;

	@Column(nullable = false, columnDefinition = "TIMESTAMP")
	@Comment("도착 시간")
	private LocalDateTime arrivalTime;

	public FlightsInfo(String departures, String arrivals, LocalDateTime departuresTime, LocalDateTime arrivalTime) {
		this.departures = departures;
		this.arrivals = arrivals;
		this.departureTime = departuresTime;
		this.arrivalTime = arrivalTime;
	}
}
