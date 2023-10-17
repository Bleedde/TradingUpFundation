package com.trading.TradingUpFundationBackend.controller;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.ExerciseSolutionTradingDTO;
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IExerciseSolutionTradingController {
    /**
     * Method without body which creates an exercise solution with the service ExerciseSolutionTradingServiceImplements
     * @param exerciseSolutionTradingDTO The exercise solution to be created
     * @return An ObjectResponse with answers depending on the result
     */
    @PostMapping()//Annotation that represent the header of an HTTP query that creates an exercise with a POST query
    ResponseEntity<ObjectResponse> createExerciseSolutionTrading(@RequestBody ExerciseSolutionTradingDTO exerciseSolutionTradingDTO);

    /**
     * Method without body which reads an exercise solution with the service ExerciseSolutionTradingServiceImplements
     * @param exerciseSolutionTradingDTO The exercise solution to be read
     * @return An ObjectResponse with answers depending on the result
     */
    @GetMapping()//Annotation that represent the header of an HTTP query that reads an exercise with a GET query
    ResponseEntity<ObjectResponse> readExerciseSolutionTrading(@RequestBody ExerciseSolutionTradingDTO exerciseSolutionTradingDTO);

    /**
     * Method without body which reads all the exercise solutions with the service ExerciseSolutionTradingServiceImplements
     * @return An ObjectResponse with answers depending on the result
     */
    @GetMapping()//Annotation that represent the header of an HTTP query that read all the exercises with a GET query
    ResponseEntity<ObjectResponse> readExerciseSolutionsTrading();
}
