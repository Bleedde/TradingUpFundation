package com.trading.TradingUpFundationBackend.Service.ExcerciseTradingService.ExcerciseTradingServiceIMPL;

import com.trading.TradingUpFundationBackend.Commons.Converter.ExcerciseTradingConverter.ExcerciseTradingConverter;
import com.trading.TradingUpFundationBackend.Commons.Domains.DTO.ExcerciseTradingDTO.ExcerciseTradingDTO;
import com.trading.TradingUpFundationBackend.Commons.Domains.ResponseDTO.GenericResponseDTO;
import com.trading.TradingUpFundationBackend.Repository.ExcerciseTradingRepository.IExcerciseTradingRepository;
import com.trading.TradingUpFundationBackend.Service.ExcerciseTradingService.IExcerciseTradingService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ExcerciseTradingService implements IExcerciseTradingService {
    @Autowired
    private IExcerciseTradingRepository repository;
    @Autowired
    private ExcerciseTradingConverter converter;

    @Override
    public ResponseEntity<GenericResponseDTO> createExcerciseTrading(ExcerciseTradingDTO excerciseTradingDTO) {
        return null;
    }

    @Override
    public ResponseEntity<GenericResponseDTO> readExcerciseTrading(ExcerciseTradingDTO excerciseTradingDTO) {
        return null;
    }

    @Override
    public ResponseEntity<GenericResponseDTO> readExcercisesTrading() {
        return null;
    }

    @Override
    public ResponseEntity<GenericResponseDTO> updateExcerciseTrading(ExcerciseTradingDTO excerciseTradingDTO) {
        return null;
    }

    @Override
    public ResponseEntity<GenericResponseDTO> deleteExcerciseTrading(Integer excerciseId) {
        return null;
    }
}
