package com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse;

/**
 * Interface who represent a response for each possible situation for the manage for the entity "ContentTrading"
 */
public interface IContentTradingResponse {
    String CONTENT_REGISTRATION_SUCCESS = "Successful content registration";//If the content could be registered
    String CONTENT_REGISTRATION_FAILED = "Failed content registration";//If the content could not be registered
    String CONTENT_UPDATE_SUCCESS = "Successfully content updated";//If the content could be updated
    String CONTENT_UPDATE_FAILED = "Failed content updated";//If the content could not be updated
    String CONTENT_DELETE_SUCCESS = "Successfully content deleted";//If the content could be deleted
    String CONTENT_DELETED_FAILED = "Failed content deleted";//If the content could not be deleted3
    String CONTENT_SEARCHED_FAILED = "Failed content searched";//If the content could not de found
}
