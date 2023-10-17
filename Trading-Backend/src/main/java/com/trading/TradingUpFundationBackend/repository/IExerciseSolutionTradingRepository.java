package com.trading.TradingUpFundationBackend.repository;

import com.trading.TradingUpFundationBackend.commons.domains.entity.ExerciseSolutionTradingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IExerciseSolutionTradingRepository extends JpaRepository<ExerciseSolutionTradingEntity, Integer> {
}
