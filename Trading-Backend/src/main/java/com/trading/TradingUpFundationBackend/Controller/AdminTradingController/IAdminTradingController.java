package com.trading.TradingUpFundationBackend.Controller.AdminTradingController;

import com.trading.TradingUpFundationBackend.Commons.Domains.DTO.AdminTradingDTO.AdminTradingDTO;
import com.trading.TradingUpFundationBackend.Commons.Domains.ResponseDTO.GenericResponseDTO;
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
