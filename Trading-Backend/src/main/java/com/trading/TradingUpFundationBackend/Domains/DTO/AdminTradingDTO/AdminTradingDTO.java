package com.trading.TradingUpFundationBackend.Domains.DTO.AdminTradingDTO;

import com.trading.TradingUpFundationBackend.Domains.Entity.UserTradingEntity.UserTrading;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class AdminTradingDTO implements Serializable {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private List<UserTrading> userTradingRelation;
}
