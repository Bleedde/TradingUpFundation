package com.trading.TradingUpFundationBackend.service.IMPL;

import com.trading.TradingUpFundationBackend.commons.constant.response.Responses;
import com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse.IUserTradingResponse;
import com.trading.TradingUpFundationBackend.commons.domains.DTO.UserTradingDTO;
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;
import com.trading.TradingUpFundationBackend.commons.domains.entity.UserTradingEntity;
import com.trading.TradingUpFundationBackend.repository.IUserTradingRepository;
import com.trading.TradingUpFundationBackend.service.ILoginTradingService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
@Log4j2
@Service
public class LoginTradingService implements ILoginTradingService {

    @Autowired
    private IUserTradingRepository repository;


    @Override
    public ResponseEntity<ObjectResponse> login(UserTradingDTO userTradingDTO) {
        try {
            Optional<UserTradingEntity> userTradingExist = this.repository.findByEmail(userTradingDTO.getEmail());
            if (userTradingExist.isPresent() && userTradingExist.get().getPassword().equals(userTradingDTO.getPassword())) {
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_SUCCESS + " I am " + userTradingExist.get().getUserRole())
                        .objectResponse(userTradingExist)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL)
                        .objectResponse(IUserTradingResponse.USER_SEARCHED_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        } catch (Exception e) {
            log.error(Responses.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ObjectResponse.builder()
                    .message(Responses.INTERNAL_SERVER_ERROR)
                    .objectResponse(null)
                    .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build());
        }
    }
}
