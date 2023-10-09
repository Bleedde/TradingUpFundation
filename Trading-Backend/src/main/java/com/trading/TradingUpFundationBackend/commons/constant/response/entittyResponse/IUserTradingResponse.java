package com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse;
/**
 * Interface who represent a response for each possible situation to the manage of the entity "UserTrading"
 */
public interface IUserTradingResponse {
    String USER_REGISTRATION_SUCCESS = "Successful user registration";//If the user could be registered
    String USER_REGISTRATION_FAILED = "Failed user registration";//If the user could not be registered
    String USER_UPDATED_SUCCESS = "Successfully user updated";//If the user could be updated
    String USER_UPDATED_FAILED = "Failed user updated";//If the user could not be updated
    String USER_DELETED_SUCCESS = "Successfully user deleted";//If the user could be deleted
    String USER_DELETED_FAILED = "Failed user deleted";//If the user could not be deleted
    String USER_SEARCHED_FAILED = "Failed user searched";//If the user could not be found
    String USER_LOGIN_STATUS_FALSE = "Failed user login, the user status is FALSE";//If the status of the log-in is false
}
