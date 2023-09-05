package com.trading.TradingUpFundationBackend.Commons.Domains.Entity.ContentTradingEntity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.LevelTradingEntity.LevelTradingEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "content_trading")
public class ContentTradingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_id")
    private Integer id;

    @Column(name = "content_title", length = 255, nullable = false)
    private String title;

    @Column(name = "content_subtitle", length = 255, nullable = false)
    private String subTitle;

    @Column(name = "content_description", length = 255, nullable = false)
    private String description;

    @Column(name = "content_url_video", length = 255, nullable = false)
    private String urlVideo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id")
    @JsonBackReference
    private LevelTradingEntity levelTradingEntityRelation;
}
