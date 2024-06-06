package com.flight.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.core.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

	boolean existsByLoginId(String loginId);
	boolean existsByEmail(String email);
}
