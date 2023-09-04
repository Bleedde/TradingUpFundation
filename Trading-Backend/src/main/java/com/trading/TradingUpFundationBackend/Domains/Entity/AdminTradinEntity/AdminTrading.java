package com.trading.TradingUpFundationBackend.Domains.Entity.AdminTradinEntity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.trading.TradingUpFundationBackend.Domains.Entity.UserTradingEntity.UserTrading;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "admin_trading")
public class AdminTrading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Integer id;

    @Column(name = "admin_name", length = 255, nullable = false)
    private String name;

    @Column(name = "admin_email", length = 255, nullable = false)
    private String email;

    @Column(name = "admin_password", length = 255, nullable = false)
    private String password;

    @OneToMany(mappedBy = "adminTradingRelation", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<UserTrading> userTradingRelation;
}
