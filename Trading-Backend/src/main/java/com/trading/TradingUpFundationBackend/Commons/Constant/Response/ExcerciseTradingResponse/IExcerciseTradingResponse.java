package com.trading.TradingUpFundationBackend.Commons.Constant.Response.ExcerciseTradingResponse;
/**
 * Interface who represent a response for each possible situation for the manage of the entity "ExcerciaseTrading"
 */
public interface IExcerciseTradingResponse {
    String EXERCISE_REGISTRATION_SUCCESS = "Successful exercise registration";//If the exercise could be registered
    String EXERCISE_REGISTRATION_FAILED = "Failed exercise registration";//If the exercise could not be registered
    String EXERCISE_UPDATE_SUCCESS = "Successfully exercise updated";
    String EXERCISE_UPDATE_FAILED = "Failed exercise updated";
    String EXERCISE_DELETE_SUCCESS = "Successfully exercise deleted";
    String EXERCISE_DELETED_FAILED = "Failed exercise deleted";
    String EXERCISE_SEARCHED_FAILED = "Failed exercise searched";
}
