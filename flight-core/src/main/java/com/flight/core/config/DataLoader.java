package com.flight.core.config;

// @Component
// @RequiredArgsConstructor
// @Profile("local")
// public class DataLoader implements CommandLineRunner {
//
// 	private final FlightsInfoRepository flightsInfoRepository;
// 	private final FlightsInfoOptionRepository flightsInfoOptionRepository;
//
// 	@Override
// 	public void run(String... args) throws Exception {
//
// 		IntStream.range(1, 365).forEach(i -> {
// 			createAndSaveData("gimpo", "haneda", i, 2, 10, 300000);
// 			createAndSaveData("haneda", "gimpo", i, 2, 10, 300000);
// 			createAndSaveData("incheon", "nhatrang", i, 4, 50, 300000);
// 			createAndSaveData("nhatrang", "incheon", i, 4, 50, 300000);
// 			createAndSaveData("incheon", "singapore", i, 6, 35, 300000);
// 			createAndSaveData("singapore", "incheon", i, 6, 35, 300000);
// 			createAndSaveData("gimpo", "shanghai", i, 2, 10, 300000);
// 			createAndSaveData("shanghai", "gimpo", i, 2, 10, 300000);
// 			createAndSaveData("gimpo", "jeju", i, 1, 10, 300000);
// 			createAndSaveData("jeju", "gimpo", i, 1, 10, 300000);
// 			createAndSaveData("incheon", "new york", i, 14, 0, 300000);
// 			createAndSaveData("new york", "incheon", i, 14, 0, 300000);
// 			createAndSaveData("incheon", "seattle", i, 11, 45, 300000);
// 			createAndSaveData("seattle", "incheon", i, 11, 45, 300000);
// 			createAndSaveData("incheon", "washington", i, 14, 50, 300000);
// 			createAndSaveData("washington", "incheon", i, 14, 50, 300000);
// 			createAndSaveData("incheon", "boston", i, 14, 30, 300000);
// 			createAndSaveData("boston", "incheon", i, 14, 30, 300000);
// 			createAndSaveData("incheon", "los angeles", i, 12, 40, 300000);
// 			createAndSaveData("los angeles", "incheon", i, 12, 40, 300000);
// 			createAndSaveData("incheon", "detroit", i, 13, 20, 300000);
// 			createAndSaveData("detroit", "incheon", i, 13, 20, 300000);
// 			createAndSaveData("incheon", "san francisco", i, 12, 30, 300000);
// 			createAndSaveData("san francisco", "incheon", i, 12, 30, 300000);
// 			createAndSaveData("incheon", "chicago", i, 13, 0, 300000);
// 			createAndSaveData("chicago", "incheon", i, 13, 0, 300000);
// 			createAndSaveData("incheon", "dallas", i, 13, 15, 300000);
// 			createAndSaveData("dallas", "incheon", i, 13, 15, 300000);
// 			createAndSaveData("incheon", "bangkok", i, 5, 30, 300000);
// 			createAndSaveData("bangkok", "incheon", i, 5, 30, 300000);
//
// 			createAndSaveData("incheon", "hanoi", i, 4, 30, 300000);
// 			createAndSaveData("hanoi", "incheon", i, 4, 30, 300000);
//
// 			createAndSaveData("incheon", "ho chi minh city", i, 5, 0, 300000);
// 			createAndSaveData("ho chi minh city", "incheon", i, 5, 0, 300000);
//
// 			createAndSaveData("incheon", "kuala lumpur", i, 6, 20, 300000);
// 			createAndSaveData("kuala lumpur", "incheon", i, 6, 20, 300000);
//
// 			createAndSaveData("incheon", "singapore", i, 6, 30, 300000);
// 			createAndSaveData("singapore", "incheon", i, 6, 30, 300000);
//
// 			createAndSaveData("incheon", "manila", i, 4, 5, 300000);
// 			createAndSaveData("manila", "incheon", i, 4, 5, 300000);
//
// 			createAndSaveData("incheon", "cebu", i, 4, 30, 300000);
// 			createAndSaveData("cebu", "incheon", i, 4, 30, 300000);
//
// 			createAndSaveData("incheon", "phnom penh", i, 5, 20, 300000);
// 			createAndSaveData("phnom penh", "incheon", i, 5, 20, 300000);
//
// 			createAndSaveData("incheon", "yangon", i, 5, 50, 300000);
// 			createAndSaveData("yangon", "incheon", i, 5, 50, 300000);
//
// 			createAndSaveData("incheon", "vientiane", i, 5, 0, 300000);
// 			createAndSaveData("vientiane", "incheon", i, 5, 0, 300000);
//
// 			// 추가 항공편
// 			createAndSaveData("incheon", "danang", i, 4, 45, 300000);
// 			createAndSaveData("danang", "incheon", i, 4, 45, 300000);
//
// 			createAndSaveData("incheon", "chiang mai", i, 6, 0, 300000);
// 			createAndSaveData("chiang mai", "incheon", i, 6, 0, 300000);
//
// 			createAndSaveData("incheon", "phuket", i, 6, 20, 300000);
// 			createAndSaveData("phuket", "incheon", i, 6, 20, 300000);
//
// 			createAndSaveData("incheon", "jakarta", i, 7, 0, 300000);
// 			createAndSaveData("jakarta", "incheon", i, 7, 0, 300000);
//
// 			createAndSaveData("incheon", "bali", i, 7, 30, 300000);
// 			createAndSaveData("bali", "incheon", i, 7, 30, 300000);
//
// 			createAndSaveData("incheon", "penang", i, 6, 10, 300000);
// 			createAndSaveData("penang", "incheon", i, 6, 10, 300000);
//
// 			createAndSaveData("incheon", "medan", i, 6, 30, 300000);
// 			createAndSaveData("medan", "incheon", i, 6, 30, 300000);
//
// 			createAndSaveData("incheon", "surabaya", i, 7, 10, 300000);
// 			createAndSaveData("surabaya", "incheon", i, 7, 10, 300000);
//
// 			createAndSaveData("incheon", "kuching", i, 6, 40, 300000);
// 			createAndSaveData("kuching", "incheon", i, 6, 40, 300000);
//
// 			createAndSaveData("incheon", "haikou", i, 4, 20, 300000);
// 			createAndSaveData("haikou", "incheon", i, 4, 20, 300000);
//
// 			createAndSaveData("incheon", "macau", i, 4, 10, 300000);
// 			createAndSaveData("macau", "incheon", i, 4, 10, 300000);
//
// 			createAndSaveData("incheon", "paris", i, 12, 30, 300000);
// 			createAndSaveData("paris", "incheon", i, 12, 30, 300000);
//
// 			createAndSaveData("incheon", "london", i, 11, 30, 300000);
// 			createAndSaveData("london", "incheon", i, 11, 30, 300000);
//
// 			createAndSaveData("incheon", "frankfurt", i, 11, 15, 300000);
// 			createAndSaveData("frankfurt", "incheon", i, 11, 15, 300000);
//
// 			createAndSaveData("incheon", "amsterdam", i, 11, 20, 300000);
// 			createAndSaveData("amsterdam", "incheon", i, 11, 20, 300000);
//
// 			createAndSaveData("incheon", "rome", i, 12, 0, 300000);
// 			createAndSaveData("rome", "incheon", i, 12, 0, 300000);
//
// 			createAndSaveData("incheon", "milan", i, 12, 10, 300000);
// 			createAndSaveData("milan", "incheon", i, 12, 10, 300000);
//
// 			createAndSaveData("incheon", "vienna", i, 11, 25, 300000);
// 			createAndSaveData("vienna", "incheon", i, 11, 25, 300000);
//
// 			createAndSaveData("incheon", "zurich", i, 11, 35, 300000);
// 			createAndSaveData("zurich", "incheon", i, 11, 35, 300000);
//
// 			createAndSaveData("incheon", "barcelona", i, 13, 0, 300000);
// 			createAndSaveData("barcelona", "incheon", i, 13, 0, 300000);
//
// 			createAndSaveData("incheon", "madrid", i, 13, 30, 300000);
// 			createAndSaveData("madrid", "incheon", i, 13, 30, 300000);
//
// 			createAndSaveData("incheon", "istanbul", i, 11, 10, 300000);
// 			createAndSaveData("istanbul", "incheon", i, 11, 10, 300000);
//
// 			createAndSaveData("incheon", "moscow", i, 8, 55, 300000);
// 			createAndSaveData("moscow", "incheon", i, 8, 55, 300000);
//
// 			createAndSaveData("incheon", "helsinki", i, 9, 30, 300000);
// 			createAndSaveData("helsinki", "incheon", i, 9, 30, 300000);
//
// 			createAndSaveData("incheon", "stockholm", i, 10, 30, 300000);
// 			createAndSaveData("stockholm", "incheon", i, 10, 30, 300000);
//
// 			createAndSaveData("incheon", "oslo", i, 10, 40, 300000);
// 			createAndSaveData("oslo", "incheon", i, 10, 40, 300000);
//
// 			createAndSaveData("incheon", "copenhagen", i, 10, 55, 300000);
// 			createAndSaveData("copenhagen", "incheon", i, 10, 55, 300000);
//
// 			createAndSaveData("incheon", "brussels", i, 11, 20, 300000);
// 			createAndSaveData("brussels", "incheon", i, 11, 20, 300000);
//
// 			createAndSaveData("incheon", "lisbon", i, 13, 50, 300000);
// 			createAndSaveData("lisbon", "incheon", i, 13, 50, 300000);
//
// 			createAndSaveData("incheon", "warsaw", i, 10, 45, 300000);
// 			createAndSaveData("warsaw", "incheon", i, 10, 45, 300000);
//
// 			createAndSaveData("incheon", "budapest", i, 11, 20, 300000);
// 			createAndSaveData("budapest", "incheon", i, 11, 20, 300000);
//
// 			createAndSaveData("incheon", "mexico city", i, 14, 0, 300000);
// 			createAndSaveData("mexico city", "incheon", i, 14, 0, 300000);
//
// 			createAndSaveData("incheon", "sao paulo", i, 19, 10, 300000);
// 			createAndSaveData("sao paulo", "incheon", i, 19, 10, 300000);
//
// 			createAndSaveData("incheon", "santiago", i, 24, 10, 300000);
// 			createAndSaveData("santiago", "incheon", i, 24, 10, 300000);
//
// 			createAndSaveData("incheon", "buenos aires", i, 21, 15, 300000);
// 			createAndSaveData("buenos aires", "incheon", i, 21, 15, 300000);
//
// 			createAndSaveData("incheon", "bogota", i, 20, 30, 300000);
// 			createAndSaveData("bogota", "incheon", i, 20, 30, 300000);
//
// 			createAndSaveData("incheon", "lima", i, 19, 55, 300000);
// 			createAndSaveData("lima", "incheon", i, 19, 55, 300000);
//
// 			createAndSaveData("incheon", "rio de janeiro", i, 20, 40, 300000);
// 			createAndSaveData("rio de janeiro", "incheon", i, 20, 40, 300000);
//
// 			createAndSaveData("incheon", "caracas", i, 20, 50, 300000);
// 			createAndSaveData("caracas", "incheon", i, 20, 50, 300000);
//
// 			createAndSaveData("incheon", "montevideo", i, 22, 10, 300000);
// 			createAndSaveData("montevideo", "incheon", i, 22, 10, 300000);
//
// 			createAndSaveData("incheon", "quayaquil", i, 21, 20, 300000);
// 			createAndSaveData("quayaquil", "incheon", i, 21, 20, 300000);
//
// 			createAndSaveData("incheon", "panama city", i, 19, 0, 300000);
// 			createAndSaveData("panama city", "incheon", i, 19, 0, 300000);
//
// 			createAndSaveData("incheon", "guatemala city", i, 17, 30, 300000);
// 			createAndSaveData("guatemala city", "incheon", i, 17, 30, 300000);
//
// 			createAndSaveData("incheon", "quito", i, 21, 10, 300000);
// 			createAndSaveData("quito", "incheon", i, 21, 10, 300000);
//
// 			createAndSaveData("incheon", "asuncion", i, 21, 40, 300000);
// 			createAndSaveData("asuncion", "incheon", i, 21, 40, 300000);
//
// 			createAndSaveData("incheon", "lapaz", i, 20, 55, 300000);
// 			createAndSaveData("lapaz", "incheon", i, 20, 55, 300000);
//
// 			createAndSaveData("incheon", "san salvador", i, 19, 30, 300000);
// 			createAndSaveData("san salvador", "incheon", i, 19, 30, 300000);
//
// 			createAndSaveData("incheon", "managua", i, 18, 50, 300000);
// 			createAndSaveData("managua", "incheon", i, 18, 50, 300000);
//
// 			createAndSaveData("incheon", "teguccigalpa", i, 20, 20, 300000);
// 			createAndSaveData("teguccigalpa", "incheon", i, 20, 20, 300000);
//
// 			createAndSaveData("incheon", "brasilia", i, 20, 0, 300000);
// 			createAndSaveData("brasilia", "incheon", i, 20, 0, 300000);
//
// 			createAndSaveData("incheon", "belize city", i, 18, 45, 300000);
// 			createAndSaveData("belize city", "incheon", i, 18, 45, 300000);
//
// 			createAndSaveData("incheon", "kingston", i, 17, 50, 300000);
// 			createAndSaveData("kingston", "incheon", i, 17, 50, 300000);
//
// 			createAndSaveData("incheon", "port of spain", i, 19, 40, 300000);
// 			createAndSaveData("port of spain", "incheon", i, 19, 40, 300000);
//
// 			createAndSaveData("incheon", "curaçao", i, 20, 10, 300000);
// 			createAndSaveData("curaçao", "incheon", i, 20, 10, 300000);
//
// 			createAndSaveData("incheon", "aruba", i, 20, 25, 300000);
// 			createAndSaveData("aruba", "incheon", i, 20, 25, 300000);
//
// 			createAndSaveData("incheon", "johannesburg", i, 16, 30, 300000);
// 			createAndSaveData("johannesburg", "incheon", i, 16, 30, 300000);
//
// 			createAndSaveData("incheon", "cape town", i, 18, 0, 300000);
// 			createAndSaveData("cape town", "incheon", i, 18, 0, 300000);
//
// 			createAndSaveData("incheon", "durban", i, 17, 30, 300000);
// 			createAndSaveData("durban", "incheon", i, 17, 30, 300000);
//
// 			createAndSaveData("incheon", "nairobi", i, 15, 0, 300000);
// 			createAndSaveData("nairobi", "incheon", i, 15, 0, 300000);
//
// 			createAndSaveData("incheon", "cairo", i, 11, 0, 300000);
// 			createAndSaveData("cairo", "incheon", i, 11, 0, 300000);
//
// 			createAndSaveData("incheon", "lagos", i, 16, 0, 300000);
// 			createAndSaveData("lagos", "incheon", i, 16, 0, 300000);
//
// 			createAndSaveData("incheon", "addis ababa", i, 14, 0, 300000);
// 			createAndSaveData("addis ababa", "incheon", i, 14, 0, 300000);
//
// 			createAndSaveData("incheon", "casablanca", i, 13, 30, 300000);
// 			createAndSaveData("casablanca", "incheon", i, 13, 30, 300000);
//
// 			createAndSaveData("incheon", "lusaka", i, 17, 0, 300000);
// 			createAndSaveData("lusaka", "incheon", i, 17, 0, 300000);
//
// 			createAndSaveData("incheon", "accra", i, 16, 30, 300000);
// 			createAndSaveData("accra", "incheon", i, 16, 30, 300000);
//
// 			createAndSaveData("incheon", "harare", i, 17, 20, 300000);
// 			createAndSaveData("harare", "incheon", i, 17, 20, 300000);
//
// 			createAndSaveData("incheon", "kampala", i, 16, 0, 300000);
// 			createAndSaveData("kampala", "incheon", i, 16, 0, 300000);
//
// 			createAndSaveData("incheon", "kinshasa", i, 16, 30, 300000);
// 			createAndSaveData("kinshasa", "incheon", i, 16, 30, 300000);
//
// 			createAndSaveData("incheon", "maputo", i, 16, 30, 300000);
// 			createAndSaveData("maputo", "incheon", i, 16, 30, 300000);
//
// 			createAndSaveData("incheon", "antananarivo", i, 15, 0, 300000);
// 			createAndSaveData("antananarivo", "incheon", i, 15, 0, 300000);
//
// 			createAndSaveData("incheon", "port louis", i, 12, 30, 300000);
// 			createAndSaveData("port louis", "incheon", i, 12, 30, 300000);
//
// 			createAndSaveData("incheon", "dakar", i, 17, 0, 300000);
// 			createAndSaveData("dakar", "incheon", i, 17, 0, 300000);
//
// 			createAndSaveData("incheon", "bissau", i, 17, 30, 300000);
// 			createAndSaveData("bissau", "incheon", i, 17, 30, 300000);
//
// 			createAndSaveData("incheon", "freetown", i, 17, 40, 300000);
// 			createAndSaveData("freetown", "incheon", i, 17, 40, 300000);
//
// 			createAndSaveData("incheon", "monrovia", i, 17, 50, 300000);
// 			createAndSaveData("monrovia", "incheon", i, 17, 50, 300000);
//
// 			createAndSaveData("incheon", "niamey", i, 16, 30, 300000);
// 			createAndSaveData("niamey", "incheon", i, 16, 30, 300000);
//
// 			createAndSaveData("incheon", "ouagadougou", i, 16, 30, 300000);
// 			createAndSaveData("ouagadougou", "incheon", i, 16, 30, 300000);
//
// 			createAndSaveData("incheon", "bamako", i, 16, 30, 300000);
// 			createAndSaveData("bamako", "incheon", i, 16, 30, 300000);
//
// 			createAndSaveData("incheon", "libreville", i, 15, 0, 300000);
// 			createAndSaveData("libreville", "incheon", i, 15, 0, 300000);
//
// 			createAndSaveData("incheon", "malabo", i, 15, 0, 300000);
// 			createAndSaveData("malabo", "incheon", i, 15, 0, 300000);
//
// 			createAndSaveData("incheon", "yaounde", i, 16, 0, 300000);
// 			createAndSaveData("yaounde", "incheon", i, 16, 0, 300000);
//
// 			createAndSaveData("incheon", "ndjamena", i, 17, 0, 300000);
// 			createAndSaveData("ndjamena", "incheon", i, 17, 0, 300000);
//
// 			createAndSaveData("incheon", "khartoum", i, 14, 0, 300000);
// 			createAndSaveData("khartoum", "incheon", i, 14, 0, 300000);
//
// 			createAndSaveData("incheon", "juba", i, 14, 30, 300000);
// 			createAndSaveData("juba", "incheon", i, 14, 30, 300000);
//
// 			createAndSaveData("incheon", "dar es salaam", i, 15, 30, 300000);
// 			createAndSaveData("dar es salaam", "incheon", i, 15, 30, 300000);
//
// 			createAndSaveData("incheon", "dodoma", i, 16, 0, 300000);
// 			createAndSaveData("dodoma", "incheon", i, 16, 0, 300000);
//
// 			createAndSaveData("incheon", "lilongwe", i, 17, 0, 300000);
// 			createAndSaveData("lilongwe", "incheon", i, 17, 0, 300000);
//
// 			createAndSaveData("incheon", "lusaka", i, 17, 0, 300000);
// 			createAndSaveData("lusaka", "incheon", i, 17, 0, 300000);
//
// 			createAndSaveData("incheon", "gaborone", i, 17, 30, 300000);
// 			createAndSaveData("gaborone", "incheon", i, 17, 30, 300000);
//
// 			createAndSaveData("incheon", "sydney", i, 10, 20, 300000);
// 			createAndSaveData("sydney", "incheon", i, 10, 20, 300000);
//
// 			createAndSaveData("incheon", "melbourne", i, 10, 30, 300000);
// 			createAndSaveData("melbourne", "incheon", i, 10, 30, 300000);
//
// 			createAndSaveData("incheon", "brisbane", i, 9, 40, 300000);
// 			createAndSaveData("brisbane", "incheon", i, 9, 40, 300000);
//
// 			createAndSaveData("incheon", "perth", i, 10, 50, 300000);
// 			createAndSaveData("perth", "incheon", i, 10, 50, 300000);
//
// 			createAndSaveData("incheon", "adelaide", i, 10, 15, 300000);
// 			createAndSaveData("adelaide", "incheon", i, 10, 15, 300000);
//
// 			createAndSaveData("incheon", "cairns", i, 9, 30, 300000);
// 			createAndSaveData("cairns", "incheon", i, 9, 30, 300000);
//
// 			createAndSaveData("incheon", "vancouver", i, 11, 0, 300000);
// 			createAndSaveData("vancouver", "incheon", i, 11, 0, 300000);
//
// 			createAndSaveData("incheon", "toronto", i, 13, 0, 300000);
// 			createAndSaveData("toronto", "incheon", i, 13, 0, 300000);
//
// 			createAndSaveData("incheon", "calgary", i, 10, 30, 300000);
// 			createAndSaveData("calgary", "incheon", i, 10, 30, 300000);
//
// 			createAndSaveData("incheon", "montreal", i, 13, 15, 300000);
// 			createAndSaveData("montreal", "incheon", i, 13, 15, 300000);
//
// 			createAndSaveData("incheon", "edmonton", i, 10, 40, 300000);
// 			createAndSaveData("edmonton", "incheon", i, 10, 40, 300000);
// 		});
//
// 	}
//
// 	private void createAndSaveData(String departures, String arrivals, int afterDay, int hour, int minute,
// 		int originalPrice) {
//
// 		LocalDateTime oneDayAfter = LocalDate.now().plusDays(afterDay).atStartOfDay();
//
// 		// 1 시간 간격
// 		List<FlightsInfo> flightsInfos = IntStream.range(1, 23)
// 			.mapToObj(i -> new FlightsInfo(departures, arrivals, oneDayAfter.plusHours(i),
// 				oneDayAfter.plusHours(i + hour).plusMinutes(minute)))
// 			.toList();
//
// 		List<FlightsInfoOption> flightsInfoOptions = flightsInfos.stream()
// 			.map(flightsInfo -> new FlightsInfoOption(flightsInfo, originalPrice, discount(originalPrice), 20,
// 				oneDayAfter.withHour(23).withMinute(59).withSecond(59)))
// 			.toList();
//
// 		flightsInfoRepository.saveAll(flightsInfos);
// 		flightsInfoOptionRepository.saveAll(flightsInfoOptions);
// 	}
//
// 	private int discount(int originalPrice) {
//
// 		return (int)(originalPrice * 0.9);
// 	}
// }
