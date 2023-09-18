package com.trading.TradingUpFundationBackend.controller;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.AdminTradingDTO;
import com.trading.TradingUpFundationBackend.commons.domains.GenericResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface IAdminTradingController {
    @PostMapping()
    ResponseEntity<GenericResponseDTO> createAdminTrading(@RequestBody AdminTradingDTO adminTradingDTO);
    @GetMapping()
    ResponseEntity<GenericResponseDTO> readAdminTrading(@RequestBody AdminTradingDTO adminTradingDTO);
    @GetMapping()
    ResponseEntity<GenericResponseDTO> readAdminsTrading();
    @PutMapping
    ResponseEntity<GenericResponseDTO> updateAdminTrading(@RequestBody AdminTradingDTO adminTradingDTO);
    @DeleteMapping
    ResponseEntity<GenericResponseDTO> deleteAdminTrading(@PathVariable Integer adminId);
}
