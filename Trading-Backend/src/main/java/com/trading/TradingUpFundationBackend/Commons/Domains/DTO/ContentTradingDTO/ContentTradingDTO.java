package com.trading.TradingUpFundationBackend.Commons.Domains.DTO.ContentTradingDTO;

import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.LevelTradingEntity.LevelTradingEntity;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
@Data
@Builder
public class ContentTradingDTO implements Serializable {
    private Integer id;
    private String title;
    private String subTitle;
    private String description;
    private String urlVideo;
    private LevelTradingEntity levelTradingEntityRelation;
}
