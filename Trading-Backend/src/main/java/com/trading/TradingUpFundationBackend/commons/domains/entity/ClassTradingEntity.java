package com.trading.TradingUpFundationBackend.commons.domains.entity;

import jakarta.persistence.*;//Package to add the persistence to this entity
import lombok.Data;//Package of lombok to add the normal methods that an entity has

@Entity//Annotation to represent this class like an entity of a database for spring
@Table(name = "class_trading")//Annotation to represent this entity like a table in a database represented with a name
@Data//Annotation to represent normal methods of a normal class
/**
 * Class to represent the entity "class_trading" in the modeling "TradingUpFoundation"
 */
public class ClassTradingEntity {
    @Id//Annotation to represent this attribute like an ID who represent this Entity
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Annotation who represent the way of how the id is going to work in each registration
    @Column(name = "class_id")//Annotation to represent this attribute like a column with a name in the table
    private Integer id;

    @Column(name = "class_title", length = 255, nullable = false)//Annotation to represent this attribute like a column with a name in the table, the length has to be 255 and it cant be null
    private String title;

    @Column(name = "class_description", length = 255, nullable = false)//Annotation to represent this attribute like a column with a name in the table, the length has to be 255 and it cant be null
    private String description;

    @Column(name = "class_url_video", length = 255, nullable = false)//Annotation to represent this attribute like a column with a name in the table, the lenght has to be 255 and it can be null
    private String urlVideo;

    @Column(name = "class_level", nullable = false)//Annotation to represent this attribute like a column with a name in the table, it cant be null
    private Integer level;
}
