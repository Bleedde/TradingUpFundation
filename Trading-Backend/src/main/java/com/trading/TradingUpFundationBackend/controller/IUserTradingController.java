package com.trading.TradingUpFundationBackend.controller;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.UserTradingDTO;
import com.trading.TradingUpFundationBackend.commons.domains.GenericResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface IUserTradingController {
    @PostMapping
    ResponseEntity<GenericResponseDTO> createUserTrading(@RequestBody  UserTradingDTO userTradingDTO);
    @GetMapping
    ResponseEntity<GenericResponseDTO> readUserTrading(@RequestBody UserTradingDTO usertradingDTO);
    @GetMapping
    ResponseEntity<GenericResponseDTO> readUsersTrading();
    @PutMapping
    ResponseEntity<GenericResponseDTO> updateUserTrading(@RequestBody UserTradingDTO userTradingDTO);
    @PostMapping
    ResponseEntity<GenericResponseDTO> deleteUserTrading(@RequestBody UserTradingDTO userTradingDTO);
}
