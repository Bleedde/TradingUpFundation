package com.trading.TradingUpFundationBackend.controller;

import com.trading.TradingUpFundationBackend.commons.constant.endPoints.ILoginEndPoints;
import com.trading.TradingUpFundationBackend.commons.domains.DTO.UserTradingDTO;
import com.trading.TradingUpFundationBackend.commons.domains.GenericResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

public interface ILoginController {
    @GetMapping(ILoginEndPoints.URL_LOGIN)
    ResponseEntity<GenericResponseDTO> login(UserTradingDTO userTradingDTO);
}
