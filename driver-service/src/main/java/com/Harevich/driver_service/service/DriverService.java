package com.Harevich.driver_service.service;

import com.Harevich.driver_service.dto.DriverRequest;
import com.Harevich.driver_service.mapper.DriverMapper;
import com.Harevich.driver_service.model.Driver;
import com.Harevich.driver_service.repository.DriverRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DriverService {
    private final DriverRepository driverRepository;
    public void registrate(DriverRequest request) {
        driverRepository.save(DriverMapper.toDriver(request));
    }

    public Driver edit(DriverRequest request, Long id) {
        var driver = driverRepository.findById(id);
        if (driver.isEmpty())
            throw new EntityNotFoundException("Passenger with such id not found");
        var changed_driver = driver.get();
        changed_driver.setName(request.name());
        changed_driver.setEmail(request.email());
        changed_driver.setSurname(request.surname());
        return driverRepository.saveAndFlush(changed_driver);
    }

    public Driver getById(Long id) {
        if( driverRepository.findById(id).isEmpty())
            throw new EntityNotFoundException("Driver with such id not found");
        return driverRepository.findById(id).get();
    }
}
