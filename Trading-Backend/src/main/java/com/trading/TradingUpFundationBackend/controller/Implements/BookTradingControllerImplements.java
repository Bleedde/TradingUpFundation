package com.trading.TradingUpFundationBackend.controller.Implements;

import com.trading.TradingUpFundationBackend.commons.constant.URLs.IBookTradingEndPoints;//Package which gives the urls for the entity BookTrading
import com.trading.TradingUpFundationBackend.commons.domains.DTO.BookTradingDTO;//Package that allows to use the serializable version of the entity BookTradingEntity; BookTradingDTO
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;//Package that creates a response like a object
import com.trading.TradingUpFundationBackend.controller.IBookTradingController;//Package which implements the interface IBookTradingController
import com.trading.TradingUpFundationBackend.service.Implements.BookTradingServiceImplements;//Package which bring the service of the entity BookTrading

import org.springframework.http.ResponseEntity;//Package that allows the use the annotation @Service to represent this class like a service in the spring context
import org.springframework.web.bind.annotation.*;//Package that gives the possible methods of an HTTP query

@RestController//Annotation that represents this class like  a controller in the spring context
@RequestMapping(IBookTradingEndPoints.URL_BOOK)//Annotation which represent this controller with a specific url

/**
 * Controller of the entity BookTrading
 * Implements the interface IBookTradingController
 */
public class BookTradingControllerImplements implements IBookTradingController {

    private final BookTradingServiceImplements service;//Attribute which creates an unique instance of the service BookTradingServiceImplements

    /**
     * Constructor that injects dependencies to this class
     * @param service
     */
    public BookTradingControllerImplements(BookTradingServiceImplements service) {
        this.service = service;
    }

    /**
     * Method which creates a book using the service BookTradingServiceImplements
     * @param bookTradingDTO The book to be created
     * @return The method "createBookTrading" from the service
     */
    @Override//Annotation that represent an override for a method in another interface
    @PostMapping(IBookTradingEndPoints.URL_BOOK_CREATE)
    public ResponseEntity<ObjectResponse> createBookTrading(@RequestBody BookTradingDTO bookTradingDTO) {
        return this.service.createBookTrading(bookTradingDTO);
    }

    /**
     * Method which reads a book using the service BookTradingServiceImplements
     * @param bookTradingDTO The book to be read
     * @return The method "readBookTrading" from the service
     */
    @Override//Annotation that represent an override for a method in another interface
    @GetMapping(IBookTradingEndPoints.URL_BOOK_READ)
    public ResponseEntity<ObjectResponse> readBookTrading(@RequestBody BookTradingDTO bookTradingDTO) {
        return this.service.readABookTrading(bookTradingDTO);
    }

    /**
     * Method which reads a book using the service BookTradingServiceImplements
     * @return The method "readBooksTrading" from the service
     */
    @Override//Annotation that represent an override for a method in another interface
    @GetMapping(IBookTradingEndPoints.URL_BOOKS_READ)
    public ResponseEntity<ObjectResponse> readBooksTrading(@PathVariable Integer level) {
        return this.service.readBooksTrading(level);
    }

    /**
     * Method which updates a book using the service BookTradingServiceImplements
     * @param bookTradingDTO The book to be updated
     * @return The method "updatedBookTrading" from the service
     */
    @Override//Annotation that represent an override for a method in another interface
    @PutMapping(IBookTradingEndPoints.URL_BOOK_UPDATE)
    public ResponseEntity<ObjectResponse> updateBookTrading(@RequestBody BookTradingDTO bookTradingDTO) {
        return this.service.updateBookTrading(bookTradingDTO);
    }

    /**
     * Method which deletes a book using the service BookTradingServiceImplements
     * @param id The book to be deleted
     * @return The method "deleteBookTrading" from the service
     */
    @Override//Annotation that represent an override for a method in another interface
    @DeleteMapping(IBookTradingEndPoints.URL_BOOK_DELETE)
    public ResponseEntity<ObjectResponse> deleteBookTrading(@PathVariable Integer id) {
        return this.service.deleteBookTrading(id);
    }
}
