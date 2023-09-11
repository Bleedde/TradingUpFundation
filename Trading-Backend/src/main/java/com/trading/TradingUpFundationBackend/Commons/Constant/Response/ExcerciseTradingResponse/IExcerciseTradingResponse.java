package com.trading.TradingUpFundationBackend.Commons.Constant.Response.ExcerciseTradingResponse;
/**
 * Interface who represent a response for each possible situation for the manage of the entity "ExcerciaseTrading"
 */
public interface IExcerciseTradingResponse {
    String EXERCISE_REGISTRATION_SUCCESS = "Successful exercise registration";//If the excercise could be registered
    String EXERCISE_REGISTRATION_FAILED = "Failed exercise registration";//If the excercise could not be registered
    String EXERCISE_TITLE_SUCCESS = "Successful exercise title registration";//If the title of the excercise could be registered
    String EXERCISE_TITLE_FAILED = "Failed exercise title registration";//If the title of the excercise could not be registered
    String EXERCISE_SUBTITLE_SUCCESS = "Successful exercise subtitle registration";//If the subtitle of the excercise could be registered
    String EXERCISE_SUBTITLE_FAILED = "Failed exercise subtitle registration";//If the subtitle of the excercise could not be registered
    String EXERCISE_DESCRIPTION_SUCCESS = "Successful exercise description registration";//If the description of the excercise could be registered
    String EXERCISE_DESCRIPTION_FAILED = "Failed exercise description registration";//If the description could not be registered
    String EXERCISE_DATE_START_SUCCESS = "Successful exercise date start registration";//If the date start fo the excercise could be registered
    String EXERCISE_DATE_START_FAILED = "Failed exercise date end registration";//If the date start of the excercise could not be registered
    String EXERCISE_DATE_END_SUCCESS = "Successful excercise data end registration";//If the date end of the excercise could be registered
    String EXERCISE_DATE_END_FAILED = "Failed exercise data end registration";//If the date end of the excercise could not be registered
}
