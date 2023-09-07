package com.trading.TradingUpFundationBackend.Commons.Domains.DTO.LevelTradingDTO;

import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.BookTradingEntity.BookTradingEntity;
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.ClassTradingEntity.ClassTradingEntity;
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.ContentTradingEntity.ContentTradingEntity;
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.ExcerciseTradingEntity.ExcerciseTradingEntity;
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.RegistrationTradingEntity.RegistrationTradingEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LevelTradingDTO implements Serializable {
    private Integer id;
    private String name;
    private Date dataStart;
    private Date dataEnd;
    private Integer amount;
    private List<RegistrationTradingEntity> registrationTradingEntityRelation;
    private List<ContentTradingEntity> contentTradingEntityRelation;
    private List<ExcerciseTradingEntity> excerciseTradingEntityRelation;
    private List<BookTradingEntity> bookTradingEntityRelation;
    private List<ClassTradingEntity> classTradingEntityRelation;
}
