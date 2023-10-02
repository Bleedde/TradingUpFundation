package com.trading.TradingUpFundationBackend.service;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.ExcerciseTradingDTO;//Package who allows the use the DTO of the entity ExerciseTrading
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;//Package who allows the use of a ObjectResponse
import org.springframework.http.ResponseEntity;//Package who allows the manage and the construction of a customized http response

/**
 * Interface that creates the services, who represent the manage of information of the entity ExerciseTrading
 */
public interface IExcerciseTradingService {
    ResponseEntity<ObjectResponse> createExcerciseTrading(ExcerciseTradingDTO excerciseTradingDTO);//Method creating an exercise
    ResponseEntity<ObjectResponse> readExcerciseTrading(ExcerciseTradingDTO excerciseTradingDTO);//Method reading an exercise
    ResponseEntity<ObjectResponse> readExcecisesTrading();//Method that reads all the exercises
    ResponseEntity<ObjectResponse> updateExcerciseTrading(ExcerciseTradingDTO excerciseTradingDTO);//Method updating an exercise
    ResponseEntity<ObjectResponse> deleteExcerciseTrading(Integer excerciseId);//Method deleting an exercise
}
