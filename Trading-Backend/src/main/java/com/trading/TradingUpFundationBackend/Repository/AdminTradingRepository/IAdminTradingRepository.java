package com.trading.TradingUpFundationBackend.Repository.AdminTradingRepository;

import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.AdminTradinEntity.AdminTradingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminTradingRepository extends JpaRepository<AdminTradingEntity,Integer> {
}
