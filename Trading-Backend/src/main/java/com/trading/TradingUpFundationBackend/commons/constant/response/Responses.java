package com.trading.TradingUpFundationBackend.commons.constant.response;

/**
 * interface to represent a response for each possible situation in the services
 */
public interface Responses {
    String OPERATION_SUCCESS = "Successful operation";//Was succesfull the operation
    String OPERATION_FAIL = "Failed operation";//Was failed the operation
    String CREATE_SUCCESS = "Was created correctly";//If the object was created correctly
    String CREATE_FAIL = "Wasn't created, was a problem";//If was a problem with the creation of the object
    String METHOD_FAIL = "Was a mistake with the HTTP method";//If was a problem with the HTTP method
    String NOT_FOUND = "Operation failed, we cant find the object";//If the searched of the object was not successful
    String INTERNAL_SERVER_ERROR = "Internal Server error";//If was a server error
}
