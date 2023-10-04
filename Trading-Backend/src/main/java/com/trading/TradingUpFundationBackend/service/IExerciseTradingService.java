package com.trading.TradingUpFundationBackend.service;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.ExerciseTradingDTO;//Package who allows the use the DTO of the entity ExerciseTrading
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;//Package who allows the use of a ObjectResponse
import org.springframework.http.ResponseEntity;//Package who allows the manage and the construction of a customized http response

/**
 * Interface that creates the services, who represent the manage of information of the entity ExerciseTrading
 */
public interface IExerciseTradingService {
    ResponseEntity<ObjectResponse> createExerciseTrading(ExerciseTradingDTO exerciseTradingDTO);//Method creating an exercise
    ResponseEntity<ObjectResponse> readExerciseTrading(ExerciseTradingDTO exerciseTradingDTO);//Method reading an exercise
    ResponseEntity<ObjectResponse> readExercisesTrading();//Method that reads all the exercises
    ResponseEntity<ObjectResponse> updateExerciseTrading(ExerciseTradingDTO exerciseTradingDTO);//Method updating an exercise
    ResponseEntity<ObjectResponse> deleteExerciseTrading(Integer exerciseId);//Method deleting an exercise
}
