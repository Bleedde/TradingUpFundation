package com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse;

/**
 * Interface to represent a response of each possible situation with the manage "ClassPrerecordedTrading"
 */
public interface IClassPrerecordedeTradingResponse {
    String CLASS_PRERECORDED_REGISTRATION_SUCCESS = "Successful class prerecorded registration";//If the class prerecorded could be registered
    String CLASS_PRERECORDED_REGISTRATION_FAILED = "Failed class prerecorded registration";//If the class prerecorded could not be registered
    String CLASS_PRERECORDED_UPDATE_SUCCESS = "Successful class prerecorded update";//If the class prerecorded could be updated
    String CLASS_PRERECORDED_UPDATE_FAILED = "Failed class prerecorded update";//If the class prerecorded could not be updated
    String CLASS_PRERECORDED_DELETE_SUCCESS = "Succesfull class prerecorded deleted";//If the class prerecorded could be deleted
    String CLASS_PRERECORDED_DELETE_FAILED = "Failed class prerecorded deleted";//If the class prerecorded could not be deleted
    String CLASS_PRERECORDED_SEARCHED_FAILED = "Failed class prerecorded searched";//If the class prerecorded could not be found
}
