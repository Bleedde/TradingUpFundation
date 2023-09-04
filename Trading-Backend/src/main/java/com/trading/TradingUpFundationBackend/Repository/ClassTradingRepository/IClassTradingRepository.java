package com.trading.TradingUpFundationBackend.Repository.ClassTradingRepository;

import com.trading.TradingUpFundationBackend.Domains.Entity.ClassTradingEntity.ClassTrading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassTradingRepository extends JpaRepository<Integer, ClassTrading> {
}
