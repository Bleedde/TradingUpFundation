package com.trading.TradingUpFundationBackend.Service.ClassTradingService;

import com.trading.TradingUpFundationBackend.Commons.Domains.DTO.AdminTradingDTO.AdminTradingDTO;
import com.trading.TradingUpFundationBackend.Commons.Domains.DTO.ClassTradingDTO.ClassTradingDTO;
import com.trading.TradingUpFundationBackend.Commons.Domains.ResponseDTO.GenericResponseDTO;
import org.springframework.http.ResponseEntity;

public interface IClassTradingService {
    ResponseEntity<GenericResponseDTO> createClassTrading(ClassTradingDTO adminTradingDTO);
    ResponseEntity<GenericResponseDTO> readClassTrading(ClassTradingDTO adminTradingDTO);
    ResponseEntity<GenericResponseDTO> readClassesTrading();
    ResponseEntity<GenericResponseDTO> updateClassTrading(ClassTradingDTO adminTradingDTO);
    ResponseEntity<GenericResponseDTO> deleteClassTrading(Integer classId);
}
