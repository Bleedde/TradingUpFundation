package com.trading.TradingUpFundationBackend.Repository.ExcerciseTradingRepository;

import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.ExcerciseTradingEntity.ExcerciseTradingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExcerciseTradingRepository extends JpaRepository<ExcerciseTradingEntity, Integer> {
}
