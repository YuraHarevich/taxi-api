package com.Harevich.passenger_service.dto;

public record PassengerResponse(
        Long id,
        String name,
        String surname,
        String email,
        double rate
) {
}
