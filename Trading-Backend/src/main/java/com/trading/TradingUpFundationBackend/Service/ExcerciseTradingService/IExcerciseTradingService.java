package com.trading.TradingUpFundationBackend.Service.ExcerciseTradingService;

import com.trading.TradingUpFundationBackend.Commons.Domains.DTO.AdminTradingDTO.AdminTradingDTO;
import com.trading.TradingUpFundationBackend.Commons.Domains.DTO.ExcerciseTradingDTO.ExcerciseTradingDTO;
import com.trading.TradingUpFundationBackend.Commons.Domains.ResponseDTO.GenericResponseDTO;
import org.springframework.http.ResponseEntity;

public interface IExcerciseTradingService {
    ResponseEntity<GenericResponseDTO> createExcerciseTrading(ExcerciseTradingDTO excerciseTradingDTO);
    ResponseEntity<GenericResponseDTO> readExcerciseTrading(ExcerciseTradingDTO excerciseTradingDTO);
    ResponseEntity<GenericResponseDTO> readExcecisesTrading();
    ResponseEntity<GenericResponseDTO> updateExcerciseTrading(ExcerciseTradingDTO excerciseTradingDTO);
    ResponseEntity<GenericResponseDTO> deleteExcerciseTrading(Integer excerciseId);
}
