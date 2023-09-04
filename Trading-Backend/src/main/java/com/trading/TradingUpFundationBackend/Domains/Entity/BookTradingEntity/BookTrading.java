package com.trading.TradingUpFundationBackend.Domains.Entity.BookTradingEntity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.trading.TradingUpFundationBackend.Domains.Entity.LevelTradingEntity.LevelTrading;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "book_trading")
public class BookTrading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer id;

    @Column(name = "book_name", length = 255, nullable = false)
    private String name;

    @Column(name = "book_description", length = 255, nullable = false)
    private String description;

    @Column(name = "book_image", length = 255, nullable = false)
    private String image;

    @Column(name = "book_file", length = 255, nullable = false)
    private String file;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id")
    @JsonBackReference
    private LevelTrading levelTradingRelation;
}
