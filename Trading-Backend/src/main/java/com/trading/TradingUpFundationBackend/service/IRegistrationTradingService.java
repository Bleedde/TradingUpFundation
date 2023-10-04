package com.trading.TradingUpFundationBackend.service;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.RegistrationTradingDTO;//Package who allows the use the DTO of the entity RegistrationTrading
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;//Package who allows the use of a ObjectResponse
import org.springframework.http.ResponseEntity;//Package who allows the manage and the construction of a customized http response

/**
 * Interface that creates the services, who represent the manage of information of the entity RegistrationTrading
 */
public interface IRegistrationTradingService {
    ResponseEntity<ObjectResponse> createRegistrationTrading(RegistrationTradingDTO registrationTradingDTO);//Method creating a registration
    ResponseEntity<ObjectResponse> readRegistrationTrading(RegistrationTradingDTO registrationTradingDTO);//Method reading a registration
    ResponseEntity<ObjectResponse> readRegistrationsTrading();//Method that reads all the registrations
    ResponseEntity<ObjectResponse> updateRegistrationTrading(RegistrationTradingDTO registrationTradingDTO);//Method updating a registration
    ResponseEntity<ObjectResponse> deleteRegistrationTrading(Integer registrationId);//Method deleting a registration
}
