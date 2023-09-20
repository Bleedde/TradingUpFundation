package com.trading.TradingUpFundationBackend.service;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.ExcerciseTradingDTO;
import com.trading.TradingUpFundationBackend.commons.domains.GenericResponseDTO;
import org.springframework.http.ResponseEntity;

public interface IExcerciseTradingService {
    ResponseEntity<GenericResponseDTO> createExcerciseTrading(ExcerciseTradingDTO excerciseTradingDTO);
    ResponseEntity<GenericResponseDTO> readExcerciseTrading(ExcerciseTradingDTO excerciseTradingDTO);
    ResponseEntity<GenericResponseDTO> readExcecisesTrading();
    ResponseEntity<GenericResponseDTO> updateExcerciseTrading(ExcerciseTradingDTO excerciseTradingDTO);
    ResponseEntity<GenericResponseDTO> deleteExcerciseTrading(Integer excerciseId);
}
