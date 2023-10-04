package com.trading.TradingUpFundationBackend.commons.constant.deserializable;

import com.trading.TradingUpFundationBackend.commons.constant.response.Responses;//Package to use a general response created in another package
import com.trading.TradingUpFundationBackend.commons.domains.DTO.BookTradingDTO;//Package to import the DTO object "Book"
import com.trading.TradingUpFundationBackend.commons.domains.entity.BookTradingEntity;//Package to import the entity "Book"
import com.trading.TradingUpFundationBackend.commons.mapper.Mapper;//Package to import yhe object "HelpeperMapper"
import lombok.extern.log4j.Log4j2;//Package who allows log better responses
import org.springframework.stereotype.Component;//Package to represent this class like a component in the spring context

@Component//Annotation to represent this class like a "Bean" or a "Component" in java context
@Log4j2//Annotation to log some messages depending on the context
/**
 * Class to represent the converter between the object "BookTradingEntity" and "BookTradingDTO"
 */
public class BookTradingDeserializable {

    /**
     * Method to turn a object with a type "BookTradingDTO" to an object with type "BookTradingEntity"
     * @param bookTradingDTO The object who is going to turn into a ClassTradingDTO
     * @return The object gave for param converted to a BookTradingEntity type
     */
    public BookTradingEntity convertBookTradingDTOToBookTradingEntity(BookTradingDTO bookTradingDTO){
        BookTradingEntity bookTradingEntity = new BookTradingEntity();
        try {
            bookTradingEntity = Mapper.modelMapper().map(bookTradingDTO, BookTradingEntity.class);
        } catch (Exception e){
            log.error(Responses.INTERNAL_SERVER_ERROR + e);
        }
        return bookTradingEntity;
    }
}
