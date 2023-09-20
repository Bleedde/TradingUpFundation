package com.trading.TradingUpFundationBackend.controller;


import com.trading.TradingUpFundationBackend.commons.domains.DTO.ClassTradingDTO;
import com.trading.TradingUpFundationBackend.commons.domains.GenericResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface IClassTradingController {
    @PostMapping()
    ResponseEntity<GenericResponseDTO> createClassTrading(@RequestBody ClassTradingDTO classTradingDTO);
    @GetMapping()
    ResponseEntity<GenericResponseDTO> readClassTrading(@RequestBody ClassTradingDTO classTradingDTO);
    @GetMapping()
    ResponseEntity<GenericResponseDTO> readClassesTrading();
    @PutMapping
    ResponseEntity<GenericResponseDTO> updateClassTrading(@RequestBody ClassTradingDTO classTradingDTO);
    @DeleteMapping
    ResponseEntity<GenericResponseDTO> deleteBookTrading(@PathVariable Integer classId);
}
