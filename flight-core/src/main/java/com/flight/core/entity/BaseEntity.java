package com.flight.core.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public abstract class BaseEntity {

	@CreatedDate
	@Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP")
	@Comment("생성 일자")
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Column(nullable = false, columnDefinition = "TIMESTAMP")
	@Comment("수정 일자")
	private LocalDateTime updatedAt;
}
