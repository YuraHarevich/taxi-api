package com.Harevich.driver_service.mapper;

import com.Harevich.driver_service.dto.CarRequest;
import com.Harevich.driver_service.dto.CarResponse;
import com.Harevich.driver_service.model.Car;

public class CarMapper {
    public static Car toCar(CarRequest carRequest) {
        return Car.builder()
                .color(carRequest.color())
                .brand(carRequest.brand())
                .number(carRequest.number())
                .build();
    }

    public static CarResponse toCarRequest(Car car) {
        return new CarResponse(
                car.getId(),
                car.getColor(),
                car.getNumber(),
                car.getBrand()
        );
    }
}
