package com.trading.TradingUpFundationBackend.Domains.DTO.LevelTradingDTO;

import com.trading.TradingUpFundationBackend.Domains.Entity.BookTradingEntity.BookTrading;
import com.trading.TradingUpFundationBackend.Domains.Entity.ClassTradingEntity.ClassTrading;
import com.trading.TradingUpFundationBackend.Domains.Entity.ContentTradingEntity.ContentTrading;
import com.trading.TradingUpFundationBackend.Domains.Entity.ExcerciseTradingEntity.ExcerciseTrading;
import com.trading.TradingUpFundationBackend.Domains.Entity.RegistrationTradingEntity.RegistrationTrading;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class LevelTradingDTO implements Serializable {
    private Integer id;
    private String name;
    private String dataStart;
    private String dataEnd;
    private Integer amount;
    private List<RegistrationTrading> registrationTradingRelation;
    private List<ContentTrading> contentTradingRelation;
    private List<ExcerciseTrading> excerciseTradingRelation;
    private List<BookTrading> bookTradingRelation;
    private List<ClassTrading> classTradingRelation;
}
