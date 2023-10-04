package com.trading.TradingUpFundationBackend.controller;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.UserTradingDTO;//Package that allows to use an object with the type of data DTO from the entity UserTrading
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;//Package that allows to use a generic response with a DTO type
import org.springframework.http.ResponseEntity;//Package that allows to use a generic response with a DTO type
import org.springframework.web.bind.annotation.PostMapping;//Package that gives the annotation PosMapping to represent a POST query

/**
 * Interface that creates method without body to be implemented in the controller of the service LoginTradingService
 */
public interface ILoginController {
    @PostMapping()//Annotation that represent the header of an HTTP query that checks what is the rol of the user
    ResponseEntity<ObjectResponse> login(UserTradingDTO userTradingDTO);//Method that logs an user if it is already registered
}
