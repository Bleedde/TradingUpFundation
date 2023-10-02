package com.trading.TradingUpFundationBackend.service;
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;
import com.trading.TradingUpFundationBackend.commons.domains.DTO.UserTradingDTO;
import org.springframework.http.ResponseEntity;

public interface ILoginTradingService {
    ResponseEntity<ObjectResponse> login(UserTradingDTO userTradingDTO);
}
