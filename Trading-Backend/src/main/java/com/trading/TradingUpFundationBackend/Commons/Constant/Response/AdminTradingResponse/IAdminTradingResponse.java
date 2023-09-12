package com.trading.TradingUpFundationBackend.Commons.Constant.Response.AdminTradingResponse;

/**
 * Interface to represent a response of each possible situation with the manage of the entity "AdminTrading"
 */
public interface IAdminTradingResponse {
    String ADMIN_REGISTRATION_SUCCESS = "Succesful admin registration";//If the admin could be registered
    String ADMIN_REGISTRATION_FAILED = "Failed admin registration";//If the admin could not be registered
    String ADMIN_NAME_SUCCESS = "Successful admin name registration";//If the name of the admin could be
    String ADMIN_NAME_FAILED = "Failed admin name registration";//If the name of the admin could not be registered
    String ADMIN_EMAIL_SUCCESS = "Successful admin email registration";//If the email of the admin could be registered
    String ADMIN_EMAIL_FAILED = "Failed admin email registration";//If the email of the admin could not be registered
    String ADMIN_PASSWORD_SUCCESS = "Successful admin password registration";//If the password of the admin could be registered
    String ADMIN_PASSWORD_FAILED = "Failed admin password registration";//If the password of the admin could not be registered
}
