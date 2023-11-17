package com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse;

/**
 * Interface to represent a response of each possible situation with the manage "BookTrading"
 */
public interface IBookTradingResponse {
    String BOOK_REGISTRATION_SUCCESS = "Successful book registration";//If the book could be registered
    String BOOK_REGISTRATION_FAILED = "Failed book registration";//If the book could be not registered
    String BOOK_DELETED_SUCCESS = "Successfully book eliminated";//If the book could be deleted
    String BOOK_DELETED_FAILED = "Failed book eliminated";//If the book could not be deleted
    String BOOK_UPDATED_SUCCESS = "Successfully book updated";//If the book could be updated
    String BOOK_UPDATE_FAILED = "Failed book updated";//If the book could not be updated
    String BOOK_SEARCHED_FAILED = "Failed book searched";//If the book could not be found
}
