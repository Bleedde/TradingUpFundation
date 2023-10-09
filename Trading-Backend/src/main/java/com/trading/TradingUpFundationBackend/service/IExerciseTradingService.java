package com.trading.TradingUpFundationBackend.service;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.ExerciseTradingDTO;//Package who allows the use the DTO of the entity ExerciseTrading
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;//Package who allows the use of a ObjectResponse
import org.springframework.http.ResponseEntity;//Package who allows the manage and the construction of a customized http response

/**
 * Interface that creates the services, who represent the manage of information of the entity ExerciseTrading
 */
public interface IExerciseTradingService {

    /**
     * Method without body which creates an exercise
     * @param exerciseTradingDTO The exercise to be created
     * @return An ObjectResponse with answers depending on the result
     */
    ResponseEntity<ObjectResponse> createExerciseTrading(ExerciseTradingDTO exerciseTradingDTO);

    /**
     * Method without body which reads an exercise
     * @param exerciseTradingDTO The exercise to be readed
     * @return An ObjectResponse with answers depending on the result
     */
    ResponseEntity<ObjectResponse> readExerciseTrading(ExerciseTradingDTO exerciseTradingDTO);

    /**
     * Method without body which reads all the exercises
     * @return An ObjectResponse with answers depending on the result
     */
    ResponseEntity<ObjectResponse> readExercisesTrading();

    /**
     * Method without body which updates an exercise
     * @param exerciseTradingDTO The exercise to be updated
     * @return An ObjectResponse with answers depending on the result
     */
    ResponseEntity<ObjectResponse> updateExerciseTrading(ExerciseTradingDTO exerciseTradingDTO);

    /**
     * Method without body which deletes an exercise
     * @param exerciseTradingDTO The exercise to be deleted
     * @return An ObjectResponse with answers depending on the result
     */
    ResponseEntity<ObjectResponse> deleteExerciseTrading(ExerciseTradingDTO exerciseTradingDTO);
}
