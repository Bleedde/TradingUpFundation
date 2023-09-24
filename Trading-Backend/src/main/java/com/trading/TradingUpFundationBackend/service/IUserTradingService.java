package com.trading.TradingUpFundationBackend.service;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.UserTradingDTO;//Package who allows the use the DTO of the entity UserTrading
import com.trading.TradingUpFundationBackend.commons.domains.GenericResponseDTO;//Package who allows the use of a GenericResponseDTO
import org.springframework.http.ResponseEntity;//Package who allows the manage and the construction of a customized http response

/**
 * Interface that creates the services, who represent the manage of information of the entity UserTrading
 */
public interface IUserTradingService {
    ResponseEntity<GenericResponseDTO> createUserTrading(UserTradingDTO userTradingDTO);//Method creating an user
    ResponseEntity<GenericResponseDTO> readUserTrading(UserTradingDTO userTradingDTO);//Method reading an user
    ResponseEntity<GenericResponseDTO> readUsersTrading();//Method that reads all the users
    ResponseEntity<GenericResponseDTO> updateUserTrading(UserTradingDTO userTradingDTO);//Method updating an user
    ResponseEntity<GenericResponseDTO> deleteUserTrading(UserTradingDTO userTradingDTO);//Method deleting an user
}
