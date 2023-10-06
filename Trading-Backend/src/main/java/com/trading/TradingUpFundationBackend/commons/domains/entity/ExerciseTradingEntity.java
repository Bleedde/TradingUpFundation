package com.trading.TradingUpFundationBackend.commons.domains.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;//Package to deny the recursion of the side "Many"
import com.fasterxml.jackson.annotation.JsonFormat;//Package to turn into Json data some attributes
import jakarta.persistence.*;//Package to add the persistence to this entity
import lombok.Data;//Package of lombok to add the normal methods that an entity has

import java.sql.Date;//Import the type of data "Date" to represent a specific Date

@Entity//Annotation to represent this class like an entity of a database for spring
@Table(name = "exercise_trading")//Annotation to represent this entity like a table in a database represented with a name
@Data//Annotation to represent normal methods of a normal class
/**
 * Class to represent the entity "exercise_trading" of the modeling "TradingUpFoundation"
 */
public class ExerciseTradingEntity {
    @Id//Annotation to represent this attribute like an ID who represent this Entity
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Annotation who represent the way of how the id is going to work in each registration
    @Column(name = "exercise_id")//Annotation to represent this attribute like a column with a name in the table
    private Integer id;

    @Column(name = "exercise_title", length = 255, nullable = false)//Annotation to represent this attribute like a column with a name in the table, the length has to be 255 and it cant be null
    private String title;

    @Column(name = "exercise_subtitle", length = 255, nullable = false)//Annotation to represent this attribute like a column with a name in the table, the length has to be 255 and it cant be null
    private String subtitle;

    @Column(name = "exercise_description", length = 255, nullable = false)//Annotation to represent this attribute like a column with a name in the table, the length has to be 255 and it cant be null
    private String descripcion;

    @Column(name = "exercise_data_start", nullable = false)//Annotation to represent this attribute like a column with a name in the table, cant be null
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dataStart;

    @Column(name = "exercise_data_end", nullable = false)//Annotation to represent this attribute like a column with a name in the table, cant be null
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dataEnd;

    @Column(name = "exercise_level", nullable = false)
    private Integer level;
}
