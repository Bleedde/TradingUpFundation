package com.trading.TradingUpFundationBackend.controller;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.ClassPrerecordedTradingDTO;
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IClassPrerecordedTradingController {
    @PostMapping()//Annotation that represent the header of an HTTP query that creates a class with a POST query
    ResponseEntity<ObjectResponse> createClassPrerecordedTrading(@RequestBody ClassPrerecordedTradingDTO classPrerecordedTradingDTO);//Method that creates a class
    @GetMapping()//Annotation that represent the header of an HTTP query that reads a class with a GET query
    ResponseEntity<ObjectResponse> readClassPrerecordedTrading(@RequestBody ClassPrerecordedTradingDTO classPrerecordedTradingDTO);//Method that reads a class
    @GetMapping()//Annotation that represent the header of an HTTP query that read all the classes with a GET query
    ResponseEntity<ObjectResponse> readClassesPrerecordedTrading();//Method that reads all the classes
    @PutMapping
//Annotation that represent the header of an HTTP query that updates a class with a PUT query
    ResponseEntity<ObjectResponse> updateClassPrerecordedTrading(@RequestBody ClassPrerecordedTradingDTO classPrerecordedTradingDTO);//Method that updates a class
    @PostMapping//Annotation that represent the header of an HTTP query that deletes a class with a DELETE query
    ResponseEntity<ObjectResponse> deleteClassPrerecordedTrading(@RequestBody ClassPrerecordedTradingDTO classPrerecordedTradingDTO);//Method that deletes a class
}
