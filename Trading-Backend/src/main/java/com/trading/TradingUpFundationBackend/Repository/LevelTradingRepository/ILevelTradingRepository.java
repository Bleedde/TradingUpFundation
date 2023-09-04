package com.trading.TradingUpFundationBackend.Repository.LevelTradingRepository;

import com.trading.TradingUpFundationBackend.Domains.Entity.LevelTradingEntity.LevelTrading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILevelTradingRepository extends JpaRepository<Integer, LevelTrading> {
}
