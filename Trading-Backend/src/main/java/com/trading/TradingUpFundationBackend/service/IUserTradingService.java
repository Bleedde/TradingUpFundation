package com.trading.TradingUpFundationBackend.service;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.UserTradingDTO;//Package who allows the use the DTO of the entity UserTrading
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;//Package who allows the use of a ObjectResponse
import org.springframework.http.ResponseEntity;//Package who allows the manage and the construction of a customized http response

/**
 * Interface that creates the services, who represent the manage of information of the entity UserTrading
 */
public interface IUserTradingService {
    ResponseEntity<ObjectResponse> createUserTrading(UserTradingDTO userTradingDTO);//Method creating an user
    ResponseEntity<ObjectResponse> readUserTrading(UserTradingDTO userTradingDTO);//Method reading an user
    ResponseEntity<ObjectResponse> readUsersTrading();//Method that reads all the users
    ResponseEntity<ObjectResponse> updateUserTrading(UserTradingDTO userTradingDTO);//Method updating an user
    ResponseEntity<ObjectResponse> deleteUserTrading(UserTradingDTO userTradingDTO);//Method deleting an user

}
