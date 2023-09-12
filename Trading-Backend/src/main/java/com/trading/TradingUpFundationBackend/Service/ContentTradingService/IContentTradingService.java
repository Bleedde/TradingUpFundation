package com.trading.TradingUpFundationBackend.Service.ContentTradingService;

import com.trading.TradingUpFundationBackend.Commons.Domains.DTO.AdminTradingDTO.AdminTradingDTO;
import com.trading.TradingUpFundationBackend.Commons.Domains.DTO.ContentTradingDTO.ContentTradingDTO;
import com.trading.TradingUpFundationBackend.Commons.Domains.ResponseDTO.GenericResponseDTO;
import org.springframework.http.ResponseEntity;

public interface IContentTradingService {
    ResponseEntity<GenericResponseDTO> createContentTrading(ContentTradingDTO contentTradingDTO);
    ResponseEntity<GenericResponseDTO> readContentTrading(ContentTradingDTO contentTradingDTO);
    ResponseEntity<GenericResponseDTO> readContentsTrading();
    ResponseEntity<GenericResponseDTO> updateContentTrading(ContentTradingDTO contentTradingDTO);

    ResponseEntity<GenericResponseDTO> deleteContentTrading(Integer contentId);
}
