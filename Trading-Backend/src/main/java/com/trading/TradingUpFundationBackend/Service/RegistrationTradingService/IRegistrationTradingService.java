package com.trading.TradingUpFundationBackend.Service.RegistrationTradingService;

import com.trading.TradingUpFundationBackend.Commons.Domains.DTO.RegistrationTradingDTO.RegistrationTradingDTO;
import com.trading.TradingUpFundationBackend.Commons.Domains.ResponseDTO.GenericResponseDTO;
import org.springframework.http.ResponseEntity;

public interface IRegistrationTradingService {
    ResponseEntity<GenericResponseDTO> createRegistrationTrading(RegistrationTradingDTO registrationTradingDTO);
    ResponseEntity<GenericResponseDTO> readRegistrationTrading(RegistrationTradingDTO registrationTradingDTO);
    ResponseEntity<GenericResponseDTO> readRegistrationsTrading();
    ResponseEntity<GenericResponseDTO> updateRegistrationTrading(RegistrationTradingDTO registrationTradingDTO);
    ResponseEntity<GenericResponseDTO> deleteRegistrationTrading(Integer registrationId);
}
