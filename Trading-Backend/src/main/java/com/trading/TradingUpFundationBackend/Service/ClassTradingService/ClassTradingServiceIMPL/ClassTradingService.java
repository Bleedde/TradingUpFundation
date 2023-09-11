package com.trading.TradingUpFundationBackend.Service.ClassTradingService.ClassTradingServiceIMPL;

import com.trading.TradingUpFundationBackend.Commons.Converter.ClassTradingConverter.ClassTradingConverter;
import com.trading.TradingUpFundationBackend.Repository.ClassTradingRepository.IClassTradingRepository;
import com.trading.TradingUpFundationBackend.Service.ClassTradingService.IClassTradingService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ClassTradingService implements IClassTradingService {
    @Autowired
    private IClassTradingRepository repository;
    @Autowired
    private ClassTradingConverter converter;
}
