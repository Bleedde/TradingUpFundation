package com.trading.TradingUpFundationBackend.Commons.Domains.Entity.ClassTradingEntity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.LevelTradingEntity.LevelTradingEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "class_trading")
@Data
public class ClassTradingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private Integer id;

    @Column(name = "class_title", length = 255, nullable = false)
    private String name;

    @Column(name = "class_subtitle", length = 255, nullable = false)
    private String subtitle;

    @Column(name = "class_description", length = 255, nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id")
    @JsonBackReference
    private LevelTradingEntity levelTradingEntityRelation;
}
