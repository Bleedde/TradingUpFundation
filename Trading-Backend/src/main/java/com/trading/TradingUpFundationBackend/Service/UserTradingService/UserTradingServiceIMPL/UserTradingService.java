package com.trading.TradingUpFundationBackend.Service.UserTradingService.UserTradingServiceIMPL;

import com.trading.TradingUpFundationBackend.Commons.Converter.UserTradingConverter.UserTradingConverter;
import com.trading.TradingUpFundationBackend.Commons.Domains.DTO.UserTradingDTO.UserTradingDTO;
import com.trading.TradingUpFundationBackend.Commons.Domains.ResponseDTO.GenericResponseDTO;
import com.trading.TradingUpFundationBackend.Repository.UserTradingRepository.IUserTradingRepository;
import com.trading.TradingUpFundationBackend.Service.UserTradingService.IUserTradingService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class UserTradingService implements IUserTradingService {
    @Autowired
    private IUserTradingRepository repository;
    @Autowired
    private UserTradingConverter converter;

    @Override
    public ResponseEntity<GenericResponseDTO> createUserTrading(UserTradingDTO userTradingDTO) {
        return null;
    }

    @Override
    public ResponseEntity<GenericResponseDTO> readUserTrading(UserTradingDTO userTradingDTO) {
        return null;
    }

    @Override
    public ResponseEntity<GenericResponseDTO> readUsersTrading() {
        return null;
    }

    @Override
    public ResponseEntity<GenericResponseDTO> updateUserTrading(UserTradingDTO userTradingDTO) {
        return null;
    }

    @Override
    public ResponseEntity<GenericResponseDTO> deleteUserTrading(Integer userId) {
        return null;
    }
}
