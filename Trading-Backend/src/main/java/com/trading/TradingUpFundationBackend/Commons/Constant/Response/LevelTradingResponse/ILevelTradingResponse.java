package com.trading.TradingUpFundationBackend.Commons.Constant.Response.LevelTradingResponse;

/**
 * Interface who represent a response for each possible situation for the manage of the entity "LevelTrading"
 */
public interface ILevelTradingResponse {
    String LEVEL_REGISTRATION_SUCCESS = "Successful level registration";//If the level could be registered
    String LEVEL_REGISTRATION_FAILED = "Failed level registration";//If the level could not be registered
    String LEVEL_NAME_SUCCESS = "Successful level name registration";//If the name of the level could be registered
    String LEVEL_NAME_FAILED = "Failed level name registration";//If the name of the level could not be registered
    String LEVEL_DATE_START_SUCCESS = "Successful level date start registration";//If the date start of the level could be registered
    String LEVEL_DATE_START_FAILED = "Failed level date start registration";//If the date start of the level could not be registered
    String LEVEL_DATE_END_SUCCESS = "Successful level date end registration";//If the date end of the level could be registered
    String LEVEL_DATE_END_FAILED = "Failed date end registration";//If the date end cof the level could not be registered
    String LEVEL_AMOUNT_SUCCESS = "Successful level amount registration";//If the amount of the level could be registered
    String LEVEL_AMOUNT_FAILED = "Failed level amount registration";//If the amount of the level could not be registered

}
