package com.trading.TradingUpFundationBackend.Repository.BookTradingRepository;

import com.trading.TradingUpFundationBackend.Domains.Entity.BookTradingEntity.BookTrading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookTradingRepository extends JpaRepository<Integer, BookTrading> {
}
