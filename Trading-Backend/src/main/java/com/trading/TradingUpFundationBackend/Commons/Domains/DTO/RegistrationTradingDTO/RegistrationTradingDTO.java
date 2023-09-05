package com.trading.TradingUpFundationBackend.Commons.Domains.DTO.RegistrationTradingDTO;

import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.LevelTradingEntity.LevelTradingEntity;
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.UserTradingEntity.UserTradingEntity;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
@Data
@Builder
public class RegistrationTradingDTO implements Serializable {
    private Integer id;
    private UserTradingEntity userTradingEntityRelation;
    private LevelTradingEntity levelTradingEntityRelation;
}
