package com.flight.core.entity;

import java.time.LocalDateTime;

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
public class FlightsInfoOption extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Comment("운항 정보 옵션 id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "flights_info_id", nullable = false, updatable = false)
	private FlightsInfo flightsInfo;

	@Column(nullable = false)
	@Comment("기존 가격")
	private int originalPrice;

	@Column(nullable = false)
	@Comment("할인된 가격")
	private int discountPrice;

	@Column(nullable = false)
	@Comment("예매 가능 좌석 수")
	private int availableSeats;

	@Column(nullable = false)
	@Comment("할인 종료 시간")
	private LocalDateTime discountEndTime;

	@Column(columnDefinition = "TIMESTAMP")
	@Comment("삭제 시간")
	private LocalDateTime deletedAt;

	@Column(nullable = false, columnDefinition = "TINYINT")
	@Comment("삭제 여부")
	private boolean deleted;

	public FlightsInfoOption(FlightsInfo flightsInfo, int originalPrice, int discountPrice, int availableSeats,
		LocalDateTime discountEndTime) {
		this.flightsInfo = flightsInfo;
		this.originalPrice = originalPrice;
		this.discountPrice = discountPrice;
		this.availableSeats = availableSeats;
		this.discountEndTime = discountEndTime;
		this.deleted = false;
	}

	public void delete() {
		this.deletedAt = LocalDateTime.now();
		this.deleted = true;
	}
}
