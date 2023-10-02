package com.trading.TradingUpFundationBackend.controller;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.ExcerciseTradingDTO;//Package that allows to use an object with the type of data DTO from the entity ExerciseTrading
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;//Package that allows to use a generic response with a DTO type
import org.springframework.http.ResponseEntity;//Package that allows to use a generic response with a DTO type
import org.springframework.web.bind.annotation.*;//Package that gives the annotations to represent a specific query

/**
 * Interface that creates method without body to be implemented in the controller of the entity ExerciseTrading
 */
public interface IExcerciseTradingController {
    @PostMapping()//Annotation that represent the header of an HTTP query that creates an exercise with a POST query
    ResponseEntity<ObjectResponse> createExcerciseTrading(@RequestBody ExcerciseTradingDTO excerciseTradingDTO);//Method that creates an exercise
    @GetMapping()//Annotation that represent the header of an HTTP query that reads an exercise with a GET query
    ResponseEntity<ObjectResponse> readExcerciseTrading(@RequestBody ExcerciseTradingDTO excerciseTradingDTO);//Method that reads an exercise
    @GetMapping()//Annotation that represent the header of an HTTP query that read all the exercises with a GET query
    ResponseEntity<ObjectResponse> readExcercisesTrading();//Method that reads all the exercises
    @PutMapping//Annotation that represent the header of an HTTP query that updates an exercise with a PUT query
    ResponseEntity<ObjectResponse> updateExcerciseTrading(@RequestBody ExcerciseTradingDTO excerciseTradingDTO);//Method that updates an exercise
    @DeleteMapping//Annotation that represent the header of an HTTP query that deletes an exercise with a DELETE query
    ResponseEntity<ObjectResponse> deleteExcerciseTrading(@PathVariable Integer excerciseId);//Method that deletes an exercise
}
