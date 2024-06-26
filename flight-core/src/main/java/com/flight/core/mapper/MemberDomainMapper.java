package com.flight.core.mapper;

import org.mapstruct.Mapper;

import com.flight.core.dto.MemberDomainResponse;
import com.flight.core.dto.SignupDomainRequest;
import com.flight.core.dto.SignupDomainResponse;
import com.flight.core.entity.Member;

@Mapper(componentModel = "spring")
public interface MemberDomainMapper {

	Member domainRequestToEntity(SignupDomainRequest request);
	SignupDomainResponse entityToSignupDomainResponse(Member entity);
	MemberDomainResponse entityToDomainResponse(Member entity);
}
