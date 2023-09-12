package com.trading.TradingUpFundationBackend.Commons.Constant.Response.UserTradingResponse;
/**
 * Interface who represent a response for each possible situation to the manage of the entity "UserTrading"
 */
public interface IUserTradingResponse {
    String USER_REGISTRATION_SUCCESS = "Successful user registration";//If the user could be registered
    String USER_REGISTRATION_FAILED = "Failed user registration";//If the user could not be registered
    String USER_NAME_SUCCESS = "Successful user names registration";//If the name odf the user could be registered
    String USER_NAME_FAILED = "Failed user name registration";//If the name of the user could not e registered
    String USER_PASSWORD_SUCCESS = "Successful user password registration";//If the password of the user could be registered
    String USER_PASSWORD_FAILED = "Failed user password registration";//If the password of the user could not be registered
    String USER_LEVEL_SUCCESS = "Successful user level registration";//If the level of the user could be registered
    String USER_LEVEL_FAILED = "Failed user level registration";//If the level of the user could not be registered
    String USER_STATUS_SUCCESS = "Successful user status registration";//If the user of the user could be registered
    String USER_STATUS_FAILED = "Failed user status registration";//If the status of the user could not be registered
    String USER_BACKTESTING_SUCCESS = "Successful user backesting registration";//If the backtesting of the user could e registered
    String USER_BACKTESTING_FAILED = "Failed user backtesting registration";//If the backtesting ofd the user could not be registered
    String USER_AUDITED_ACCOUNT_SUCCESS = "Successful user audited account registration";//If the audited account of the user could be registered
    String USER_AUDITED_ACCOUNT_FAILED = "Failed user audited account registration";//If the audited account of the user could not be registered
}
