package com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse;

/**
 * Interface who represent a response for each possible situation of the manage to the entity "RegistrationEntity"
 */
public interface IRegistrationTradingResponse {
    String REGISTRATION_REGISTRATION_SUCCESS = "Successful registration registration";//If the registration could be registered
    String REGISTRATION_REGISTRATION_FAILED = "Failed registration registration";//If the registration could not be registered
    String REGISTRATION_UPDATED_SUCCESS = "Successfully registration updated";//If the registration could be updated
    String REGISTRATION_UPDATED_FAILED = "Failed registration updated";//If the registration could not be updated
    String REGISTRATION_DELETED_SUCCESS = "Successfully registration deleted";//If the registration could be deleted
    String REGISTRATION_DELETED_FAILED = "Failed registration deleted";//If the registration could not be deleted
    String REGISTRATION_SEARCHED_FAILED = "Failed registration searched";//If the registration could not be found
}
