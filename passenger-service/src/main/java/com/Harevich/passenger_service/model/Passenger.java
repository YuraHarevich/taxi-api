package com.Harevich.passenger_service.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "passenger_seq")
    @SequenceGenerator(name = "passenger_seq", sequenceName = "passenger_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private Float rate;
}
