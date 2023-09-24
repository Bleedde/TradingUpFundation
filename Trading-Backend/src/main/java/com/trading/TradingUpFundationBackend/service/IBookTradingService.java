package com.trading.TradingUpFundationBackend.service;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.BookTradingDTO;//Package who allows the use the DTO of the entity BookTrading
import com.trading.TradingUpFundationBackend.commons.domains.GenericResponseDTO;//Package who allows the use of a GenericResponseDTO
import org.springframework.http.ResponseEntity;//Package who allows the manage and the construction of a customized http response

/**
 * Interface that creates the services, who represent the manage of information of the entity BookTrading
 */
public interface IBookTradingService {
    ResponseEntity<GenericResponseDTO> createBookTrading(BookTradingDTO bookTradingDTOgDTO);//Method creating a book
    ResponseEntity<GenericResponseDTO> readABookTrading(BookTradingDTO bookTradingDTO);//Method reading a book
    ResponseEntity<GenericResponseDTO> readBooksTrading();//Method that reads all the books
    ResponseEntity<GenericResponseDTO> updateBookTrading(BookTradingDTO bookTradingDTO);//Method updating a book
    ResponseEntity<GenericResponseDTO> deleteBookTrading(Integer bookId);//Method deleting a book
}
