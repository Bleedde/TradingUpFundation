package com.trading.TradingUpFundationBackend.service;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.BookTradingDTO;//Package who allows the use the DTO of the entity BookTrading
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;//Package who allows the use of a ObjectResponse
import org.springframework.http.ResponseEntity;//Package who allows the manage and the construction of a customized http response

/**
 * Interface that creates the services, who represent the manage of information of the entity BookTrading
 */
public interface IBookTradingServiceImplements {
    ResponseEntity<ObjectResponse> createBookTrading(BookTradingDTO bookTradingDTOgDTO);//Method creating a book
    ResponseEntity<ObjectResponse> readABookTrading(BookTradingDTO bookTradingDTO);//Method reading a book
    ResponseEntity<ObjectResponse> readBooksTrading();//Method that reads all the books
    ResponseEntity<ObjectResponse> updateBookTrading(BookTradingDTO bookTradingDTO);//Method updating a book
    ResponseEntity<ObjectResponse> deleteBookTrading(BookTradingDTO bookTradingDTO);//Method deleting a book
}
