package com.trading.TradingUpFundationBackend.Commons.Domains.Entity.ClassTradingEntity;

import com.fasterxml.jackson.annotation.JsonBackReference;//Package to deny the recursion of the side "One"
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.LevelTradingEntity.LevelTradingEntity;//Import the entity "Level" to represent the relation between these entities
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
    private String name;

    @Column(name = "class_subtitle", length = 255, nullable = false)//Annotation to represent this attribute like a column with a name in the table, the length has to be 255 and it cant be null
    private String subtitle;

    @Column(name = "class_description", length = 255, nullable = false)//Annotation to represent this attribute like a column with a name in the table, the length has to be 255 and it cant be null
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)//Annotation to represent the relation "Many" to "One"
    @JoinColumn(name = "level_id")//Annotation to represent to what column is gonna represent the ID who is the foreign key in this side of this relation
    @JsonBackReference//Annotation to do only a query to the entity who represent the side "One" in the relation
    private LevelTradingEntity levelTradingEntityRelation;
}
