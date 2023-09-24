package com.trading.TradingUpFundationBackend.service;
import com.trading.TradingUpFundationBackend.commons.domains.DTO.AdminTradingDTO;
import com.trading.TradingUpFundationBackend.commons.domains.GenericResponseDTO;
import com.trading.TradingUpFundationBackend.commons.domains.entity.AdminTradingEntity;
import com.trading.TradingUpFundationBackend.commons.domains.entity.UserTradingEntity;
import com.trading.TradingUpFundationBackend.commons.domains.DTO.UserTradingDTO;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface ILoginTradingService {
    ResponseEntity<GenericResponseDTO> login(UserTradingDTO userTradingDTO);
}
