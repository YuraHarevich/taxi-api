package com.Harevich.driver_service.dto;

public record DriverRequest(
        String name,
        String surname,
        String email,
        CarRequest car
) {
}
