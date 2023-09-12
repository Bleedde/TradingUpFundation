package com.trading.TradingUpFundationBackend.Service.LevelTradingService.LevelTradingServiceIMPL;

import com.trading.TradingUpFundationBackend.Commons.Converter.LevelTradingConverter.LevelTradingConverter;
import com.trading.TradingUpFundationBackend.Commons.Domains.DTO.LevelTradingDTO.LevelTradingDTO;
import com.trading.TradingUpFundationBackend.Commons.Domains.ResponseDTO.GenericResponseDTO;
import com.trading.TradingUpFundationBackend.Repository.LevelTradingRepository.ILevelTradingRepository;
import com.trading.TradingUpFundationBackend.Service.LevelTradingService.ILevelTradingService;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class LevelTradingService implements ILevelTradingService {
    @Autowired
    private ILevelTradingRepository repository;
    @Autowired
    private LevelTradingConverter converter;

    @Override
    public ResponseEntity<GenericResponseDTO> createLevelTrading(LevelTradingDTO levelTradingDTO) {
        return null;
    }

    @Override
    public ResponseEntity<GenericResponseDTO> readLevelTrading(LevelTradingDTO levelTradingDTO) {
        return null;
    }

    @Override
    public ResponseEntity<GenericResponseDTO> readLevelsTrading() {
        return null;
    }

    @Override
    public ResponseEntity<GenericResponseDTO> updateLevelTrading(LevelTradingDTO levelTradingDTO) {
        return null;
    }

    @Override
    public ResponseEntity<GenericResponseDTO> deleteLevelTrading(Integer levelId) {
        return null;
    }
}
