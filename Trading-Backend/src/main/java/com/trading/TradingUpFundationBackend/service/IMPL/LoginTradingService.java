package com.trading.TradingUpFundationBackend.service.IMPL;

import com.trading.TradingUpFundationBackend.commons.constant.response.GeneralResponse;
import com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse.Converter.UserTradingConverter;
import com.trading.TradingUpFundationBackend.commons.domains.DTO.AdminTradingDTO;
import com.trading.TradingUpFundationBackend.commons.domains.DTO.UserTradingDTO;
import com.trading.TradingUpFundationBackend.commons.domains.GenericResponseDTO;
import com.trading.TradingUpFundationBackend.commons.domains.entity.AdminTradingEntity;
import com.trading.TradingUpFundationBackend.commons.domains.entity.UserTradingEntity;
import com.trading.TradingUpFundationBackend.repository.IAdminTradingRepository;
import com.trading.TradingUpFundationBackend.repository.IUserTradingRepository;
import com.trading.TradingUpFundationBackend.service.ILoginTradingService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
@Log4j2
@Service
public class LoginTradingService implements ILoginTradingService {

    @Autowired
    private IUserTradingRepository userRepository;
    @Autowired
    private UserTradingConverter userConverter;
    @Autowired
    private IAdminTradingRepository adminRepository;

    @Override
    public Optional<UserTradingEntity> loginUser(UserTradingDTO userTradingDTO) {
        try {
            Optional<UserTradingEntity> userTradingExist = this.userRepository.findByEmail(userTradingDTO.getEmail());
            if(userTradingExist.isPresent()){
                return userTradingExist;
            }else {
                log.error("User dont found in database", userTradingExist);
                return Optional.empty();
            }
        }catch (Exception e){
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR, e);
            return Optional.empty();
        }
    }

    @Override
    public Optional<AdminTradingEntity> loginAdmin(AdminTradingDTO adminTradingDTO) {
        try {
            Optional<AdminTradingEntity> adminTradingExist = this.adminRepository.findByEmail(adminTradingDTO.getEmail());
            if (adminTradingExist.isPresent()){
                return adminTradingExist;
            }else {
            log.error("Admin didnt find in database", adminTradingExist);
            return Optional.empty();
            }
        }catch (Exception e){
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR, e);
            return Optional.empty();
        }
    }

    @Override
    public ResponseEntity<GenericResponseDTO> login(Optional<UserTradingDTO> userTradingDTO, Optional<AdminTradingDTO> adminTradingDTO) {
        return null;
    }
}
