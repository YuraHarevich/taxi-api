package com.Harevich.driver_service.repository;


import com.Harevich.driver_service.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver,Long> {
    Driver findTopByOrderByIdDesc();
}
