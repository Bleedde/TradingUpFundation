package com.trading.TradingUpFundationBackend.Repository.BookTradingRepository;

import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.BookTradingEntity.BookTradingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookTradingRepository extends JpaRepository<BookTradingEntity, Integer> {
}
