package com.trading.TradingUpFundationBackend.Commons.Constant.Response.AdminTradingResponse;

/**
 * Interface to represent a response of each possible situation with the manage of the entity "AdminTrading"
 */
public interface IAdminTradingResponse {
    String ADMIN_REGISTRATION_SUCCESS = "Succesful admin registration";//If the admin could be registered
    String ADMIN_REGISTRATION_FAILED = "Failed admin registration";//If the admin could not be registered
    String ADMIN_UPDATE_SUCCESS = "Successfully admin updated";
    String ADMIN_UPDATE_FAILED = "Failed admin updated";
    String ADMIN_DELETE_FAILED = "Failed admin deleted";
    String ADMIN_DELETE_SUCCESS = "Successfully admin deleted";
}
