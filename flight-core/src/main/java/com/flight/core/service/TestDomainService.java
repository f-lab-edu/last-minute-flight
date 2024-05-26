package com.flight.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flight.core.dto.TestCreateRequestDto;
import com.flight.core.dto.TestCreateResponseDto;
import com.flight.core.dto.TestReadResponseDto;
import com.flight.core.entity.TestEntity;
import com.flight.core.mapper.TestMapper;
import com.flight.core.repository.TestRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestDomainService {

	private final TestRepository testRepository;
	private final TestMapper testMapper;

	public TestCreateResponseDto createTestEntity(TestCreateRequestDto requestDto){
		TestEntity testEntity = testMapper.requestDtoToEntity(requestDto);
		testEntity = testRepository.save(testEntity);

		return testMapper.entityToResponseDto(testEntity);
	}

	public List<TestReadResponseDto> readAllTestEntities(){

		List<TestEntity> testEntityList = testRepository.findAll();
		return testMapper.entityListToResponseDtoList(testEntityList);
	}
}
