package com.trading.TradingUpFundationBackend.Repository.LevelTradingRepository;

import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.LevelTradingEntity.LevelTradingEntity;//Package to use the Entity "Level"
import org.springframework.data.jpa.repository.JpaRepository;//Package to use the persistence in this interface
import org.springframework.stereotype.Repository;//Package to bring the element from spring "Repository"

@Repository//Annotation to represent this interface like a repository to connect with the database
public interface ILevelTradingRepository extends JpaRepository<LevelTradingEntity, Integer> {
}
