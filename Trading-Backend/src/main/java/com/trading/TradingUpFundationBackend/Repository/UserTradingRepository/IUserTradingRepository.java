package com.trading.TradingUpFundationBackend.Repository.UserTradingRepository;

import com.trading.TradingUpFundationBackend.Domains.Entity.UserTradingEntity.UserTrading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserTradingRepository extends JpaRepository<Integer, UserTrading> {
}
