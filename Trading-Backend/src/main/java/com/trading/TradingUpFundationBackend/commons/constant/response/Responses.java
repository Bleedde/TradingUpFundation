package com.trading.TradingUpFundationBackend.commons.constant.response;

/**
 * interface to represent a response for each possible situation in the services
 */
public interface Responses {
    String OPERATION_SUCCESS = "Successful operation";//Was successfully the operation
    String OPERATION_FAIL = "Failed operation";//Was failed the operation

    String INTERNAL_SERVER_ERROR = "Internal Server error";//If was a server error
}
