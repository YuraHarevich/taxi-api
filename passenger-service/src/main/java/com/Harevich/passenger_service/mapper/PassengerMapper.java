package com.Harevich.passenger_service.mapper;

import com.Harevich.passenger_service.dto.PassengerRequest;
import com.Harevich.passenger_service.model.Passenger;

public class PassengerMapper {
    public static Passenger toPassenger(PassengerRequest request) {
        return Passenger.builder()
                .name(request.name())
                .surname(request.surname())
                .email(request.email())
                .build();
    }
}
