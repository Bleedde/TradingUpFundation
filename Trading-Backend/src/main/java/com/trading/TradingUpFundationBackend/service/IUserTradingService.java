package com.trading.TradingUpFundationBackend.service;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.UserTradingDTO;//Package who allows the use the DTO of the entity UserTrading
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;//Package who allows the use of a ObjectResponse
import org.springframework.http.ResponseEntity;//Package who allows the manage and the construction of a customized http response

/**
 * Interface that creates the services, who represent the manage of information of the entity UserTrading
 */
public interface IUserTradingService {

    /**
     * Method without body which creates a user
     * @param userTradingDTO The user to be created
     * @return An ObjectResponse with answers depending on the result
     */
    ResponseEntity<ObjectResponse> createUserTrading(UserTradingDTO userTradingDTO);

    /**
     * Method without body which reads a user
     * @param userTradingDTO The user to be read
     * @return An ObjectResponse with answers depending on the result
     */
    ResponseEntity<ObjectResponse> readUserTrading(Integer id);

    /**
     * Method without body which reads all the users
     * @return An ObjectResponse with answers depending on the result
     */
    ResponseEntity<ObjectResponse> readUsersTrading();

    /**
     * Method without body which updates an user
     * @param userTradingDTO The user to be updated
     * @return An ObjectResponse with answers depending on the result
     */
    ResponseEntity<ObjectResponse> updateUserTrading(UserTradingDTO userTradingDTO);

    /**
     * Method without body which deletes an user
     * @param userTradingDTO The user to be deleted
     * @return An ObjectResponse with answers depending on the result
     */
    ResponseEntity<ObjectResponse> deleteUserTrading(UserTradingDTO userTradingDTO);

}
