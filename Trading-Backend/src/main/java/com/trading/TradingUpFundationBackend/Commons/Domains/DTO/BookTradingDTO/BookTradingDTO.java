package com.trading.TradingUpFundationBackend.Commons.Domains.DTO.BookTradingDTO;

import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.LevelTradingEntity.LevelTradingEntity;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
@Data
@Builder
public class BookTradingDTO implements Serializable {
    private Integer id;
    private String name;
    private String description;
    private String image;
    private String file;
    private LevelTradingEntity levelTradingEntityRelation;
}
