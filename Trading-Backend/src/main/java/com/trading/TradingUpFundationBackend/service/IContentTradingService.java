package com.trading.TradingUpFundationBackend.service;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.ContentTradingDTO;//Package who allows the use the DTO of the entity ContentTrading
import com.trading.TradingUpFundationBackend.commons.domains.GenericResponseDTO;//Package who allows the use of a GenericResponseDTO
import org.springframework.http.ResponseEntity;//Package who allows the manage and the construction of a customized http response

/**
 * Interface that creates the services, who represent the manage of information of the entity ContentTrading
 */
public interface IContentTradingService {
    ResponseEntity<GenericResponseDTO> createContentTrading(ContentTradingDTO contentTradingDTO);//Method creating a content
    ResponseEntity<GenericResponseDTO> readContentTrading(ContentTradingDTO contentTradingDTO);//Method reading a content
    ResponseEntity<GenericResponseDTO> readContentsTrading();//Method that reads all the contents
    ResponseEntity<GenericResponseDTO> updateContentTrading(ContentTradingDTO contentTradingDTO);//Method updating a content
    ResponseEntity<GenericResponseDTO> deleteContentTrading(Integer contentId);//Method deleting a content
}
