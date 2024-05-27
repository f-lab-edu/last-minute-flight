package com.flight.core.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.flight.core.dto.TestCreateRequestDto;
import com.flight.core.dto.TestCreateResponseDto;
import com.flight.core.dto.TestReadResponseDto;
import com.flight.core.entity.TestEntity;

@Mapper(componentModel = "spring", implementationName = "CoreTestMapperImpl")
public interface TestMapper {

	TestEntity requestDtoToEntity(TestCreateRequestDto requestDto);
	TestCreateResponseDto entityToResponseDto(TestEntity entity);

	List<TestReadResponseDto> entityListToResponseDtoList(List<TestEntity> entityList);
}
