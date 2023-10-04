package com.trading.TradingUpFundationBackend.controller;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.RegistrationTradingDTO;//Package that allows to use an object with the type of data DTO from the entity RegistrationTrading
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;//Package that allows to use a generic response with a DTO type
import org.springframework.http.ResponseEntity;//Package that allows to use a generic response with a DTO type
import org.springframework.web.bind.annotation.*;//Package that gives the annotations to represent a specific query

/**
 * Interface that creates method without body to be implemented in the controller of the entity RegistrationTrading
 */
public interface IRegistrationController {
    @PostMapping()//Annotation that represent the header of an HTTP query that creates a registration with a POST query
    ResponseEntity<ObjectResponse> createRegistrationTrading(@RequestBody RegistrationTradingDTO registrationTradingDTO);//Method that creates a registration
    @GetMapping()//Annotation that represent the header of an HTTP query that reads a registration with a GET query
    ResponseEntity<ObjectResponse> readRegistrationTrading(@RequestBody RegistrationTradingDTO registrationTradingDTO);//Method that reads a registration
    @GetMapping()//Annotation that represent the header of an HTTP query that read all the registrations with a GET query
    ResponseEntity<ObjectResponse> readRegistrationsTrading();//Method that reads all the registrations
    @PutMapping//Annotation that represent the header of an HTTP query that updates a registrations with a PUT query
    ResponseEntity<ObjectResponse> updateRegistrationTrading(@RequestBody RegistrationTradingDTO registrationTradingDTO);//Method that updates a level
    @DeleteMapping//Annotation that represent the header of an HTTP query that deletes a registration with a DELETE query
    ResponseEntity<ObjectResponse> deleteRegistrationTrading(@PathVariable Integer registrationId);//Method that deletes a level
}
