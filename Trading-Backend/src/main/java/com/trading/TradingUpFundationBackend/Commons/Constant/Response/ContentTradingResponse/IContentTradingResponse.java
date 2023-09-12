package com.trading.TradingUpFundationBackend.Commons.Constant.Response.ContentTradingResponse;

/**
 * Interface who represent a response for each possible situation for the manage for the entity "ContentTrading"
 */
public interface IContentTradingResponse {
    String CONTENT_REGISTRATION_SUCCESS = "Successful content registration";//If the content could be registered
    String CONTENT_REGISTRATION_FAILED = "Failed content registration";//If the content could not be registered
    String CONTENT_TITLE_SUCCESS = "Successful content title registration";//If the title of the content could be registered
    String CONTENT_TITLE_FAILED = "Failed content title registration";//If the title of the content could not be registered
    String CONTENT_SUBTITLE_SUCCESS = "Successful content subtitle registration";//If the subtitle of the content could be registered
    String CONTENT_SUBTITLE_FAILED = "Failed content subtitle registration";//If the subtitle of the content could not be registered
    String CONTENT_DESCRIPTION_SUCCESS = "Successful content description registration";//If the description of the content could be registered
    String CONTENT_DESCRIPTION_FAILED = "Failed content description registration";//If the description of the content could not be registered
    String CONTENT_URL_VIDEO_SUCCESS = "Successful content url video registration";//If the url of the content could be registered
    String CONTENT_URL_VIDEO_FAILED = "Failed content url video registration";//If the url of the content could not be registered
}
