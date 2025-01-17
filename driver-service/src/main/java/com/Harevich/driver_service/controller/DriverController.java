package com.Harevich.driver_service.controller;

import com.Harevich.driver_service.dto.DriverRequest;
import com.Harevich.driver_service.dto.DriversResponse;
import com.Harevich.driver_service.mapper.DriverMapper;
import com.Harevich.driver_service.service.DriverService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/driver")
public class DriverController {
    private final DriverService driverService;
    @PostMapping("registration")
    @ResponseStatus(HttpStatus.CREATED)
    public void registration(@Valid @RequestBody DriverRequest request){
        driverService.registrate(request);
    }

    @PatchMapping("edit")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public DriversResponse edit(@RequestParam("id") Long id, @Valid @RequestBody DriverRequest request){
        return DriverMapper.toDriverResponse(driverService.edit(request,id));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public DriversResponse getPassengerById(@RequestParam("id") Long id){
        return DriverMapper.toDriverResponse(driverService.getById(id));
    }
}
