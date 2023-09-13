package com.trading.TradingUpFundationBackend.Commons.Constant.Response.BookTradingResponse;

/**
 * Interface to represent a response of each possible situation with the manage "BookTrading"
 */
public interface IBookTradingResponse {
    String BOOK_REGISTRATION_SUCCESS = "Successful book registration";//If the book could be registered
    String BOOK_REGISTRATION_FAILED = "Failed book registration";//If the book could be not registered
    String BOOK_DELETED_SUCCESS = "Successfully book eliminated";
    String BOOK_DELETED_FAILED = "Failed book eliminated";
    String BOOK_UPDATED_SUCCESS = "Successfully book updated";
    String BOOK_UPDATE_FAILED = "Failed book updated";
}
