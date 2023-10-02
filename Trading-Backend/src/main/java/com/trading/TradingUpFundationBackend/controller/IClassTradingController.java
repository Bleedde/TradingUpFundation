package com.trading.TradingUpFundationBackend.controller;


import com.trading.TradingUpFundationBackend.commons.domains.DTO.ClassTradingDTO;//Package that allows to use an object with the type of data DTO from the entity ClassTrading
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;//Package that allows to use a generic response with a DTO type
import org.springframework.http.ResponseEntity;//Package that allows to use a generic response with a DTO type
import org.springframework.web.bind.annotation.*;//Package that gives the annotations to represent a specific query

/**
 * Interface that creates method without body to be implemented in the controller of the entity ClassTrading
 */
public interface IClassTradingController {
    @PostMapping()//Annotation that represent the header of an HTTP query that creates a class with a POST query
    ResponseEntity<ObjectResponse> createClassTrading(@RequestBody ClassTradingDTO classTradingDTO);//Method that creates a class
    @GetMapping()//Annotation that represent the header of an HTTP query that reads a class with a GET query
    ResponseEntity<ObjectResponse> readClassTrading(@RequestBody ClassTradingDTO classTradingDTO);//Method that reads a class
    @GetMapping()//Annotation that represent the header of an HTTP query that read all the classes with a GET query
    ResponseEntity<ObjectResponse> readClassesTrading();//Method that reads all the classes
    @PutMapping//Annotation that represent the header of an HTTP query that updates a class with a PUT query
    ResponseEntity<ObjectResponse> updateClassTrading(@RequestBody ClassTradingDTO classTradingDTO);//Method that updates a class
    @DeleteMapping//Annotation that represent the header of an HTTP query that deletes a class with a DELETE query
    ResponseEntity<ObjectResponse> deleteBookTrading(@PathVariable Integer classId);//Method that deletes a class
}
