package com.trading.TradingUpFundationBackend.service;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.LevelTradingDTO;//Package who allows the use the DTO of the entity LevelTrading
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;//Package who allows the use of a ObjectResponse
import org.springframework.http.ResponseEntity;//Package who allows the manage and the construction of a customized http response

/**
 * Interface that creates the services, who represent the manage of information of the entity LevelTrading
 */
public interface ILevelTradingService {
    ResponseEntity<ObjectResponse> createLevelTrading(LevelTradingDTO levelTradingDTO);//Method creating a level
    ResponseEntity<ObjectResponse> readLevelTrading(LevelTradingDTO levelTradingDTO);//Method reading a level
    ResponseEntity<ObjectResponse> readLevelsTrading();//Method that reads all the levels
    ResponseEntity<ObjectResponse> updateLevelTrading(LevelTradingDTO levelTradingDTO);//Method updating a level
    ResponseEntity<ObjectResponse> deleteLevelTrading(Integer levelId);//Method deleting a level
}
