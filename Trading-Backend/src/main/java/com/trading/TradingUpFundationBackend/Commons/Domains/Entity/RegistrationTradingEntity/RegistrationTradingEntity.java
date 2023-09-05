package com.trading.TradingUpFundationBackend.Commons.Domains.Entity.RegistrationTradingEntity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.UserTradingEntity.UserTradingEntity;
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.LevelTradingEntity.LevelTradingEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "registration_trading")
public class RegistrationTradingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registration_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private UserTradingEntity userTradingEntityRelation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id")
    @JsonBackReference
    private LevelTradingEntity levelTradingEntityRelation;
}
