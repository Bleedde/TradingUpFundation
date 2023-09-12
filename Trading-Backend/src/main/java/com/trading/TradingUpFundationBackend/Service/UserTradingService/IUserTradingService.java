package com.trading.TradingUpFundationBackend.Service.UserTradingService;

import com.trading.TradingUpFundationBackend.Commons.Domains.DTO.AdminTradingDTO.AdminTradingDTO;
import com.trading.TradingUpFundationBackend.Commons.Domains.DTO.UserTradingDTO.UserTradingDTO;
import com.trading.TradingUpFundationBackend.Commons.Domains.ResponseDTO.GenericResponseDTO;
import org.springframework.http.ResponseEntity;

public interface IUserTradingService {
    ResponseEntity<GenericResponseDTO> createUserTrading(UserTradingDTO userTradingDTO);
    ResponseEntity<GenericResponseDTO> readUserTrading(UserTradingDTO userTradingDTO);
    ResponseEntity<GenericResponseDTO> readUsersTrading();
    ResponseEntity<GenericResponseDTO> updateUserTrading(UserTradingDTO userTradingDTO);
    ResponseEntity<GenericResponseDTO> deleteUserTrading(Integer userId);
}
