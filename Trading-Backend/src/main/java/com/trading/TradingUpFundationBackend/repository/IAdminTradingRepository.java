package com.trading.TradingUpFundationBackend.repository;

import com.trading.TradingUpFundationBackend.commons.domains.entity.AdminTradingEntity;//Package to use the Entity "Admin"
import org.springframework.data.jpa.repository.JpaRepository;//Package to use the persistence in this interface
import org.springframework.stereotype.Repository;//Package to bring the element from spring "Repository"

import java.util.Optional;

@Repository//Annotation to represent this interface like a repository to connect with the database
public interface IAdminTradingRepository extends JpaRepository<AdminTradingEntity,Integer> {
    Optional<AdminTradingEntity> findByEmail(String email);
    void deleteByEmail(String email);
}
