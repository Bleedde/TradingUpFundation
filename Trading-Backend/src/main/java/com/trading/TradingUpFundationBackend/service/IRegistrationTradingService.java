package com.trading.TradingUpFundationBackend.service;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.RegistrationTradingDTO;
import com.trading.TradingUpFundationBackend.commons.domains.GenericResponseDTO;
import org.springframework.http.ResponseEntity;

public interface IRegistrationTradingService {
    ResponseEntity<GenericResponseDTO> createRegistrationTrading(RegistrationTradingDTO registrationTradingDTO);
    ResponseEntity<GenericResponseDTO> readRegistrationTrading(RegistrationTradingDTO registrationTradingDTO);
    ResponseEntity<GenericResponseDTO> readRegistrationsTrading();
    ResponseEntity<GenericResponseDTO> updateRegistrationTrading(RegistrationTradingDTO registrationTradingDTO);
    ResponseEntity<GenericResponseDTO> deleteRegistrationTrading(Integer registrationId);
}
