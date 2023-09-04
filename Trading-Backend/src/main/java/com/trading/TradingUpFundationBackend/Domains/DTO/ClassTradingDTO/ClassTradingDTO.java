package com.trading.TradingUpFundationBackend.Domains.DTO.ClassTradingDTO;

import com.trading.TradingUpFundationBackend.Domains.Entity.LevelTradingEntity.LevelTrading;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
@Data
@Builder
public class ClassTradingDTO implements Serializable {
    private String id;
    private String name;
    private String subtitle;
    private String description;
    private LevelTrading levelTradingRelation;
}
