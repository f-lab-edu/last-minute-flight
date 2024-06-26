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
public class PaymentInfo extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Comment("결제 정보 id")
	private Long id;

	@Column(nullable = false, updatable = false)
	@Comment("결제 금액")
	private int fare;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private PaymentStatus status;

	@Column(columnDefinition = "TIMESTAMP")
	@Comment("삭제 시간")
	private LocalDateTime deletedAt;

	@Column(nullable = false, columnDefinition = "TINYINT")
	@Comment("삭제 여부")
	private boolean deleted;

	public PaymentInfo(int fare, PaymentStatus status) {
		this.fare = fare;
		this.status = status;
		this.deleted = false;
	}

	public void delete() {
		this.deletedAt = LocalDateTime.now();
		this.deleted = true;
	}
}
