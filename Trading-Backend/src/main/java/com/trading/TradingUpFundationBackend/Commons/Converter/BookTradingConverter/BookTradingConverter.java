package com.trading.TradingUpFundationBackend.Commons.Converter.BookTradingConverter;

import com.trading.TradingUpFundationBackend.Commons.Constant.Response.GeneralResponse;//Package to use a general response created in another package
import com.trading.TradingUpFundationBackend.Commons.Domains.DTO.BookTradingDTO.BookTradingDTO;//Package to import the DTO object "Book"
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.BookTradingEntity.BookTradingEntity;//Package to import the entity "Book"
import com.trading.TradingUpFundationBackend.Commons.Helper.HelperMapper;//Package to import yhe object "HelpeperMapper"
import lombok.extern.log4j.Log4j2;//Package who allows log better responses
import org.springframework.stereotype.Component;//Package to represent this class like a component in the spring context

@Component//Annotation to represent this class like a "Bean" or a "Component" in java context
@Log4j2//Annotation to log some messages depending on the context
/**
 * Class to represent the converter between the object "BookTradingEntity" and "BookTradingDTO"
 */
public class BookTradingConverter {
    /**
     * Method to turn a object with a type "BookTradingEntity" to an object with type "BookTradingDTO"
     * @param bookTradingEntity The object who is going to turn into a BookTradingDTO
     * @return The object gave for param converted to a BookTradingDTO type
     */
    public BookTradingDTO convertBookTradingEntityToBooktradingDTO(BookTradingEntity bookTradingEntity){
        BookTradingDTO bookTradingDTO = new BookTradingDTO();
        try {
            bookTradingDTO = HelperMapper.modelMapper().map(bookTradingEntity, BookTradingDTO.class);
        } catch (Exception e){
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR + e);
        }
        return bookTradingDTO;
    }

    /**
     * Method to turn a object with a type "BookTradingDTO" to an object with type "BookTradingEntity"
     * @param bookTradingDTO The object who is going to turn into a ClassTradingDTO
     * @return The object gave for param converted to a BookTradingEntity type
     */
    public BookTradingEntity convertBookTradingDTOToBookTradingEntity(BookTradingDTO bookTradingDTO){
        BookTradingEntity bookTradingEntity = new BookTradingEntity();
        try {
            bookTradingEntity = HelperMapper.modelMapper().map(bookTradingDTO, BookTradingEntity.class);
        } catch (Exception e){
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR + e);
        }
        return bookTradingEntity;
    }
}
