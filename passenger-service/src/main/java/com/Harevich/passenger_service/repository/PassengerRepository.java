package com.Harevich.passenger_service.repository;

import com.Harevich.passenger_service.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger,Long> {
}
