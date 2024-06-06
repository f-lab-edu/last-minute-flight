package com.flight.core.mapper;

import org.mapstruct.Mapper;

import com.flight.common.dto.SignupRequest;
import com.flight.common.dto.SignupResponse;
import com.flight.core.entity.Member;

@Mapper(componentModel = "spring")
public interface MemberMapper {

	Member requestToEntity(SignupRequest request);
	SignupResponse entityToResponse(Member entity);
}
