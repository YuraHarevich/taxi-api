package com.Harevich.passenger_service.service;

import com.Harevich.passenger_service.dto.PassengerRequest;
import com.Harevich.passenger_service.dto.PassengerResponse;
import com.Harevich.passenger_service.mapper.PassengerMapper;
import com.Harevich.passenger_service.model.Passenger;
import com.Harevich.passenger_service.repository.PassengerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PassengerService {
    private final PassengerRepository passengerRepository;

    public Passenger registrate(PassengerRequest request) {
        var passenger = PassengerMapper.toPassenger(request);
        passenger.setRate(5.0);
        passengerRepository.saveAndFlush(passenger);
        return passenger;
    }

    public Passenger edit(PassengerRequest request, Long id) {
        var passenger = passengerRepository.findById(id);
        if (passenger.isEmpty())
            throw new EntityNotFoundException("Passenger with such id not found");
        var changed_passenger = passenger.get();
        changed_passenger.setName(request.name());
        changed_passenger.setEmail(request.email());
        changed_passenger.setSurname(request.surname());
        return passengerRepository.saveAndFlush(changed_passenger);
    }

    public PassengerResponse getById(Long id) {
        var optional = passengerRepository.findById(id);
        if (optional.isPresent()){
            return new PassengerResponse(
                    optional.get().getId(),
                    optional.get().getName(),
                    optional.get().getSurname(),
                    optional.get().getEmail(),
                    optional.get().getRate()
            );
        }
        else
            throw new EntityNotFoundException("Passenger with such id not found");

    }
}
