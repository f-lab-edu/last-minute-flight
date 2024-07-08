package com.flight.core.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.Comment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Booking extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Comment("예매 id")
	private Long id;

	@Column(nullable = false, updatable = false)
	@Comment("회원 id")
	private Long memberId;

	@Column(nullable = false)
	@Comment("인원수")
	private int headCount;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	@Comment("예매 상태")
	private BookingStatus status;

	@Column(columnDefinition = "TIMESTAMP")
	@Comment("삭제 시간")
	private LocalDateTime deletedAt;

	@Column(nullable = false, columnDefinition = "TINYINT")
	@Comment("삭제 여부")
	private boolean deleted;

	public Booking(Long memberId, int headCount) {

		this.memberId = memberId;
		this.headCount = headCount;
		this.status = BookingStatus.WAIT;
		this.deleted = false;
	}

	public void delete() {
		this.deletedAt = LocalDateTime.now();
		this.deleted = true;
	}
}
