package com.trading.TradingUpFundationBackend.Service.BookTradingService.BookTradingServiceIMPL;

import com.trading.TradingUpFundationBackend.Commons.Converter.BookTradingConverter.BookTradingConverter;
import com.trading.TradingUpFundationBackend.Repository.BookTradingRepository.IBookTradingRepository;
import com.trading.TradingUpFundationBackend.Service.BookTradingService.IBookTradingService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class BookTradingService implements IBookTradingService {
    @Autowired
    private IBookTradingRepository repository;
    @Autowired
    private BookTradingConverter converter;
}
