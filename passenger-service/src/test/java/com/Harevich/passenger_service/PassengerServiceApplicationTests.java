package com.Harevich.passenger_service;

import com.Harevich.passenger_service.dto.PassengerRequest;
import com.Harevich.passenger_service.dto.PassengerResponse;
import com.Harevich.passenger_service.mapper.PassengerMapper;
import com.Harevich.passenger_service.model.Passenger;
import com.Harevich.passenger_service.service.PassengerService;
import lombok.AllArgsConstructor;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PassengerServiceUnitTest {
	private final PassengerService service;
	@Autowired
    PassengerServiceUnitTest(PassengerService service) {
        this.service = service;
    }

    @Test
	void shouldEditPassenger() {
		Long id = 5l;
		Float rate = service.getById(id).rate();
		var expected = new PassengerResponse(
				id,
				"Arsen",
				"Hydnitsky",
				"kryptoBober@gmail.com",
				rate
		);

		Assertions.assertEquals(expected, PassengerMapper.toResponse(service.edit(
				new PassengerRequest(
						"Arsen",
						"Hydnitsky",
						"kryptoBober@gmail.com"),id)));
	}
	@Test
	void shouldFindPassenger() {
		Long id = 5l;
		var expected = new PassengerResponse(
				id,
				"William",
				"Thompson",
				"william.thompson@example.com",
				4.6f
		);

		Assertions.assertEquals(expected,service.getById(id));
	}
	@Test
	void shouldRegistratePassenger() {
		Long id = 5l;
		var request = new PassengerRequest(
				"Maksim",
				"Komissarov",
				"Komissarov@gmail.com");
		var expected = new PassengerResponse(
				service.getMaxId()+1,
				"Maksim",
				"Komissarov",
				"Komissarov@gmail.com",
				5f
		);

		Assertions.assertEquals(expected,PassengerMapper.toResponse(service.registrate(request)));
	}

}
