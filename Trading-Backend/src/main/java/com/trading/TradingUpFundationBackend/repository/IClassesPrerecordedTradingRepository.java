package com.trading.TradingUpFundationBackend.repository;

import com.trading.TradingUpFundationBackend.commons.domains.entity.ClassPrerecordedTradingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassesPrerecordedTradingRepository extends JpaRepository<ClassPrerecordedTradingEntity, Integer> {}
