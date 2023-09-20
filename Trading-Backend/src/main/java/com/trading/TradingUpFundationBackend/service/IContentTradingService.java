package com.trading.TradingUpFundationBackend.service;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.ContentTradingDTO;
import com.trading.TradingUpFundationBackend.commons.domains.GenericResponseDTO;
import org.springframework.http.ResponseEntity;

public interface IContentTradingService {
    ResponseEntity<GenericResponseDTO> createContentTrading(ContentTradingDTO contentTradingDTO);
    ResponseEntity<GenericResponseDTO> readContentTrading(ContentTradingDTO contentTradingDTO);
    ResponseEntity<GenericResponseDTO> readContentsTrading();
    ResponseEntity<GenericResponseDTO> updateContentTrading(ContentTradingDTO contentTradingDTO);

    ResponseEntity<GenericResponseDTO> deleteContentTrading(Integer contentId);
}
