package com.trading.TradingUpFundationBackend.controller;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.UserTradingDTO;//Package that allows to use an object with the type of data DTO from the entity UserTrading
import com.trading.TradingUpFundationBackend.commons.domains.GenericResponseDTO;//Package that allows to use a generic response with a DTO type
import org.springframework.http.ResponseEntity;//Package that allows to use a generic response with a DTO type
import org.springframework.web.bind.annotation.*;//Package that gives the annotations to represent a specific query

/**
 * Interface that creates method without body to be implemented in the controller of the entity UserTrading
 */
public interface IUserTradingController {
    @PostMapping//Annotation that represent the header of an HTTP query that creates an user with a POST query
    ResponseEntity<GenericResponseDTO> createUserTrading(@RequestBody  UserTradingDTO userTradingDTO);//Method that creates an user
    @GetMapping//Annotation that represent the header of an HTTP query that reads an user with a GET query
    ResponseEntity<GenericResponseDTO> readUserTrading(@RequestBody UserTradingDTO usertradingDTO);//Method that reads an user
    @GetMapping//Annotation that represent the header of an HTTP query that read all the users with a GET query
    ResponseEntity<GenericResponseDTO> readUsersTrading();//Method that reads all the users
    @PutMapping//Annotation that represent the header of an HTTP query that updates an user with a PUT query
    ResponseEntity<GenericResponseDTO> updateUserTrading(@RequestBody UserTradingDTO userTradingDTO);//Method that updates an user
    @PostMapping//Annotation that represent the header of an HTTP query that deletes an user with a DELETE query
    ResponseEntity<GenericResponseDTO> deleteUserTrading(@RequestBody UserTradingDTO userTradingDTO);//Method that deletes an user
}
