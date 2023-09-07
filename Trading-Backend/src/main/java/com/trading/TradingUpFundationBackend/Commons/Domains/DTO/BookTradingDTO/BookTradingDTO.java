package com.trading.TradingUpFundationBackend.Commons.Domains.DTO.BookTradingDTO;

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
public class BookTradingDTO implements Serializable {
    private Integer id;
    private String name;
    private String description;
    private String image;
    private String file;
    private LevelTradingEntity levelTradingEntityRelation;
}
