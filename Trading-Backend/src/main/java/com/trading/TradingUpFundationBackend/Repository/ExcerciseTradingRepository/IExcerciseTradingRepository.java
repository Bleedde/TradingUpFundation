package com.trading.TradingUpFundationBackend.Repository.ExcerciseTradingRepository;

import com.trading.TradingUpFundationBackend.Domains.Entity.ExcerciseTradingEntity.ExcerciseTrading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExcerciseTradingRepository extends JpaRepository<Integer, ExcerciseTrading> {
}
