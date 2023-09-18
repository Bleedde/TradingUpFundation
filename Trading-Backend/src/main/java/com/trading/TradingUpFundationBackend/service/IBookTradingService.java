package com.trading.TradingUpFundationBackend.service;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.BookTradingDTO;
import com.trading.TradingUpFundationBackend.commons.domains.GenericResponseDTO;
import org.springframework.http.ResponseEntity;

public interface IBookTradingService {
    ResponseEntity<GenericResponseDTO> createBookTrading(BookTradingDTO bookTradingDTOgDTO);
    ResponseEntity<GenericResponseDTO> readABookTrading(BookTradingDTO bookTradingDTO);
    ResponseEntity<GenericResponseDTO> readBooksTrading();
    ResponseEntity<GenericResponseDTO> updateBookTrading(BookTradingDTO bookTradingDTO);
    ResponseEntity<GenericResponseDTO> deleteBookTrading(Integer bookId);
}
