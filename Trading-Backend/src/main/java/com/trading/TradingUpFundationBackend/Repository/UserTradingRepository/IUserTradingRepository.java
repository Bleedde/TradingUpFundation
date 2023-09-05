package com.trading.TradingUpFundationBackend.Repository.UserTradingRepository;

import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.UserTradingEntity.UserTradingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserTradingRepository extends JpaRepository<UserTradingEntity, Integer> {
}
