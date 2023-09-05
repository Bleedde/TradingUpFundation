package com.trading.TradingUpFundationBackend.Commons.Domains.DTO.AdminTradingDTO;

import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.UserTradingEntity.UserTradingEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminTradingDTO implements Serializable {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private List<UserTradingEntity> userTradingEntityRelation;
}
