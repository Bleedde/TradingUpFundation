package com.trading.TradingUpFundationBackend.Service.LevelTradingService;

import com.trading.TradingUpFundationBackend.Commons.Domains.DTO.AdminTradingDTO.AdminTradingDTO;
import com.trading.TradingUpFundationBackend.Commons.Domains.DTO.LevelTradingDTO.LevelTradingDTO;
import com.trading.TradingUpFundationBackend.Commons.Domains.ResponseDTO.GenericResponseDTO;
import org.springframework.http.ResponseEntity;

public interface ILevelTradingService {
    ResponseEntity<GenericResponseDTO> createLevelTrading(LevelTradingDTO levelTradingDTO);
    ResponseEntity<GenericResponseDTO> readLevelTrading(LevelTradingDTO levelTradingDTO);
    ResponseEntity<GenericResponseDTO> readLevelsTrading();
    ResponseEntity<GenericResponseDTO> updateLevelTrading(LevelTradingDTO levelTradingDTO);
    ResponseEntity<GenericResponseDTO> deleteLevelTrading(Integer levelId);
}
