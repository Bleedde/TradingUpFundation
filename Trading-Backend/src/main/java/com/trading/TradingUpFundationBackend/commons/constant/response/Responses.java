package com.trading.TradingUpFundationBackend.commons.constant.response;

/**
 * interface to represent a response for each possible situation in the services
 */
public interface Responses {
    String OPERATION_SUCCESS = "Successful operation";
    String OPERATION_FAIL = "Failed operation";
    String CREATE_SUCCESS = "Was created correctly";
    String CREATE_FAIL = "Wasn't created, was a problem";
    String METHOD_FAIL = "Was a mistake with the HTTP method";
    String NOT_FOUND = "Operation failed, we cant find the object";
    String INTERNAL_SERVER_ERROR = "Internal Server error";
}
