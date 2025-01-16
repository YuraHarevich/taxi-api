package com.Harevich.passenger_service.controller;

import com.Harevich.passenger_service.dto.PassengerRequest;
import com.Harevich.passenger_service.dto.PassengerResponse;
import com.Harevich.passenger_service.model.Passenger;
import com.Harevich.passenger_service.service.PassengerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/passenger")
public class PassengerController {
    private final PassengerService passengerService;
    @PostMapping("registration")
    @ResponseStatus(HttpStatus.CREATED)
    public void registration(@Valid @RequestBody PassengerRequest request){
        passengerService.registrate(request);
    }
    @PatchMapping("edit")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Passenger edit(@RequestParam("id") Long id,@Valid @RequestBody PassengerRequest request){
        return passengerService.edit(request,id);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PassengerResponse getPassengerById(@RequestParam("id") Long id){
        return passengerService.getById(id);
    }
}
