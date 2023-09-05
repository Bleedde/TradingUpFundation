package com.trading.TradingUpFundationBackend.Commons.Domains.DTO.ClassTradingDTO;

import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.LevelTradingEntity.LevelTradingEntity;
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
    private LevelTradingEntity levelTradingEntityRelation;
}
