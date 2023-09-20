package com.trading.TradingUpFundationBackend.controller;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.ContentTradingDTO;
import com.trading.TradingUpFundationBackend.commons.domains.GenericResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface IContentTradingController {
    @PostMapping()
    ResponseEntity<GenericResponseDTO> createContentTrading(@RequestBody ContentTradingDTO contentTradingDTO);
    @GetMapping()
    ResponseEntity<GenericResponseDTO> readContentTrading(@RequestBody ContentTradingDTO contentTradingDTO);
    @GetMapping()
    ResponseEntity<GenericResponseDTO> readContentsTrading();
    @PutMapping
    ResponseEntity<GenericResponseDTO> updateContentTrading(@RequestBody ContentTradingDTO contentTradingDTO);
    @DeleteMapping
    ResponseEntity<GenericResponseDTO> deleteContentTrading(@PathVariable Integer contentId);
}
