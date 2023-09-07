package com.trading.TradingUpFundationBackend.Commons.Domains.DTO.ClassTradingDTO;

import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.LevelTradingEntity.LevelTradingEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClassTradingDTO implements Serializable {
    private String id;
    private String name;
    private String subtitle;
    private String description;
    private LevelTradingEntity levelTradingEntityRelation;
}
