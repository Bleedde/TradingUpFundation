package com.trading.TradingUpFundationBackend.controller;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.ExerciseTradingDTO;//Package that allows to use an object with the type of data DTO from the entity ExerciseTrading
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;//Package that allows to use a generic response with a DTO type
import org.springframework.http.ResponseEntity;//Package that allows to use a generic response with a DTO type
import org.springframework.web.bind.annotation.*;//Package that gives the annotations to represent a specific query

/**
 * Interface that creates method without body to be implemented in the controller of the entity ExerciseTrading
 */
public interface IExerciseTradingController {

    /**
     * Method without body which creates an exercise with the service ExerciseTradingServiceImplements
     * @param exerciseTradingDTO The exercise to be created
     * @return An ObjectResponse with answers depending on the result
     */
    @PostMapping()//Annotation that represent the header of an HTTP query that creates an exercise with a POST query
    ResponseEntity<ObjectResponse> createExerciseTrading(@RequestBody ExerciseTradingDTO exerciseTradingDTO);

    /**
     * Method without body which reads an exercise with the service ExerciseTradingServiceImplements
     * @param exerciseTradingDTO The exercise to be read
     * @return An ObjectResponse with answers depending on the result
     */
    @GetMapping()//Annotation that represent the header of an HTTP query that reads an exercise with a GET query
    ResponseEntity<ObjectResponse> readExerciseTrading(@RequestBody ExerciseTradingDTO exerciseTradingDTO);

    /**
     * Method without body which reads all the exercises with the service ExerciseTradingServiceImplements
     * @return An ObjectResponse with answers depending on the result
     */
    @GetMapping()//Annotation that represent the header of an HTTP query that read all the exercises with a GET query
    ResponseEntity<ObjectResponse> readExercisesTrading();

    /**
     * Method without body which updates a exercise with the service ExerciseTradingServiceImplements
     * @param exerciseTradingDTO The class prerecorded to be updated
     * @return An ObjectResponse with answers depending on the result
     */
    @PutMapping//Annotation that represent the header of an HTTP query that updates an exercise with a PUT query
    ResponseEntity<ObjectResponse> updateExerciseTrading(@RequestBody ExerciseTradingDTO exerciseTradingDTO);

    /**
     * Method without body which deletes a class with the service ExerciseTradingServiceImplements
     * @param exerciseTradingDTO The class prerecorded to be deleted
     * @return An ObjectResponse with answers depending on the result
     */
    @DeleteMapping//Annotation that represent the header of an HTTP query that deletes an exercise with a DELETE query
    ResponseEntity<ObjectResponse> deleteExerciseTrading(@PathVariable ExerciseTradingDTO exerciseTradingDTO);
}
