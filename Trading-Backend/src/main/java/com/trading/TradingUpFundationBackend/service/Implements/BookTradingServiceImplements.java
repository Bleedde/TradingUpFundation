package com.trading.TradingUpFundationBackend.service.Implements;

import com.trading.TradingUpFundationBackend.commons.constant.response.Responses;//Package that gives responses to possible situations
import com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse.IBookTradingResponse;//Package that allows the use of the response of the entity BookTrading
import com.trading.TradingUpFundationBackend.commons.constant.deserializable.BookTradingDeserializable;//Package that allows the use of the object BookTradingDeserializable
import com.trading.TradingUpFundationBackend.commons.domains.DTO.BookTradingDTO;//Package that allows to use the serializable version of the entity BookTradingEntity; BookTradingDTO
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;//Package that creates a response like a object
import com.trading.TradingUpFundationBackend.commons.domains.entity.BookTradingEntity;//Package that allows to use the Entity BookTradingEntity
import com.trading.TradingUpFundationBackend.repository.IBookTradingRepository;//Package that allows to use the repository IBookTradingRepository
import com.trading.TradingUpFundationBackend.service.IBookTradingService;//Package that allows the use of the interface "IBookTradingService"
import lombok.extern.log4j.Log4j2;//Package that allows the use of logs to represent a specific message
import org.springframework.beans.factory.annotation.Autowired;//Package that allows the use of the annotation @Autowired to represent the injection of dependencies in the spring context
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;//Package that allows the use of Http codes
import org.springframework.http.ResponseEntity;//Package that allows the creations and use of an Entity's response
import org.springframework.stereotype.Service;//Package that allows the use the annotation @Service to represent this class like a service in the spring context

import java.util.ArrayList;
import java.util.List;//Package that allows the use of dynamic list
import java.util.Optional;//Package that allows the use of the datatype "Optional"

@Service//Annotation who represents this class like a component with type "Service" in the spring context
@Log4j2//Annotation who allows the use of specifics responses
/**
 * Class that represents all the services of the entity "BookTrading"
 */
public class BookTradingServiceImplements implements IBookTradingService {

    private final Environment env;
    private IBookTradingRepository repository;

    private final BookTradingDeserializable converter;

    @Autowired//Annotation that injects the dependencies from the converter related with the entity "BookTrading"
    public BookTradingServiceImplements(BookTradingDeserializable converter, IBookTradingRepository repository, Environment env){
        this.repository = repository;
        this.converter = converter;
        this.env = env;
    }

    /**
     * Method that creates a book
     * @param bookTradingDTO The book to be created
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> createBookTrading(BookTradingDTO bookTradingDTO) {
        try{
            Optional<BookTradingEntity> bookTradingExist = this.repository.findById(bookTradingDTO.getId());
            if (!bookTradingExist.isPresent()) {
                BookTradingEntity entity = this.converter.convertBookTradingDTOToBookTradingEntity(bookTradingDTO);
                this.repository.save(entity);
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_SUCCESS)
                        .objectResponse(IBookTradingResponse.BOOK_REGISTRATION_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            } else{
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL)
                        .objectResponse(IBookTradingResponse.BOOK_REGISTRATION_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        }catch (Exception e){
            log.error(Responses.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ObjectResponse.builder()
                            .message(Responses.INTERNAL_SERVER_ERROR)
                            .objectResponse(null)
                            .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }

    /**
     * Method that reads a book
     * @param bookTradingDTO The book to be read
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> readABookTrading(BookTradingDTO bookTradingDTO) {
        try {
            Optional<BookTradingEntity> bookTradingExist = this.repository.findById(bookTradingDTO.getId());
            if(bookTradingExist.isPresent()){
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_SUCCESS)
                        .objectResponse(bookTradingExist)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            }else{
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL)
                        .objectResponse(IBookTradingResponse.BOOK_SEARCHED_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        }catch (Exception e){
            log.error(Responses.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ObjectResponse.builder()
                            .message(Responses.INTERNAL_SERVER_ERROR)
                            .objectResponse(null)
                            .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }

    }

    /**
     * Method that reads all the books
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> readBooksTrading(Integer level) {
        try {
            List<BookTradingEntity> booksTradingList = this.repository.findAll();
            if (!booksTradingList.isEmpty()){
                List<BookTradingEntity> listForLevel = new ArrayList<>();
                for(BookTradingEntity bookTrading : booksTradingList){
                    if(bookTrading.getLevel() == level){
                        listForLevel.add(bookTrading);
                    }
                }
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_SUCCESS)
                        .objectResponse(listForLevel)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            }else {
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL)
                        .objectResponse(IBookTradingResponse.BOOK_SEARCHED_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        }catch (Exception e) {
            log.error(Responses.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ObjectResponse.builder()
                            .message(Responses.INTERNAL_SERVER_ERROR)
                            .objectResponse(null)
                            .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }

    /**
     * Method that updates a book
     * @param bookTradingDTO The book to be updated
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> updateBookTrading(BookTradingDTO bookTradingDTO) {
        try {
            Optional<BookTradingEntity> inventoryExist = this.repository.findById(bookTradingDTO.getId());
            if (inventoryExist.isPresent()){
                BookTradingEntity inventoryEntity = this.converter.convertBookTradingDTOToBookTradingEntity(bookTradingDTO);
                this.repository.save(inventoryEntity);
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_SUCCESS)
                        .objectResponse(IBookTradingResponse.BOOK_UPDATED_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            }else {
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL)
                        .objectResponse(IBookTradingResponse.BOOK_UPDATE_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        }catch (Exception e) {
            log.error(Responses.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ObjectResponse.builder()
                            .message(Responses.INTERNAL_SERVER_ERROR)
                            .objectResponse(null)
                            .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }

    /**
     * Method that deletes a book
     * @param   id The book to be deleted
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> deleteBookTrading(Integer id) {
        try{
            Optional<BookTradingEntity> bookTradingExist = this.repository.findById(id);
            if(bookTradingExist.isPresent()){
                this.repository.deleteById(bookTradingExist.get().getId());
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_SUCCESS)
                        .objectResponse(IBookTradingResponse.BOOK_DELETED_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            }else{
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL)
                        .objectResponse(IBookTradingResponse.BOOK_DELETED_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        }catch (Exception e){
            log.error(Responses.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ObjectResponse.builder()
                    .message(Responses.INTERNAL_SERVER_ERROR)
                    .objectResponse(null)
                    .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build());
        }
    }
}
