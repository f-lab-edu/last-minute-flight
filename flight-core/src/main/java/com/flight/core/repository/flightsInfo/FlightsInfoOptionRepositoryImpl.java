package com.flight.core.repository.flightsInfo;

import static com.flight.core.entity.QFlightsInfo.*;
import static com.flight.core.entity.QFlightsInfoOption.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.flight.core.dto.FlightsInfoOptionDomainResponse;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class FlightsInfoOptionRepositoryImpl implements FlightsInfoOptionRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	@Override
	public List<FlightsInfoOptionDomainResponse> search(String departures, String arrivals, LocalDate departureDate) {

		LocalDateTime departureTime = departureDate.atStartOfDay();

		return queryFactory.select(Projections.constructor(
				FlightsInfoOptionDomainResponse.class,
				flightsInfoOption.id,
				flightsInfo.departures,
				flightsInfo.arrivals,
				flightsInfo.departureTime,
				flightsInfo.arrivalTime,
				flightsInfoOption.originalPrice,
				flightsInfoOption.discountPrice,
				flightsInfoOption.availableSeats,
				flightsInfoOption.discountEndTime
			))
			.from(flightsInfoOption)
			.join(flightsInfoOption.flightsInfo, flightsInfo)
			.where(flightsInfo.departures.eq(departures)
				.and(flightsInfo.arrivals.eq(arrivals))
				.and(flightsInfo.departureTime.between(departureTime,
					departureTime.withHour(23).withMinute(59).withSecond(59))) //
				.and(flightsInfoOption.deleted.isFalse()))
			.fetch();
	}

	@Override
	public Optional<FlightsInfoOptionDomainResponse> findFlightsInfoById(Long flightsInfoOptionId) {

		return Optional.ofNullable(queryFactory.select(Projections.constructor(
				FlightsInfoOptionDomainResponse.class,
				flightsInfoOption.id,
				flightsInfo.departures,
				flightsInfo.arrivals,
				flightsInfo.departureTime,
				flightsInfo.arrivalTime,
				flightsInfoOption.originalPrice,
				flightsInfoOption.discountPrice,
				flightsInfoOption.availableSeats,
				flightsInfoOption.discountEndTime
			))
			.from(flightsInfoOption)
			.join(flightsInfoOption.flightsInfo, flightsInfo)
			.where(flightsInfoOption.id.eq(flightsInfoOptionId))
			.fetchOne());
	}
}
