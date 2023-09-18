package com.trading.TradingUpFundationBackend.repository;

import com.trading.TradingUpFundationBackend.commons.domains.entity.ClassesPrerecordedTradingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassesPrerecordedTradingRepository extends JpaRepository<ClassesPrerecordedTradingEntity, Integer> {

}
