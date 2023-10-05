package com.trading.TradingUpFundationBackend.service;

import org.springframework.http.ResponseEntity;

import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;
import com.trading.TradingUpFundationBackend.commons.domains.DTO.ClassPrerecordedTradingDTO;

public interface IClassPrerecordedTradingService {
    ResponseEntity<ObjectResponse> createClassPrerecordedTrading(ClassPrerecordedTradingDTO ClassPrerecordedTradingDTO);
    ResponseEntity<ObjectResponse> readClassPrerecordedTrading(ClassPrerecordedTradingDTO classPrerecordedTradingDTO);
    ResponseEntity<ObjectResponse> readAllClassesPrerecordedTrading();
    ResponseEntity<ObjectResponse> updateClassPrerecordedtrading(ClassPrerecordedTradingDTO classPrerecordedTradingDTO);
    ResponseEntity<ObjectResponse> deleteClassPrerecordedTrading(ClassPrerecordedTradingDTO classPrerecordedTradingDTO);
}