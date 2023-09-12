package com.trading.TradingUpFundationBackend.Repository.BookTradingRepository;

import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.BookTradingEntity.BookTradingEntity;//Package to use the Entity "Book"
import org.springframework.data.jpa.repository.JpaRepository;//Package to use the persistence in this interface
import org.springframework.stereotype.Repository;//Package to bring the element from spring "Repository"

@Repository//Annotation to represent this interface like a repository to connect with the database
public interface IBookTradingRepository extends JpaRepository<BookTradingEntity, Integer> {
}
