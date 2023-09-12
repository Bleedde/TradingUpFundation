package com.trading.TradingUpFundationBackend.Service.BookTradingService;

import com.trading.TradingUpFundationBackend.Commons.Domains.DTO.AdminTradingDTO.AdminTradingDTO;
import com.trading.TradingUpFundationBackend.Commons.Domains.DTO.BookTradingDTO.BookTradingDTO;
import com.trading.TradingUpFundationBackend.Commons.Domains.ResponseDTO.GenericResponseDTO;
import org.springframework.http.ResponseEntity;

public interface IBookTradingService {
    ResponseEntity<GenericResponseDTO> createBookTrading(BookTradingDTO bookTradingDTOgDTO);
    ResponseEntity<GenericResponseDTO> readABookTrading(BookTradingDTO bookTradingDTO);
    ResponseEntity<GenericResponseDTO> readBooksTrading();
    ResponseEntity<GenericResponseDTO> updateBookTrading(BookTradingDTO bookTradingDTO);
    ResponseEntity<GenericResponseDTO> deleteBookTrading(Integer bookId);
}
