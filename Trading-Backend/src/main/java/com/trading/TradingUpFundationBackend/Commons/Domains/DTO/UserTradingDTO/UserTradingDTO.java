package com.trading.TradingUpFundationBackend.Commons.Domains.DTO.UserTradingDTO;

import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.AdminTradinEntity.AdminTradingEntity;
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.RegistrationTradingEntity.RegistrationTradingEntity;
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
public class UserTradingDTO implements Serializable {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private Integer userLevel;
    private boolean status;
    private String backtesting;
    private String auditedAccount;
    private AdminTradingEntity adminTradingEntityRelation;
    private List<RegistrationTradingEntity> registrationTradingEntityRelation;
}
