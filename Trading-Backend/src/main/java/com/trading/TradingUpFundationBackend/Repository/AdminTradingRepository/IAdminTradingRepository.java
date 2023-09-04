package com.trading.TradingUpFundationBackend.Repository.AdminTradingRepository;

import com.trading.TradingUpFundationBackend.Domains.Entity.AdminTradinEntity.AdminTrading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminTradingRepository extends JpaRepository<Integer, AdminTrading> {
}
