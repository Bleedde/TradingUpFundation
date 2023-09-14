package com.trading.TradingUpFundationBackend.Commons.Constant.Response.LevelTradingResponse;

/**
 * Interface who represent a response for each possible situation for the manage of the entity "LevelTrading"
 */
public interface ILevelTradingResponse {
    String LEVEL_REGISTRATION_SUCCESS = "Successful level registration";//If the level could be registered
    String LEVEL_REGISTRATION_FAILED = "Failed level registration";//If the level could not be registered
    String LEVEL_DELETED_SUCCESS = "Successfully level deleted";
    String LEVEL_DELETED_FAILED = "Failed level deleted";
    String LEVEL_UPDATED_SUCCESS = "Successfully level updated";
    String LEVEL_UPDATED_FAILED = "Failed level updated";
    String LEVEL_SEARCHED_FAILED = "Failed level searched";


}
