package com.trading.TradingUpFundationBackend.controller;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.BookTradingDTO;
import com.trading.TradingUpFundationBackend.commons.domains.GenericResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface IBookTradingController {
    @PostMapping()
    ResponseEntity<GenericResponseDTO> createBookTrading(@RequestBody BookTradingDTO bookTradingDTO);
    @GetMapping()
    ResponseEntity<GenericResponseDTO> readBookTrading(@RequestBody BookTradingDTO bookTradingDTO);
    @GetMapping()
    ResponseEntity<GenericResponseDTO> readBooksTrading();
    @PutMapping
    ResponseEntity<GenericResponseDTO> updateBookTrading(@RequestBody BookTradingDTO bookTradingDTO);
    @DeleteMapping
    ResponseEntity<GenericResponseDTO> deleteBookTrading(@PathVariable Integer bookId);
}
