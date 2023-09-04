package com.trading.TradingUpFundationBackend.Domains.DTO.RegistrationTradingDTO;

import com.trading.TradingUpFundationBackend.Domains.Entity.LevelTradingEntity.LevelTrading;
import com.trading.TradingUpFundationBackend.Domains.Entity.UserTradingEntity.UserTrading;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
@Data
@Builder
public class RegistrationTradingDTO implements Serializable {
    private Integer id;
    private UserTrading userTradingRelation;
    private LevelTrading levelTradingRelation;
}
