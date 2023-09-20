package com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse;

/**
 * Interface who represent a response for each possible situation int the manage for the entity "ClassTrading"
 */
public interface IClassTradingResponse {
    String CLASS_REGISTRATION_SUCCESS = "Successful class registration";//If the class could be registered
    String CLASS_REGISTRATION_FAILED = "Failed class registration";//If the class could ot be registered
    String CLASS_UPDATED_SUCCESS = "Successfully class updated";//If the class could be updated
    String CLASS_UPDATED_FAILED = "Failed class updated";//If the class could not be updated
    String CLASS_DELETED_SUCCESS = "Successfully class deleted";//If the clas could be deleted
    String CLASS_DELETED_FAILED = "Failed class deleted";//If the clas could not be deleted
    String CLASS_SEARCHED_FAILED = "Failed class searched";//If the class could not be found

}
