package com.trading.TradingUpFundationBackend.controller;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.BookTradingDTO;//Package that allows to use an object with the type of data DTO from the entity BookTrading
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;//Package that allows to use a generic response with a DTO type
import org.springframework.http.ResponseEntity;//Package that allows to use a generic response with a DTO type
import org.springframework.web.bind.annotation.*;//Package that gives the annotations to represent a specific query

/**
 * Interface that creates method without body to be implemented in the controller of the entity BookTrading
 */
public interface IBookTradingController {

    /**
     * Method without body which creates a book with the service BookTradingServiceImplements
     * @param bookTradingDTO The book to be created
     * @return An ObjectResponse with answers depending on the result
     */
    @PostMapping()//Annotation that represent the header of an HTTP query that creates a book with a POST query
    ResponseEntity<ObjectResponse> createBookTrading(@RequestBody BookTradingDTO bookTradingDTO);

    /**
     * Method without body which reads a book with the service BookTradingServiceImplements
     * @param bookTradingDTO The book to be read
     * @return An ObjectResponse with answers depending on the result
     */
    @GetMapping()//Annotation that represent the header of an HTTP query that reads a book with a GET query
    ResponseEntity<ObjectResponse> readBookTrading(@RequestBody BookTradingDTO bookTradingDTO);

    /**
     * Method without body which reads all the books with the service BookTradingServiceImplements
     * @return An ObjectResponse with answers depending on the result
     */
    @GetMapping()//Annotation that represent the header of an HTTP query that read all the books with a GET query
    ResponseEntity<ObjectResponse> readBooksTrading(Integer level);

    /**
     * Method without body which updates a book with the service BookTradingServiceImplements
     * @param bookTradingDTO The book to be c
     * @return An ObjectResponse with answers depending on the result
     */
    @PutMapping//Annotation that represent the header of an HTTP query that updates a book with a PUT query
    ResponseEntity<ObjectResponse> updateBookTrading(@RequestBody BookTradingDTO bookTradingDTO);

    @DeleteMapping//Annotation that represent the header of an HTTP query that deletes a book with a DELETE query
    ResponseEntity<ObjectResponse> deleteBookTrading(@PathVariable Integer id);//Method that deletes a book
}
