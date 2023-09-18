package com.trading.TradingUpFundationBackend.controller;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.ExcerciseTradingDTO;
import com.trading.TradingUpFundationBackend.commons.domains.GenericResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface IExcerciseTradingController {
    @PostMapping()
    ResponseEntity<GenericResponseDTO> createExcerciseTrading(@RequestBody ExcerciseTradingDTO excerciseTradingDTO);
    @GetMapping()
    ResponseEntity<GenericResponseDTO> readExcerciseTrading(@RequestBody ExcerciseTradingDTO excerciseTradingDTO);
    @GetMapping()
    ResponseEntity<GenericResponseDTO> readExcercisesTrading();
    @PutMapping
    ResponseEntity<GenericResponseDTO> updateExcerciseTrading(@RequestBody ExcerciseTradingDTO excerciseTradingDTO);
    @DeleteMapping
    ResponseEntity<GenericResponseDTO> deleteExcerciseTrading(@PathVariable Integer excerciseId);
}
