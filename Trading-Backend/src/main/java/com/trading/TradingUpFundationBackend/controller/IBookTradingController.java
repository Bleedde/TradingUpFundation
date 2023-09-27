package com.trading.TradingUpFundationBackend.controller;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.BookTradingDTO;//Package that allows to use an object with the type of data DTO from the entity BookTrading
import com.trading.TradingUpFundationBackend.commons.domains.GenericResponseDTO;//Package that allows to use a generic response with a DTO type
import org.springframework.http.ResponseEntity;//Package that allows to use a generic response with a DTO type
import org.springframework.web.bind.annotation.*;//Package that gives the annotations to represent a specific query

/**
 * Interface that creates method without body to be implemented in the controller of the entity BookTrading
 */
public interface IBookTradingController {
    @PostMapping()//Annotation that represent the header of an HTTP query that creates a book with a POST query
    ResponseEntity<GenericResponseDTO> createBookTrading(@RequestBody BookTradingDTO bookTradingDTO);//Method that creates a book
    @GetMapping()//Annotation that represent the header of an HTTP query that reads a book with a GET query
    ResponseEntity<GenericResponseDTO> readBookTrading(@RequestBody BookTradingDTO bookTradingDTO);//Method that reads a book
    @GetMapping()//Annotation that represent the header of an HTTP query that read all the books with a GET query
    ResponseEntity<GenericResponseDTO> readBooksTrading();//Method that reads all the books
    @PutMapping//Annotation that represent the header of an HTTP query that updates a book with a PUT query
    ResponseEntity<GenericResponseDTO> updateBookTrading(@RequestBody BookTradingDTO bookTradingDTO);//Method that updates a book
    @DeleteMapping//Annotation that represent the header of an HTTP query that deletes a book with a DELETE query
    ResponseEntity<GenericResponseDTO> deleteBookTrading(@PathVariable Integer bookId);//Method that deletes a book
}
