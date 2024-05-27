package com.flight.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.flight.application.dto.TestCreateRequest;
import com.flight.application.dto.TestCreateResponse;
import com.flight.application.dto.TestReadResponse;
import com.flight.core.dto.TestCreateRequestDto;
import com.flight.core.dto.TestCreateResponseDto;
import com.flight.core.dto.TestReadResponseDto;

@Mapper(componentModel = "spring", implementationName = "ApplicationTestMapperImpl")
public interface TestMapper {

	TestCreateRequestDto requestToDto(TestCreateRequest createRequest);
	TestCreateResponse responseDtoToResponse(TestCreateResponseDto createResponseDto);
	List<TestReadResponse> responseDtoListToResponseList(List<TestReadResponseDto> readResponseDtoList);
}
