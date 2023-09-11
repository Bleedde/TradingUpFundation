package com.trading.TradingUpFundationBackend.Service.ContentTradingService.ContentTradingServiceIMPL;

import com.trading.TradingUpFundationBackend.Commons.Converter.ContentTradingConverter.ContentTradingConverter;
import com.trading.TradingUpFundationBackend.Repository.ContentTradingRepository.IContentTradingRepository;
import com.trading.TradingUpFundationBackend.Service.ContentTradingService.IContentTradingService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ContentTradingService implements IContentTradingService {
    @Autowired
    private IContentTradingRepository repository;
    @Autowired
    private ContentTradingConverter converter;
}
