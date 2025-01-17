package com.Harevich.driver_service.mapper;

import com.Harevich.driver_service.dto.DriverRequest;
import com.Harevich.driver_service.dto.DriversResponse;
import com.Harevich.driver_service.model.Driver;

public class DriverMapper {
    public static Driver toDriver(DriverRequest request) {
        return Driver.builder()
                .name(request.name())
                .surname(request.name())
                .email(request.email())
                .car(CarMapper.toCar(request.car()))
                .build();
    }

    public static DriversResponse toDriverResponse(Driver driver) {
        return new DriversResponse(
                driver.getId(),
                driver.getName(),
                driver.getSurname(),
                driver.getEmail(),
                driver.getRate(),
                CarMapper.toCarRequest(driver.getCar())
        );
    }
}
