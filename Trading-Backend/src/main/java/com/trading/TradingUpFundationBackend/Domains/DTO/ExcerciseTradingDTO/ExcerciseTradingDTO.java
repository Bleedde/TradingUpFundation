package com.trading.TradingUpFundationBackend.Domains.DTO.ExcerciseTradingDTO;

import com.trading.TradingUpFundationBackend.Domains.Entity.LevelTradingEntity.LevelTrading;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
@Data
@Builder
public class ExcerciseTradingDTO implements Serializable {
    private Integer id;
    private String subtitle;
    private String description;
    private String dataEnd;
    private String dataStart;
    private LevelTrading levelTradingRelation;
}
