package com.trading.TradingUpFundationBackend.service;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.LevelTradingDTO;
import com.trading.TradingUpFundationBackend.commons.domains.GenericResponseDTO;
import org.springframework.http.ResponseEntity;

public interface ILevelTradingService {
    ResponseEntity<GenericResponseDTO> createLevelTrading(LevelTradingDTO levelTradingDTO);
    ResponseEntity<GenericResponseDTO> readLevelTrading(LevelTradingDTO levelTradingDTO);
    ResponseEntity<GenericResponseDTO> readLevelsTrading();
    ResponseEntity<GenericResponseDTO> updateLevelTrading(LevelTradingDTO levelTradingDTO);
    ResponseEntity<GenericResponseDTO> deleteLevelTrading(Integer levelId);
}
