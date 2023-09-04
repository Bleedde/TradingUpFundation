package com.trading.TradingUpFundationBackend.Domains.Entity.RegistrationTradingEntity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.trading.TradingUpFundationBackend.Domains.Entity.LevelTradingEntity.LevelTrading;
import com.trading.TradingUpFundationBackend.Domains.Entity.UserTradingEntity.UserTrading;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "registration_trading")
public class RegistrationTrading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registration_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private UserTrading userTradingRelation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id")
    @JsonBackReference
    private LevelTrading levelTradingRelation;
}
