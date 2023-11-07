package com.trading.TradingUpFundationBackend.controller;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.UserTradingDTO;//Package that allows to use an object with the type of data DTO from the entity UserTrading
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;//Package that allows to use a generic response with a DTO type
import org.springframework.http.ResponseEntity;//Package that allows to use a generic response with a DTO type
import org.springframework.web.bind.annotation.*;//Package that gives the annotations to represent a specific query

/**
 * Interface that creates method without body to be implemented in the controller of the entity UserTrading
 */
public interface IUserTradingController {

    @PostMapping
    ResponseEntity<ObjectResponse> login(@RequestBody UserTradingDTO userTradingDTO);

    /**
     * Method without body which log-in a user with the service UserTradingServiceImplements
     * @param userTradingDTO The user to be created
     * @return An ObjectResponse with answers depending on the result
     */
    @PostMapping//Annotation that represent the header of an HTTP query that creates a user with a POST query
    ResponseEntity<ObjectResponse> createUserTrading(@RequestBody  UserTradingDTO userTradingDTO);

    /**
     * Method without body which read a user with the service UserTradingServiceImplements
     * @param id The user to be read
     * @return An ObjectResponse with answers depending on the result
     */
    @GetMapping//Annotation that represent the header of an HTTP query that reads a user with a GET query
    ResponseEntity<ObjectResponse> readUserTrading(@PathVariable Integer id);

    /**
     * Method without body which reads all the users with the service UserTradingServiceImplements
     * @return An ObjectResponse with answers depending on the result
     */
    @GetMapping//Annotation that represent the header of an HTTP query that read all the users with a GET query
    ResponseEntity<ObjectResponse> readUsersTrading();

    /**
     * Method without body which update a user with the service UserTradingServiceImplements
     * @param userTradingDTO The user to be updated
     * @return An ObjectResponse with answers depending on the result
     */
    @PutMapping//Annotation that represent the header of an HTTP query that updates a user with a PUT query
    ResponseEntity<ObjectResponse> updateUserTrading(@RequestBody UserTradingDTO userTradingDTO);

    /**
     * Method without body which delete a user with the service UserTradingServiceImplements
     * @param userTradingDTO The user to be deleted
     * @return An ObjectResponse with answers depending on the result
     */
    @PostMapping//Annotation that represent the header of an HTTP query that deletes a user with a DELETE query
    ResponseEntity<ObjectResponse> deleteUserTrading(@RequestBody UserTradingDTO userTradingDTO);
}