package com.trading.TradingUpFundationBackend.Repository.RegistrationTradingRepository;

import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.RegistrationTradingEntity.RegistrationTradingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRegistrationTradingRepository extends JpaRepository<RegistrationTradingEntity, Integer> {
}
