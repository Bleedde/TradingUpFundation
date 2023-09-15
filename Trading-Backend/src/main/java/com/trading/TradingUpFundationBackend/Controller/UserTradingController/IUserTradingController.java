package com.trading.TradingUpFundationBackend.Controller.UserTradingController;

import com.trading.TradingUpFundationBackend.Commons.Domains.DTO.UserTradingDTO.UserTradingDTO;
import com.trading.TradingUpFundationBackend.Commons.Domains.ResponseDTO.GenericResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface IUserTradingController {
    @PostMapping
    ResponseEntity<GenericResponseDTO> createUserTrading(@RequestBody UserTradingDTO userTradingDTO);
    @GetMapping
    ResponseEntity<GenericResponseDTO> readUserTrading(@RequestBody UserTradingDTO usertradingDTO);
    @GetMapping
    ResponseEntity<GenericResponseDTO> readUsersTrading();
    @PutMapping
    ResponseEntity<GenericResponseDTO> updateUserTrading(@RequestBody UserTradingDTO userTradingDTO);
    @DeleteMapping
    ResponseEntity<GenericResponseDTO> deleteUserTrading(@PathVariable Integer userId);
}
