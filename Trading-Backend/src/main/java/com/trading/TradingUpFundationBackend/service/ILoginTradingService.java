package com.trading.TradingUpFundationBackend.service;

import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;//Package who allows the use of a ObjectResponse
import com.trading.TradingUpFundationBackend.commons.domains.DTO.UserTradingDTO;//Package who allows the use the DTO of the entity UserTrading
import org.springframework.http.ResponseEntity;//Package who allows the manage and the construction of a customized http response

/**
 * Interface that creates the services, who represent the manage of information of the service LoginTrading
 */
public interface ILoginTradingService {

    /**
     * Method without body which log-in an user
     * @param userTradingDTO The user to log-in
     * @return An ObjectResponse with answers depending on the result
     */
    ResponseEntity<ObjectResponse> login(UserTradingDTO userTradingDTO);
}
