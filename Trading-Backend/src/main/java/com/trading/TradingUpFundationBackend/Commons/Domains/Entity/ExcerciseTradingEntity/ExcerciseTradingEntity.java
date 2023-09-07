package com.trading.TradingUpFundationBackend.Commons.Domains.Entity.ExcerciseTradingEntity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.LevelTradingEntity.LevelTradingEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "excercise_trading")
@Data
public class ExcerciseTradingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excercise_id")
    private Integer id;

    @Column(name = "excercise_title", length = 255, nullable = false)
    private String title;

    @Column(name = "excercise_subtitle", length = 255, nullable = false)
    private String subtitle;

    @Column(name = "excercise_description", length = 255, nullable = false)
    private String descripcion;

    @Column(name = "excercise_data_start", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dataStart;

    @Column(name = "excercise_data_end", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dataEnd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id")
    @JsonBackReference
    private LevelTradingEntity levelTradingEntityRelation;
}
