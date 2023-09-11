package com.trading.TradingUpFundationBackend.Commons.Constant.Response.BookTradingResponse;

/**
 * Interface to represent a response of each possible situation with the manage "BookTrading"
 */
public interface IBookTradingResponse {
    String BOOK_REGISTRATION_SUCCESS = "Successful book registration";//If the book could be registered
    String BOOK_REGISTRATION_FAILED = "Failed book registration";//If the book could be not registered
    String BOOK_NAME_REGISTRATION = "Successful book name registration";//If the name of the book could be registered
    String BOOK_NAME_FAILED = "Failed book name registration";//if the name of the book could be not registered
    String BOOK_DESCRIPTION_SUCCESS = "Successful book description registration";//If the description of the book could be registered
    String BOOK_DESCRIPTION_FAILED = "Failed book description registration";//If the description of the book could be not registered
    String BOOK_IMAGE_SUCCESS = "Successful book image registration";//If the image of the book could be registered
    String BOOK_IMAGE_FAILED = "Failed book image registration";//If the image of the book could be not registered
    String BOOK_FILES_SUCCESS = "Successful book file registration";//If the file of the book could be registered
    String BOOK_FILE_FAILED = "Failed book file registration";//If the file of the book could be not registered
}
