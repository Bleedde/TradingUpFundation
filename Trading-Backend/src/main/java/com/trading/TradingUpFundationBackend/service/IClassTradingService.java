package com.trading.TradingUpFundationBackend.service;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.ClassTradingDTO;//Package who allows the use the DTO of the entity ClassTrading
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;//Package who allows the use of a ObjectResponse
import org.springframework.http.ResponseEntity;//Package who allows the manage and the construction of a customized http response

/**
 * Interface that creates the services, who represent the manage of information of the entity ClassTrading
 */
public interface IClassTradingService {

    /**
     * Method without body which creates a class
     * @param adminTradingDTO The class to be created
     * @return An ObjectResponse with answers depending on the result
     */
    ResponseEntity<ObjectResponse> createClassTrading(ClassTradingDTO adminTradingDTO);

    /**
     * Method without body which reads a class
     * @param adminTradingDTO The class to be read
     * @return An ObjectResponse with answers depending on the result
     */
    ResponseEntity<ObjectResponse> readClassTrading(ClassTradingDTO adminTradingDTO);

    /**
     * Method without body which reads all the classes
     * @return An ObjectResponse with answers depending on the result
     */
    ResponseEntity<ObjectResponse> readClassesTrading(Integer level);

    /**
     * Method without body which updates a class
     * @param adminTradingDTO The class to be updated
     * @return An ObjectResponse with answers depending on the result
     */
    ResponseEntity<ObjectResponse> updateClassTrading(ClassTradingDTO adminTradingDTO);

    /**
     * Method without body which deletes a class
     * @param id The id of the class to be deleted
     * @return An ObjectResponse with answers depending on the result
     */
    ResponseEntity<ObjectResponse> deleteClassTrading(Integer id);
}
