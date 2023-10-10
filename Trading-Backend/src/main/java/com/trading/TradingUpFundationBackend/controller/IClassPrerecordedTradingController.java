package com.trading.TradingUpFundationBackend.controller;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.ClassPrerecordedTradingDTO;//Package that allows to use an object with the type of data DTO from the entity ClassPrerecordedTrading
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;//Package that allows to use a generic response with a DTO type
import org.springframework.http.ResponseEntity;//Package that allows to use a generic response with a DTO type
import org.springframework.web.bind.annotation.*;//Package that gives the annotations to represent a specific query

/**
 * Interface that creates method without body to be implemented in the controller of the entity ClassPrerecordedTrading
 */
public interface IClassPrerecordedTradingController {

    /**
     * Method without body which creates a class prerecorded with the service ClassPrerecordedTradingServiceImplements
     * @param classPrerecordedTradingDTO The class prerecorded to be created
     * @return An ObjectResponse with answers depending on the result
     */
    @PostMapping()//Annotation that represent the header of an HTTP query that creates a class with a POST query
    ResponseEntity<ObjectResponse> createClassPrerecordedTrading(@RequestBody ClassPrerecordedTradingDTO classPrerecordedTradingDTO);

    /**
     * Method without body which creates a class prerecorded with the service ClassPrerecordedTradingServiceImplements
     * @param classPrerecordedTradingDTO The class prerecorded to be created
     * @return An ObjectResponse with answers depending on the result
     */
    @GetMapping()//Annotation that represent the header of an HTTP query that reads a class with a GET query
    ResponseEntity<ObjectResponse> readClassPrerecordedTrading(@RequestBody ClassPrerecordedTradingDTO classPrerecordedTradingDTO);

    /**
     * Method without body which reads all the prerecorded classes with the service ClassPrerecordedTradingServiceImplements
     * @return An ObjectResponse with answers depending on the result
     */
    @GetMapping()//Annotation that represent the header of an HTTP query that read all the classes with a GET query
    ResponseEntity<ObjectResponse> readClassesPrerecordedTrading();

    /**
     * Method without body which updates a class prerecorded with the service ClassPrerecordedTradingServiceImplements
     * @param classPrerecordedTradingDTO The class prerecorded to be updated
     * @return An ObjectResponse with answers depending on the result
     */
    @PutMapping//Annotation that represent the header of an HTTP query that updates a class with a PUT query
    ResponseEntity<ObjectResponse> updateClassPrerecordedTrading(@RequestBody ClassPrerecordedTradingDTO classPrerecordedTradingDTO);

    /**
     * Method without body which deletes a class prerecorded with the service ClassPrerecordedTradingServiceImplements
     * @param classPrerecordedTradingDTO The class prerecorded to be deleted
     * @return An ObjectResponse with answers depending on the result
     */
    @PostMapping//Annotation that represent the header of an HTTP query that deletes a class with a DELETE query
    ResponseEntity<ObjectResponse> deleteClassPrerecordedTrading(@RequestBody ClassPrerecordedTradingDTO classPrerecordedTradingDTO);
}
