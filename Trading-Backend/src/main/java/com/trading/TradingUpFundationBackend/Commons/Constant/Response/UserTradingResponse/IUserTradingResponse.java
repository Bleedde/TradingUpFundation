package com.trading.TradingUpFundationBackend.Commons.Constant.Response.UserTradingResponse;
/**
 * Interface who represent a response for each possible situation to the manage of the entity "UserTrading"
 */
public interface IUserTradingResponse {
    String USER_REGISTRATION_SUCCESS = "Successful user registration";//If the user could be registered
    String USER_REGISTRATION_FAILED = "Failed user registration";//If the user could not be registered
    String USER_UPDATED_SUCCESS = "Successfully user updated";
    String USER_UPDATED_FAILED = "Failed user updated";
    String USER_DELETED_SUCCESS = "Successfully user deleted";
    String USER_DELETED_FAILED = "Failed user deleted";
}
