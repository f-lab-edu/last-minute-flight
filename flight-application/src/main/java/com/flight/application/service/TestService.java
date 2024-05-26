package com.flight.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flight.application.dto.TestCreateRequest;
import com.flight.application.dto.TestCreateResponse;
import com.flight.application.dto.TestReadResponse;
import com.flight.application.mapper.TestMapper;
import com.flight.core.dto.TestCreateRequestDto;
import com.flight.core.dto.TestCreateResponseDto;
import com.flight.core.dto.TestReadResponseDto;
import com.flight.core.service.TestDomainService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestService {

	private final TestDomainService testDomainService;
	private final TestMapper testMapper;

	public TestCreateResponse createTest(TestCreateRequest createRequest){
		System.out.println(createRequest.name());
		TestCreateRequestDto requestDto = testMapper.requestToDto(createRequest);
		TestCreateResponseDto responseDto = testDomainService.createTestEntity(requestDto);

		return testMapper.responseDtoToResponse(responseDto);
	}

	public List<TestReadResponse> readAllTest(){

		List<TestReadResponseDto> responseDtoList = testDomainService.readAllTestEntities();

		return testMapper.responseDtoListToResponseList(responseDtoList);
	}
}
