package com.trading.TradingUpFundationBackend.Domains.Entity.UserTradingEntity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.trading.TradingUpFundationBackend.Domains.Entity.AdminTradinEntity.AdminTrading;
import com.trading.TradingUpFundationBackend.Domains.Entity.RegistrationTradingEntity.RegistrationTrading;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "user_trading")
@Data
public class UserTrading {
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

    @Column(name = "user_current_level", length = 255, nullable = false)
    private String userLevel;

    @Column(name = "user_status", length = 255, nullable = false)
    private String status;

    @Column(name = "user_backtesting_link", length = 255, nullable = true)
    private String backtesting;

    @Column(name = "user_audited_account", length = 255, nullable = true)
    private String auditedAcount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private AdminTrading adminTradingRelation;

    @OneToMany(mappedBy = "userTradingRelation", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<RegistrationTrading> registrationTradingRelation;
}
