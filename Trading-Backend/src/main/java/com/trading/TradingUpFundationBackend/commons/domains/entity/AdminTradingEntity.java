package com.trading.TradingUpFundationBackend.commons.domains.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;//Package to deny the recursion of the side "One"
import jakarta.persistence.*;//Package to add the persistence to this entity
import lombok.Data;//Package of lombok to add the normal methods that an entity has

import java.util.List;//Package to manage a dynamic list

@Entity//Annotation to represent this class like an entity of a database for spring
@Data//Annotation to represent normal methods of a normal class
@Table(name = "admin_trading")//Annotation to represent this entity like a table in a database represented with a name
/**
 * Class to represent the entity "admin_trading" in de modeling "TradingUpFoundation"
 */
public class AdminTradingEntity {
    @Id//Annotation to represent this attribute like an ID who represent this Entity
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Annotation who represent the way of how the id is going to work in each registration
    @Column(name = "admin_id")//Annotation to represent this attribute like a column with a name in the table
    private Integer id;

    @Column(name = "admin_name", length = 255, nullable = false)//Annotation to represent this attribute like a column with a name in the table, the length has to be 255 and it cant be null
    private String name;

    @Column(name = "admin_email", length = 255, nullable = false)//Annotation to represent this attribute like a column with a name in the table, the length has to be 255 and it cant be null
    private String email;

    @Column(name = "admin_password", length = 255, nullable = false)//Annotation to represent this attribute like a column with a name in the table, the length has to be 255 and it cant be null
    private String password;

    @OneToMany(mappedBy = "adminTradingEntityRelation", cascade = CascadeType.ALL, orphanRemoval = true)//Annotation to represent a relation "One" to "Many" where it is mapped the attribute in the another entity who represent the side "Many"
    @JsonManagedReference//Annotation to do only a query to the entity who represent the side "Many" in the relation
    @JsonIgnore//Annotation to ignore this list in the moment to be
    private List<UserTradingEntity> userTradingEntityRelation;
}
