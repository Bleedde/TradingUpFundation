package com.trading.TradingUpFundationBackend.service;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.UserTradingDTO;
import com.trading.TradingUpFundationBackend.commons.domains.GenericResponseDTO;
import org.springframework.http.ResponseEntity;

public interface IUserTradingService {
    ResponseEntity<GenericResponseDTO> createUserTrading(UserTradingDTO userTradingDTO);
    ResponseEntity<GenericResponseDTO> readUserTrading(UserTradingDTO userTradingDTO);
    ResponseEntity<GenericResponseDTO> readUsersTrading();
    ResponseEntity<GenericResponseDTO> updateUserTrading(UserTradingDTO userTradingDTO);
    ResponseEntity<GenericResponseDTO> deleteUserTrading(UserTradingDTO userTradingDTO);
}
