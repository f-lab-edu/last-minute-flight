package com.flight.core.mapper;

import org.mapstruct.Mapper;

import com.flight.common.dto.MemberSessionInfo;
import com.flight.core.entity.MemberSession;

@Mapper(componentModel = "spring")
public interface MemberSessionDomainMapper {

	MemberSessionInfo entityToDto(MemberSession entity);
	MemberSession dtoToEntity(MemberSessionInfo dto);
}
