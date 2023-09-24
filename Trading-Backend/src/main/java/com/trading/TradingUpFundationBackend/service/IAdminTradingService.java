package com.trading.TradingUpFundationBackend.service;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.AdminTradingDTO;//Package who allows the use the DTO of the entity AdminTrading
import com.trading.TradingUpFundationBackend.commons.domains.GenericResponseDTO;//Package who allows the use of a GenericResponseDTO
import org.springframework.http.ResponseEntity;//Package who allows the manage and the construction of a customized http response

/**
 * Interface that creates the services, who represent the manage of information of the entity AdminTrading
 */
public interface IAdminTradingService {
    ResponseEntity<GenericResponseDTO> createAdminTrading(AdminTradingDTO adminTradingDTO);//Method creating an admin
    ResponseEntity<GenericResponseDTO> readAdminTrading(AdminTradingDTO adminTradingDTO);//Method reading ad admin
    ResponseEntity<GenericResponseDTO> readAdminsTrading();//Method that reads all the admins
    ResponseEntity<GenericResponseDTO> updateAdminTrading(AdminTradingDTO adminTradingDTO);//Method updating an admin
    ResponseEntity<GenericResponseDTO> deleteAdminTrading(AdminTradingDTO adminTradingDTO);//Method deleting an admin
}
