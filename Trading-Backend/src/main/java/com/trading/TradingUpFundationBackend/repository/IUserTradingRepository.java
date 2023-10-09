package com.trading.TradingUpFundationBackend.repository;

import com.trading.TradingUpFundationBackend.commons.domains.entity.UserTradingEntity;//Package to use the Entity "User"
import org.springframework.data.jpa.repository.JpaRepository;//Package to use the persistence in this interface
import org.springframework.stereotype.Repository;//Package to bring the element from spring "Repository"

import java.util.Optional;//Package which allows the use of the dataType "Optional"

@Repository//Annotation to represent this interface like a repository to connect with the database
/**
 * Interface which represents a connection between the Springboot application and the database
 * Connection between the entity UserTradingEntity and the table user_trading
 */
public interface IUserTradingRepository extends JpaRepository<UserTradingEntity, Integer> {

    /**
     * Class without body which find a user searching his email
     * @param email The email of the user who is going to be searched
     * @return An object empty or not, depends on if it found the email or not
     */
    Optional<UserTradingEntity> findByEmail(String email);

    /**
     * Class without body which delete a user for his email
     * @param email The email of the user to be deleted
     */
    void deleteByEmail(String email);
}
