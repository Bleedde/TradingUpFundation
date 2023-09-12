package com.trading.TradingUpFundationBackend.Service.ContentTradingService.ContentTradingServiceIMPL;

import com.trading.TradingUpFundationBackend.Commons.Converter.ContentTradingConverter.ContentTradingConverter;
import com.trading.TradingUpFundationBackend.Commons.Domains.DTO.ContentTradingDTO.ContentTradingDTO;
import com.trading.TradingUpFundationBackend.Commons.Domains.ResponseDTO.GenericResponseDTO;
import com.trading.TradingUpFundationBackend.Repository.ContentTradingRepository.IContentTradingRepository;
import com.trading.TradingUpFundationBackend.Service.ContentTradingService.IContentTradingService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ContentTradingService implements IContentTradingService {
    @Autowired
    private IContentTradingRepository repository;
    @Autowired
    private ContentTradingConverter converter;

    @Override
    public ResponseEntity<GenericResponseDTO> createContentTrading(ContentTradingDTO contentTradingDTO) {
        return null;
    }

    @Override
    public ResponseEntity<GenericResponseDTO> readContentTrading(ContentTradingDTO contentTradingDTO) {
        return null;
    }

    @Override
    public ResponseEntity<GenericResponseDTO> readContentsTrading() {
        return null;
    }

    @Override
    public ResponseEntity<GenericResponseDTO> updateContentTrading(ContentTradingDTO contentTradingDTO) {
        return null;
    }

    @Override
    public ResponseEntity<GenericResponseDTO> deleteContentTrading(Integer contentId) {
        return null;
    }
}
