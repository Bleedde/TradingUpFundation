package com.trading.TradingUpFundationBackend.Commons.Domains.Entity.LevelTradingEntity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.BookTradingEntity.BookTradingEntity;
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.ClassTradingEntity.ClassTradingEntity;
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.ExcerciseTradingEntity.ExcerciseTradingEntity;
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.RegistrationTradingEntity.RegistrationTradingEntity;
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.ContentTradingEntity.ContentTradingEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@Table(name = "level_trading")
public class LevelTradingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "level_id")
    private Integer id;

    @Column(name = "level_name", length = 255, nullable = false)
    private String name;

    @Column(name = "level_data_start",nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dataStart;

    @Column(name = "level_data_end", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dataEnd;

    @Column(name = "level_amount", nullable = false)
    private Integer amount;

    @OneToMany(mappedBy = "levelTradingEntityRelation", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<RegistrationTradingEntity> registrationTradingEntityRelation;

    @OneToMany(mappedBy = "levelTradingEntityRelation", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ContentTradingEntity> contentTradingEntityRelation;

    @OneToMany(mappedBy = "levelTradingEntityRelation", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ExcerciseTradingEntity> excerciseTradingEntityRelation;

    @OneToMany(mappedBy = "levelTradingEntityRelation", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<BookTradingEntity> bookTradingEntityRelation;

    @OneToMany(mappedBy = "levelTradingEntityRelation", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ClassTradingEntity> classTradingEntityRelation;
}
