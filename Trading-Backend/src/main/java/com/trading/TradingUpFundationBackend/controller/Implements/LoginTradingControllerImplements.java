package com.trading.TradingUpFundationBackend.controller.Implements;

import com.trading.TradingUpFundationBackend.commons.constant.URLs.ILoginEndPoints;//Package which bring the endpoints of the service LoginTrading
import com.trading.TradingUpFundationBackend.commons.domains.DTO.UserTradingDTO;//Package which brings the entity UserTrading converted in a DTO object
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;//Package that creates a response like an object
import com.trading.TradingUpFundationBackend.controller.ILoginController;//Importtation of the interface with empty methods ILoginController
import com.trading.TradingUpFundationBackend.service.Implements.LoginTradingServiceImplements;//Importation of the service LoginTradingServiceImplements

import org.springframework.http.ResponseEntity;//Package that allows the use a response to send data and the information of the actions to the front
import org.springframework.web.bind.annotation.*;//Package that gives the possible methods of an HTTP query

@RestController//Annotation that represents this class like  a controller in the spring context
@RequestMapping(ILoginEndPoints.URL_BASE_LOGIN)//Annotation which represent this controller with a specific url

/**
 * Controller of the service Log-in
 * Implements the interface ILoginTradingController
 */
public class LoginTradingControllerImplements implements ILoginController {

    private final LoginTradingServiceImplements service;

    /**
     * Constructor that injects dependencies to this class
     * @param service
     */
    public LoginTradingControllerImplements(LoginTradingServiceImplements service){
        this.service = service; 
    }

    /**
     * Method which log-in a user using the service LoginTradingServiceImplements
     * @param userTradingDTO The user to log-in
     * @return The method "login" from the service
     */
    @Override//Annotation that represent an override for a method in another interface
    @PostMapping(ILoginEndPoints.URL_LOGIN)//Annotation which represent this method with a specific endPoint
    public ResponseEntity<ObjectResponse> login(@RequestBody UserTradingDTO userTradingDTO) {
        return this.service.login(userTradingDTO);
    }
}