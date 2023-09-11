package com.trading.TradingUpFundationBackend.Service.UserTradingService.UserTradingServiceIMPL;

import com.trading.TradingUpFundationBackend.Commons.Converter.UserTradingConverter.UserTradingConverter;
import com.trading.TradingUpFundationBackend.Repository.UserTradingRepository.IUserTradingRepository;
import com.trading.TradingUpFundationBackend.Service.UserTradingService.IUserTradingService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class UserTradingService implements IUserTradingService {
    @Autowired
    private IUserTradingRepository repository;
    @Autowired
    private UserTradingConverter converter;
}
