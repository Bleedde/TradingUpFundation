package com.trading.TradingUpFundationBackend.Commons.Domains.DTO.RegistrationTradingDTO;

import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.LevelTradingEntity.LevelTradingEntity;
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.UserTradingEntity.UserTradingEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationTradingDTO implements Serializable {
    private Integer id;
    private UserTradingEntity userTradingEntityRelation;
    private LevelTradingEntity levelTradingEntityRelation;
}
