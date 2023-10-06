package com.trading.TradingUpFundationBackend.repository;

import com.trading.TradingUpFundationBackend.commons.domains.entity.BookTradingEntity;//Package to use the Entity "Book"
import org.springframework.data.jpa.repository.JpaRepository;//Package to use the persistence in this interface
import org.springframework.stereotype.Repository;//Package to bring the element from spring "Repository"

@Repository//Annotation to represent this interface like a repository to connect with the database
/**
 * Interface which represents a conection between the Springboot aplication and the database
 * Connection between the entity BookTradingEntity and the table book_trading
 */
public interface IBookTradingRepository extends JpaRepository<BookTradingEntity, Integer> {
}
