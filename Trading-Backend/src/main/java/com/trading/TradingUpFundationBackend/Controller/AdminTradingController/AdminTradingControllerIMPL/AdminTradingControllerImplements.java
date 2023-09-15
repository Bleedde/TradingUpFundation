package com.trading.TradingUpFundationBackend.Controller.AdminTradingController.AdminTradingControllerIMPL;

import com.trading.TradingUpFundationBackend.Commons.Domains.DTO.AdminTradingDTO.AdminTradingDTO;
import com.trading.TradingUpFundationBackend.Commons.Domains.ResponseDTO.GenericResponseDTO;
import com.trading.TradingUpFundationBackend.Controller.AdminTradingController.IAdminTradingController;
import org.springframework.http.ResponseEntity;

public class AdminTradingControllerImplements implements IAdminTradingController {
    @Override
    public ResponseEntity<GenericResponseDTO> createAdminTrading(AdminTradingDTO adminTradingDTO) {
        return null;
    }

    @Override
    public ResponseEntity<GenericResponseDTO> readAdminTrading(AdminTradingDTO adminTradingDTO) {
        return null;
    }

    @Override
    public ResponseEntity<GenericResponseDTO> readAdminsTrading() {
        return null;
    }

    @Override
    public ResponseEntity<GenericResponseDTO> updateAdminTrading(AdminTradingDTO adminTradingDTO) {
        return null;
    }

    @Override
    public ResponseEntity<GenericResponseDTO> deleteAdminTrading(Integer adminId) {
        return null;
    }
}
