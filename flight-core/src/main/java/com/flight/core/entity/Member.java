package com.flight.core.entity;

import org.hibernate.annotations.Comment;

import com.flight.core.util.PasswordConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Member extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Comment("회원 id")
	private Long id;

	@Column(nullable = false, length = 20)
	@Comment("회원 이름")
	private String name;

	@Column(nullable = false, unique = true, length = 20)
	@Comment("회원 로그인 id")
	private String loginId;

	@Convert(converter = PasswordConverter.class)
	@Column(nullable = false, length = 100)
	@Comment("회원 로그인 비밀번호")
	private String password;

	@Column(nullable = false, unique = true, length = 100)
	@Comment("회원 이메일")
	private String email;

	@Builder
	public Member(String name, String loginId, String password, String email) {
		this.name = name;
		this.loginId = loginId;
		this.password = password;
		this.email = email;
	}

}
