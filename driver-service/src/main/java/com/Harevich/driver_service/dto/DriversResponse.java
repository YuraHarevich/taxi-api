package com.Harevich.driver_service.dto;

import com.Harevich.driver_service.model.Car;

public record DriversResponse(
        Long id,
        String name,
        String surname,
        String email,
        Float rate,
        CarResponse car
) {
}
