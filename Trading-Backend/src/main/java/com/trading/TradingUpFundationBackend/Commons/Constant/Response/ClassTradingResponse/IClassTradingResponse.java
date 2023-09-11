package com.trading.TradingUpFundationBackend.Commons.Constant.Response.ClassTradingResponse;

/**
 * Interface who represent a response for each possible situation int the manage for the entity "ClassTrading"
 */
public interface IClassTradingResponse {
    String CLASS_REGISTRATION_SUCCESS = "Successful class registration";//If the class could be registered
    String CLASS_REGISTRATION_FAILED = "Failed class registration";//If the class could ot be registered
    String CLASS_NAME_SUCCESS = "Successful book name registration";//If the name of the book could be registered
    String CLASS_NAME_FAILED = "Failed book names registration";//If the name of the book could not be registered
    String CLASS_SUBTITLE_SUCCESS = "Successful book subtitle registration";//If the subtitle of the book could be registered
    String CLASS_SUBTITLE_FAILED = "Failed book subtitle registration";//If the subtitle of the book could not be registered
    String CLASS_DESCRIPTION_SUCCESS = "Successful class description registration";//If the description of the class could be registered
    String CLASS_DESCRIPTION_FAILED = "Failed class description registration";//If the description of the class could not be registered
}
