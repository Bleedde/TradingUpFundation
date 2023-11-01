package com.trading.TradingUpFundationBackend.controller.Implements;

import com.trading.TradingUpFundationBackend.commons.constant.URLs.IUserTradingEndPoints;//Package which bring the endpoints of the service UserTrading
import com.trading.TradingUpFundationBackend.commons.domains.DTO.UserTradingDTO;//Package which brings the entity UserTrading converted in a DTO object
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;//Package that creates a response like an object
import com.trading.TradingUpFundationBackend.controller.IUserTradingController;//Importtation of the interface with empty methods IUserController
import com.trading.TradingUpFundationBackend.service.Implements.UserTradingServiceImplements;//Importation of the service LoginTradingServiceImplements

import org.apache.catalina.User;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;//Package that allows the use a response to send data and the information of the actions to the front
import org.springframework.web.bind.annotation.*;//Package that gives the possible methods of an HTTP query

@RestController//Annotation that represents this class like  a controller in the spring context
@RequestMapping(IUserTradingEndPoints.URL_USER)//Annotation which represent this controller with a specific url

/**
 * Controller of the service UserTradingControllerImplements
 * Implements the interface IUserTradingController
 */
public class UserTradingControllerImplements implements IUserTradingController {

    private final UserTradingServiceImplements service;

    /**
     * Constructor that injects dependencies to this class
     * @param service
     */
    public UserTradingControllerImplements(UserTradingServiceImplements service){
        this.service = service;
    }

    @Override
    @PostMapping(IUserTradingEndPoints.URL_USER_LOGIN)
    public ResponseEntity<ObjectResponse> login(@RequestBody UserTradingDTO userTradingDTO){
        return service.login(userTradingDTO);
    }

    /**
     * Method which creates a user using the service LoginTradingServiceImplements
     * @param userTradingDTO The be created
     * @return The method "createUserTrading" from the service
     */
    @Override//Annotation that represent an override for a method in another interface
    @PostMapping(IUserTradingEndPoints.URL_USER_CREATE)//Annotation which represent this method with a specific endPoint
    public ResponseEntity<ObjectResponse> createUserTrading(@RequestBody UserTradingDTO userTradingDTO) {

        return this.service.createUserTrading(userTradingDTO);
    }

    /**
     * Method which reads a user using the service LoginTradingServiceImplements
     * @param id The be read
     * @return The method "readUserTrading" from the service
     */
    @Override//Annotation that represent an override for a method in another interface
    @GetMapping(IUserTradingEndPoints.URL_USER_READ)//Annotation which represent this method with a specific endPoint
    public ResponseEntity<ObjectResponse> readUserTrading(@PathVariable Integer id) {
        return this.service.readUserTrading(id);
    }

    /**
     * Method which reads all the user using the service LoginTradingServiceImplements
     * @return The method "readUsersTrading" from the service
     */
    @Override//Annotation that represent an override for a method in another interface
    @GetMapping(IUserTradingEndPoints.URL_USERS_READ)//Annotation which represent this method with a specific endPoint
    public ResponseEntity<ObjectResponse> readUsersTrading() {
        return this.service.readUsersTrading();
    }

    /**
     * Method which creates a user using the service LoginTradingServiceImplements
     * @param userTradingDTO The be updated
     * @return The method "updtateUserTrading" from the service
     */
    @Override//Annotation that represent an override for a method in another interface
    @PutMapping (IUserTradingEndPoints.URL_USER_UPDATE)//Annotation which represent this method with a specific endPoint
    public ResponseEntity<ObjectResponse> updateUserTrading(@RequestBody UserTradingDTO userTradingDTO) {
        return this.service.updateUserTrading(userTradingDTO);
    }

    /**
     * Method which creates a user using the service LoginTradingServiceImplements
     * @param userTradingDTO The be deleted
     * @return The method "deleteUserTrading" from the service
     */
    @Override//Annotation that represent an override for a method in another interface
    @PostMapping(IUserTradingEndPoints.URL_USER_DELETE)//Annotation which represent this method with a specific endPoint
    public ResponseEntity<ObjectResponse> deleteUserTrading(@RequestBody UserTradingDTO userTradingDTO) {
        return this.service.deleteUserTrading(userTradingDTO);
    }
}