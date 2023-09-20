package com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse;

/**
 * Interface who represent a response for each possible situation for the manage of the entity "LevelTrading"
 */
public interface ILevelTradingResponse {
    String LEVEL_REGISTRATION_SUCCESS = "Successful level registration";//If the level could be registered
    String LEVEL_REGISTRATION_FAILED = "Failed level registration";//If the level could not be registered
    String LEVEL_DELETED_SUCCESS = "Successfully level deleted";//If the level could be deleted
    String LEVEL_DELETED_FAILED = "Failed level deleted";//If the level could not be deleted
    String LEVEL_UPDATED_SUCCESS = "Successfully level updated";//If the level could be updated
    String LEVEL_UPDATED_FAILED = "Failed level updated";//If the level could not be updated
    String LEVEL_SEARCHED_FAILED = "Failed level searched";//If the level could not be found


}
