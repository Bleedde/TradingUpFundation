package com.trading.TradingUpFundationBackend.repository;

import com.trading.TradingUpFundationBackend.commons.domains.entity.ExcerciseTradingEntity;//Package to use the Entity "Excercise"
import org.springframework.data.jpa.repository.JpaRepository;//Package to use the persistence in this interface
import org.springframework.stereotype.Repository;//Package to bring the element from spring "Repository"

@Repository//Annotation to represent this interface like a repository to connect with the database
public interface IExcerciseTradingRepository extends JpaRepository<ExcerciseTradingEntity, Integer> {
}
