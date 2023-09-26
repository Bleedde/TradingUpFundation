package com.trading.TradingUpFundationBackend.service;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.RegistrationTradingDTO;//Package who allows the use the DTO of the entity RegistrationTrading
import com.trading.TradingUpFundationBackend.commons.domains.GenericResponseDTO;//Package who allows the use of a GenericResponseDTO
import org.springframework.http.ResponseEntity;//Package who allows the manage and the construction of a customized http response

/**
 * Interface that creates the services, who represent the manage of information of the entity RegistrationTrading
 */
public interface IRegistrationTradingService {
    ResponseEntity<GenericResponseDTO> createRegistrationTrading(RegistrationTradingDTO registrationTradingDTO);//Method creating a registration
    ResponseEntity<GenericResponseDTO> readRegistrationTrading(RegistrationTradingDTO registrationTradingDTO);//Method reading a registration
    ResponseEntity<GenericResponseDTO> readRegistrationsTrading();//Method that reads all the registrations
    ResponseEntity<GenericResponseDTO> updateRegistrationTrading(RegistrationTradingDTO registrationTradingDTO);//Method updating a registration
    ResponseEntity<GenericResponseDTO> deleteRegistrationTrading(Integer registrationId);//Method deleting a registration
}
