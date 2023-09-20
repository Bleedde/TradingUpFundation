package com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse;

/**
 * Interface to represent a response of each possible situation with the manage of the entity "AdminTrading"
 */
public interface IAdminTradingResponse {
    String ADMIN_REGISTRATION_SUCCESS = "Succesful admin registration";//If the admin could be registered
    String ADMIN_REGISTRATION_FAILED = "Failed admin registration";//If the admin could not be registered
    String ADMIN_UPDATE_SUCCESS = "Successfully admin updated";//If the admin could be updated
    String ADMIN_UPDATE_FAILED = "Failed admin updated";//If the admin could not be updated
    String ADMIN_DELETE_FAILED = "Failed admin deleted";//If the admin could not be deleted
    String ADMIN_DELETE_SUCCESS = "Successfully admin deleted";//If the admin could be deleted
    String ADMIN_SEARCHED_FAILED = "Failed admin searched";//If the admin could not be found
}
