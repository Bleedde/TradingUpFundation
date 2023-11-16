package com.trading.TradingUpFundationBackend.commons.constant.URLs;
/**
 * Interface who contains the endpoints for each controller for the entity BookTrading
 */
public interface IBookTradingEndPoints {
    String URL_BOOK = "/book";//Go to the book area
    String URL_BOOK_CREATE = "/book_create";//Create a book area
    String URL_BOOK_DELETE = "/book_delete{id}";//Delete a book area
    String URL_BOOK_UPDATE = "/book_update";//Update a book area
    String URL_BOOK_READ = "/book_read{id}";//Search a book area
    String URL_BOOKS_READ = "/books_read{level}";//Search all the books area
    String URL_BOOK_FILE = "/book_file{id}";
    String URL_BOOK_IMAGE = "/book_image{id}";
}