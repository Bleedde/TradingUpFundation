package com.trading.TradingUpFundationBackend.Repository.UserTradingRepository;

import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.UserTradingEntity.UserTradingEntity;//Package to use the Entity "User"
import org.springframework.data.jpa.repository.JpaRepository;//Package to use the persistence in this interface
import org.springframework.stereotype.Repository;//Package to bring the element from spring "Repository"

@Repository//Annotation to represent this interface like a repository to connect with the database
public interface IUserTradingRepository extends JpaRepository<UserTradingEntity, Integer> {
}
