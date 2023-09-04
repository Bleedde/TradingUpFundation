package com.trading.TradingUpFundationBackend.Domains.Entity.LevelTradingEntity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.trading.TradingUpFundationBackend.Domains.Entity.BookTradingEntity.BookTrading;
import com.trading.TradingUpFundationBackend.Domains.Entity.ClassTradingEntity.ClassTrading;
import com.trading.TradingUpFundationBackend.Domains.Entity.ContentTradingEntity.ContentTrading;
import com.trading.TradingUpFundationBackend.Domains.Entity.ExcerciseTradingEntity.ExcerciseTrading;
import com.trading.TradingUpFundationBackend.Domains.Entity.RegistrationTradingEntity.RegistrationTrading;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "level_trading")
public class LevelTrading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "level_id")
    private Integer id;

    @Column(name = "level_name", length = 255, nullable = false)
    private String name;

    @Column(name = "level_data_start", length = 255, nullable = false)
    private String dataStart;

    @Column(name = "level_data_end", length = 255, nullable = false)
    private String dataEnd;

    @Column(name = "level_amount", nullable = false)
    private Integer amount;

    @OneToMany(mappedBy = "levelTradingRelation", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<RegistrationTrading> registrationTradingRelation;

    @OneToMany(mappedBy = "levelTradingRelation", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ContentTrading> contentTradingRelation;

    @OneToMany(mappedBy = "levelTradingRelation", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ExcerciseTrading> excerciseTradingRelation;

    @OneToMany(mappedBy = "levelTradingRelation", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<BookTrading> bookTradingRelation;

    @OneToMany(mappedBy = "levelTradingRelation", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ClassTrading> classTradingRelation;
}
