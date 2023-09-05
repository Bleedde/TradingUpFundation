package com.trading.TradingUpFundationBackend.Repository.ClassTradingRepository;

import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.ClassTradingEntity.ClassTradingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassTradingRepository extends JpaRepository<ClassTradingEntity, Integer> {
}
