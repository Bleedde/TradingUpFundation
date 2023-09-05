package com.trading.TradingUpFundationBackend.Repository.LevelTradingRepository;

import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.LevelTradingEntity.LevelTradingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILevelTradingRepository extends JpaRepository<LevelTradingEntity, Integer> {
}
