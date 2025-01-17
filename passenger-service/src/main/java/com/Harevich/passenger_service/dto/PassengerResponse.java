package com.Harevich.passenger_service.dto;

import lombok.EqualsAndHashCode;

import java.util.Objects;

public record PassengerResponse(
        Long id,
        String name,
        String surname,
        String email,
        Float rate
) {
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PassengerResponse that = (PassengerResponse) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
