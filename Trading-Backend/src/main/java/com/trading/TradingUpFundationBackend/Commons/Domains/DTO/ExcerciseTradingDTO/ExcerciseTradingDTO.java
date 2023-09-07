package com.trading.TradingUpFundationBackend.Commons.Domains.DTO.ExcerciseTradingDTO;

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
public class ExcerciseTradingDTO implements Serializable {
    private Integer id;
    private String subtitle;
    private String description;
    private String dataEnd;
    private String dataStart;
    private LevelTradingEntity levelTradingEntityRelation;
}
