package com.trading.TradingUpFundationBackend.controller;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.LevelTradingDTO;
import com.trading.TradingUpFundationBackend.commons.domains.GenericResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface ILevelTradingController {
    @PostMapping()
    ResponseEntity<GenericResponseDTO> createLevelTrading(@RequestBody LevelTradingDTO levelTradingDTO);
    @GetMapping()
    ResponseEntity<GenericResponseDTO> readLevelTrading(@RequestBody LevelTradingDTO levelTradingDTO);
    @GetMapping()
    ResponseEntity<GenericResponseDTO> readLevelsTrading();
    @PutMapping
    ResponseEntity<GenericResponseDTO> updateLevelTrading(@RequestBody LevelTradingDTO levelTradingDTO);
    @DeleteMapping
    ResponseEntity<GenericResponseDTO> deleteLevelTrading(@PathVariable Integer levelId);
}
