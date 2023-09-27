package com.trading.TradingUpFundationBackend.service;
import com.trading.TradingUpFundationBackend.commons.domains.GenericResponseDTO;
import com.trading.TradingUpFundationBackend.commons.domains.DTO.UserTradingDTO;
import org.springframework.http.ResponseEntity;

public interface ILoginTradingService {
    ResponseEntity<GenericResponseDTO> login(UserTradingDTO userTradingDTO);
}
