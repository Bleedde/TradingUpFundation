package com.trading.TradingUpFundationBackend.Repository.ContentTradingRepository;

import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.ContentTradingEntity.ContentTradingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContentTradingRepository extends JpaRepository<ContentTradingEntity, Integer> {
}
