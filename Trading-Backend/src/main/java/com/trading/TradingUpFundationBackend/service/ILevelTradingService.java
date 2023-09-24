package com.trading.TradingUpFundationBackend.service;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.LevelTradingDTO;//Package who allows the use the DTO of the entity LevelTrading
import com.trading.TradingUpFundationBackend.commons.domains.GenericResponseDTO;//Package who allows the use of a GenericResponseDTO
import org.springframework.http.ResponseEntity;//Package who allows the manage and the construction of a customized http response

/**
 * Interface that creates the services, who represent the manage of information of the entity LevelTrading
 */
public interface ILevelTradingService {
    ResponseEntity<GenericResponseDTO> createLevelTrading(LevelTradingDTO levelTradingDTO);//Method creating a level
    ResponseEntity<GenericResponseDTO> readLevelTrading(LevelTradingDTO levelTradingDTO);//Method reading a level
    ResponseEntity<GenericResponseDTO> readLevelsTrading();//Method that reads all the levels
    ResponseEntity<GenericResponseDTO> updateLevelTrading(LevelTradingDTO levelTradingDTO);//Method updating a level
    ResponseEntity<GenericResponseDTO> deleteLevelTrading(Integer levelId);//Method deleting a level
}
