package com.trading.TradingUpFundationBackend.controller;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.RegistrationTradingDTO;
import com.trading.TradingUpFundationBackend.commons.domains.GenericResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface IRegistrationController {
    @PostMapping()
    ResponseEntity<GenericResponseDTO> createRegistrationTrading(@RequestBody RegistrationTradingDTO registrationTradingDTO);
    @GetMapping()
    ResponseEntity<GenericResponseDTO> readRegistrationTrading(@RequestBody RegistrationTradingDTO registrationTradingDTO);
    @GetMapping()
    ResponseEntity<GenericResponseDTO> readRegistrationsTrading();
    @PutMapping
    ResponseEntity<GenericResponseDTO> updateRegistrationTrading(@RequestBody RegistrationTradingDTO registrationTradingDTO);
    @DeleteMapping
    ResponseEntity<GenericResponseDTO> deleteRegistrationTrading(@PathVariable Integer registrationId);
}
