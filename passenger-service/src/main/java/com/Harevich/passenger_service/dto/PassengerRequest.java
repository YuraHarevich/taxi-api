package com.Harevich.passenger_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record PassengerRequest(
        @NotBlank(message = "name is mandatory")
        String name,
        @NotBlank(message = "surname is mandatory")
        String surname,
        @Email(message = "email should be valid")
        @NotBlank(message = "email is mandatory")
        String email
) {
}
