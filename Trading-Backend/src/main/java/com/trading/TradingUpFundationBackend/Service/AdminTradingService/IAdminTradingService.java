package com.trading.TradingUpFundationBackend.Service.AdminTradingService;

import com.trading.TradingUpFundationBackend.Commons.Domains.DTO.AdminTradingDTO.AdminTradingDTO;
import com.trading.TradingUpFundationBackend.Commons.Domains.ResponseDTO.GenericResponseDTO;
import org.springframework.http.ResponseEntity;

public interface IAdminTradingService {
    ResponseEntity<GenericResponseDTO> createAdminTrading(AdminTradingDTO adminTradingDTO);
    ResponseEntity<GenericResponseDTO> readAdminTrading(AdminTradingDTO adminTradingDTO);
    ResponseEntity<GenericResponseDTO> readAdminsTrading();
    ResponseEntity<GenericResponseDTO> updateAdminTrading(AdminTradingDTO adminTradingDTO);
    ResponseEntity<GenericResponseDTO> deleteAdminTrading(Integer adminId);
}
