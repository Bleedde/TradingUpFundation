package com.trading.TradingUpFundationBackend.Domains.DTO.ContentTradingDTO;

import com.trading.TradingUpFundationBackend.Domains.Entity.LevelTradingEntity.LevelTrading;
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
    private LevelTrading levelTradingRelation;
}
