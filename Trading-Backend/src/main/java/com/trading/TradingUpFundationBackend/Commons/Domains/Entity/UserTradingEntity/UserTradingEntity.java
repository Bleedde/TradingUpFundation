package com.trading.TradingUpFundationBackend.Commons.Domains.Entity.UserTradingEntity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.AdminTradinEntity.AdminTradingEntity;
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.RegistrationTradingEntity.RegistrationTradingEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "user_trading")
@Data
public class UserTradingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "user_name",length = 255, nullable = false)
    private String name;

    @Column(name = "user_email", length = 255, nullable = false)
    private String email;

    @Column(name = "user_password", length = 255, nullable = false)
    private String password;

    @Column(name = "user_current_level", nullable = false)
    private Integer userLevel;

    @Column(name = "user_status", nullable = false)
    private boolean status;

    @Column(name = "user_backtesting_link", length = 255, nullable = true)
    private String backtesting;

    @Column(name = "user_audited_account", length = 255, nullable = true)
    private String auditedAcount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private AdminTradingEntity adminTradingEntityRelation;

    @OneToMany(mappedBy = "userTradingEntityRelation", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<RegistrationTradingEntity> registrationTradingEntityRelation;
}
