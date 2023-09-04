package com.trading.TradingUpFundationBackend.Domains.DTO.UserTradingDTO;

import com.trading.TradingUpFundationBackend.Domains.Entity.AdminTradinEntity.AdminTrading;
import com.trading.TradingUpFundationBackend.Domains.Entity.RegistrationTradingEntity.RegistrationTrading;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class UserTradingDTO implements Serializable {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String userLevel;
    private String status;
    private String backtesting;
    private String auditedAccount;
    private AdminTrading adminTradingRelation;
    private List<RegistrationTrading> registrationTradingRelation;
}
