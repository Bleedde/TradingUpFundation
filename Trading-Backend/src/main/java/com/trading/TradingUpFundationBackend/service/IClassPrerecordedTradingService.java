package com.trading.TradingUpFundationBackend.service;

import org.springframework.http.ResponseEntity;//Package who allows the manage and the construction of a customized http response

import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;//Package who allows the use of a ObjectResponse
import com.trading.TradingUpFundationBackend.commons.domains.DTO.ClassPrerecordedTradingDTO;//Package who allows the use the DTO of the entity ClassPrerecordedTrading

/**
 * Interface that creates the services, who represent the manage of information of the entity ClassPrerecordedTrading
 */
public interface IClassPrerecordedTradingService {

    /**
     * Method without body which creates a class prerecorded
     * @param ClassPrerecordedTradingDTO The class prerecorded to be created
     * @return An ObjectResponse with answers depending on the result
     */
    ResponseEntity<ObjectResponse> createClassPrerecordedTrading(ClassPrerecordedTradingDTO ClassPrerecordedTradingDTO);

    /**
     * Method without body which read a class prerecorded
     * @param classPrerecordedTradingDTO The class prerecorded to be read
     * @return An ObjectResponse with answers depending on the result
     */
    ResponseEntity<ObjectResponse> readClassPrerecordedTrading(ClassPrerecordedTradingDTO classPrerecordedTradingDTO);

    /**
     * Method without body which reads all the classes prerecorded
     * @return An ObjectResponse with answers depending on the result
     */
    ResponseEntity<ObjectResponse> readAllClassesPrerecordedTrading(Integer level);

    /**
     * Method without body which updates a class prerecorded
     * @param classPrerecordedTradingDTO The class prerecorded to be updated
     * @return An ObjectResponse with answers depending on the result
     */
    ResponseEntity<ObjectResponse> updateClassPrerecordedTrading(ClassPrerecordedTradingDTO classPrerecordedTradingDTO);

    /**
     * Method without body which deleted a class prerecorded
     * @param classPrerecordedTradingDTO The class prerecorded to be deleted
     * @return An ObjectResponse with answers depending on the result
     */
    ResponseEntity<ObjectResponse> deleteClassPrerecordedTrading(Integer id);
}