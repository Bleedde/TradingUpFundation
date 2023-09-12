package com.trading.TradingUpFundationBackend.Service.ClassTradingService.ClassTradingServiceIMPL;

import com.trading.TradingUpFundationBackend.Commons.Converter.ClassTradingConverter.ClassTradingConverter;
import com.trading.TradingUpFundationBackend.Commons.Domains.DTO.ClassTradingDTO.ClassTradingDTO;
import com.trading.TradingUpFundationBackend.Commons.Domains.ResponseDTO.GenericResponseDTO;
import com.trading.TradingUpFundationBackend.Repository.ClassTradingRepository.IClassTradingRepository;
import com.trading.TradingUpFundationBackend.Service.ClassTradingService.IClassTradingService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ClassTradingService implements IClassTradingService {
    @Autowired
    private IClassTradingRepository repository;
    @Autowired
    private ClassTradingConverter converter;

    @Override
    public ResponseEntity<GenericResponseDTO> createClassTrading(ClassTradingDTO adminTradingDTO) {
        return null;
    }

    @Override
    public ResponseEntity<GenericResponseDTO> readClassTrading(ClassTradingDTO adminTradingDTO) {
        return null;
    }

    @Override
    public ResponseEntity<GenericResponseDTO> readClassesTrading() {
        return null;
    }

    @Override
    public ResponseEntity<GenericResponseDTO> updateClassTrading(ClassTradingDTO adminTradingDTO) {
        return null;
    }

    @Override
    public ResponseEntity<GenericResponseDTO> deleteClassTrading(Integer classId) {
        return null;
    }
}
