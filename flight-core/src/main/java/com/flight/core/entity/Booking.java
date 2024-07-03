package com.flight.core.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.Comment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Booking extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Comment("예매 id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "member_id", nullable = false)
	private Member member;

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

	public Booking(Member member, int headCount) {
		this.member = member;
		this.headCount = headCount;
		this.status = BookingStatus.WAIT;
		this.deleted = false;
	}

	public void delete() {
		this.deletedAt = LocalDateTime.now();
		this.deleted = true;
	}
}
