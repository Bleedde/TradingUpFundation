package com.trading.TradingUpFundationBackend.Repository.ContentTradingRepository;

import com.trading.TradingUpFundationBackend.Domains.Entity.ContentTradingEntity.ContentTrading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContentTradingRepository extends JpaRepository<Integer, ContentTrading> {
}
