package com.trading.TradingUpFundationBackend.service;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.ClassTradingDTO;
import com.trading.TradingUpFundationBackend.commons.domains.GenericResponseDTO;
import org.springframework.http.ResponseEntity;

public interface IClassTradingService {
    ResponseEntity<GenericResponseDTO> createClassTrading(ClassTradingDTO adminTradingDTO);
    ResponseEntity<GenericResponseDTO> readClassTrading(ClassTradingDTO adminTradingDTO);
    ResponseEntity<GenericResponseDTO> readClassesTrading();
    ResponseEntity<GenericResponseDTO> updateClassTrading(ClassTradingDTO adminTradingDTO);
    ResponseEntity<GenericResponseDTO> deleteClassTrading(Integer classId);
}
