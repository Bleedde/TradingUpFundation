package com.trading.TradingUpFundationBackend.Repository.RegistrationTradingRepository;

import com.trading.TradingUpFundationBackend.Domains.Entity.RegistrationTradingEntity.RegistrationTrading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRegistrationTradingRepository extends JpaRepository<Integer, RegistrationTrading> {
}
