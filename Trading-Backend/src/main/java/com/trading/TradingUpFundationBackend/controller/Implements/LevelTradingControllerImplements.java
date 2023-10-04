package com.trading.TradingUpFundationBackend.controller.Implements;

import org.springframework.http.ResponseEntity;

import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;
import com.trading.TradingUpFundationBackend.commons.domains.DTO.LevelTradingDTO;
import com.trading.TradingUpFundationBackend.controller.ILevelTradingController;
import com.trading.TradingUpFundationBackend.service.IMPL.LevelTradingService;

public class LevelTradingControllerImplements implements ILevelTradingController{

    private final LevelTradingService service;
    public LevelTradingControllerImplements(LevelTradingService service){
        this.service = service;
    }

    @Override
    public ResponseEntity<ObjectResponse> createLevelTrading(LevelTradingDTO levelTradingDTO) {
        return this.service.createLevelTrading(levelTradingDTO);
    }

    @Override
    public ResponseEntity<ObjectResponse> readLevelTrading(LevelTradingDTO levelTradingDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readLevelTrading'");
    }

    @Override
    public ResponseEntity<ObjectResponse> readLevelsTrading() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readLevelsTrading'");
    }

    @Override
    public ResponseEntity<ObjectResponse> updateLevelTrading(LevelTradingDTO levelTradingDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateLevelTrading'");
    }

    @Override
    public ResponseEntity<ObjectResponse> deleteLevelTrading(LevelTradingDTO levelTradingDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteLevelTrading'");
    }
}
