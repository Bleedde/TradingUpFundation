package com.trading.TradingUpFundationBackend.repository;

import com.trading.TradingUpFundationBackend.commons.domains.entity.ExerciseTradingEntity;
import org.springframework.data.jpa.repository.JpaRepository;//Package to use the persistence in this interface
import org.springframework.stereotype.Repository;//Package to bring the element from spring "Repository"

@Repository//Annotation to represent this interface like a repository to connect with the database
public interface IExerciseTradingRepository extends JpaRepository<ExerciseTradingEntity, Integer> {
}
