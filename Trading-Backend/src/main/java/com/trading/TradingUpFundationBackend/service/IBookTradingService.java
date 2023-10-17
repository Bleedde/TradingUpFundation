package com.trading.TradingUpFundationBackend.service;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.BookTradingDTO;//Package who allows the use the DTO of the entity BookTrading
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;//Package who allows the use of a ObjectResponse
import org.springframework.http.ResponseEntity;//Package who allows the manage and the construction of a customized http response

/**
 * Interface that creates the services, who represent the manage of information of the entity BookTrading
 */
public interface IBookTradingService {

    /**
     * Method without body which creates a book
     * @param bookTradingDTO The book to be created
     * @return An ObjectResponse with answers depending on the result
     */
    ResponseEntity<ObjectResponse> createBookTrading(BookTradingDTO bookTradingDTO);

    /**
     * Method without body which reads a book
     * @param bookTradingDTO The book to be read
     * @return An ObjectResponse with answers depending on the result
     */
    ResponseEntity<ObjectResponse> readABookTrading(BookTradingDTO bookTradingDTO);

    /**
     * Method without body which reads all the books
     * @return An ObjectResponse with answers depending on the result
     */
    ResponseEntity<ObjectResponse> readBooksTrading();

    /**
     * Method without body which updates a book
     * @param bookTradingDTO The book to be updated
     * @return An ObjectResponse with answers depending on the result
     */
    ResponseEntity<ObjectResponse> updateBookTrading(BookTradingDTO bookTradingDTO);

    /**
     * Method without body which deletes a book
     * @param bookTradingDTO The book to be deleted
     * @return An ObjectResponse with answers depending on the result
     */
    ResponseEntity<ObjectResponse> deleteBookTrading(Integer id);
}
