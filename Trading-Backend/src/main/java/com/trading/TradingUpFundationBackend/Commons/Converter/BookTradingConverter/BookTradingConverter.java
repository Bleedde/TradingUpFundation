package com.trading.TradingUpFundationBackend.Commons.Converter.BookTradingConverter;

import com.trading.TradingUpFundationBackend.Commons.Constant.Response.GeneralResponse;
import com.trading.TradingUpFundationBackend.Commons.Domains.DTO.BookTradingDTO.BookTradingDTO;
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.BookTradingEntity.BookTradingEntity;
import com.trading.TradingUpFundationBackend.Commons.Helper.HelperMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class BookTradingConverter {
    public BookTradingDTO convertBookTradingEntityToBooktradingDTO(BookTradingEntity bookTradingEntity){
        BookTradingDTO bookTradingDTO = new BookTradingDTO();
        try {
            bookTradingDTO = HelperMapper.modelMapper().map(bookTradingEntity, BookTradingDTO.class);
        } catch (Exception e){
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR + e);
        }
        return bookTradingDTO;
    }

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
