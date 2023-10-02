package com.trading.TradingUpFundationBackend.service;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.ClassTradingDTO;//Package who allows the use the DTO of the entity ClassTrading
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;//Package who allows the use of a ObjectResponse
import org.springframework.http.ResponseEntity;//Package who allows the manage and the construction of a customized http response

/**
 * Interface that creates the services, who represent the manage of information of the entity ClassTrading
 */
public interface IClassTradingService {
    ResponseEntity<ObjectResponse> createClassTrading(ClassTradingDTO adminTradingDTO);//Method creating a class
    ResponseEntity<ObjectResponse> readClassTrading(ClassTradingDTO adminTradingDTO);//Method reading a class
    ResponseEntity<ObjectResponse> readClassesTrading();//Method that reads all the classes
    ResponseEntity<ObjectResponse> updateClassTrading(ClassTradingDTO adminTradingDTO);//Method updating a class
    ResponseEntity<ObjectResponse> deleteClassTrading(Integer classId);//Method deleting a class
}
