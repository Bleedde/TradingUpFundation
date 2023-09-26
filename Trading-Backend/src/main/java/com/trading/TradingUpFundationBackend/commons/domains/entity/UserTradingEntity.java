package com.trading.TradingUpFundationBackend.commons.domains.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;//Package to deny the recursion of the side "Many"
import com.fasterxml.jackson.annotation.JsonManagedReference;//Package to deny the recursion of the side "One"
import jakarta.persistence.*;//Package to add the persistence to this entity
import lombok.Data;//Package of lombok to add the normal methods that an entity has

import java.util.List;//Package to manage a dynamic list

@Entity//Annotation to represent this class like an entity of a database for spring
@Table(name = "user_trading")//Annotation to represent this entity like a table in a database represented with a name
@Data//Annotation to represent normal methods of a normal class

/**
 * Class to represent the entity "user_trading" in de modeling "TradingUpFoundation"
 */
public class UserTradingEntity {
    @Id//Annotation to represent this attribute like an ID who represent this Entity
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Annotation who represent the way of how the id is going to work in each registration
    @Column(name = "user_id")//Annotation to represent this attribute like a column with a name in the table
    private Integer id;

    @Column(name = "user_name",length = 255, nullable = false)//Annotation to represent this attribute like a column with a name in the table, the length has to be 255 and it cant be null
    private String name;

    @Column(name = "user_email", length = 255, nullable = false)//Annotation to represent this attribute like a column with a name in the table, the length has to be 255 and it cant be null
    private String email;

    @Column(name = "user_password", length = 255, nullable = false)//Annotation to represent this attribute like a column with a name in the table, the length has to be 255 and it cant be null
    private String password;

    @Column(name = "user_current_level", nullable = false)//Annotation to represent this attribute like a column with a name in the table, it cant be null
    private Integer userLevel;

    @Column(name = "user_status", nullable = false)//Annotation to represent this attribute like a column with a name in the table, it cant be null
    private boolean status;

    @Column(name = "user_backtesting_link", length = 255, nullable = true)//Annotation to represent this attribute like a column with a name in the table, the length has to be 255
    private String backtesting;

    @Column(name = "user_audited_account", length = 255, nullable = true)//Annotation to represent this attribute like a column with a name in the table, the length has to be 255
    private String auditedAccount;

    @Column(name = "user_role")
    private String roleUser;

    @ManyToOne(fetch = FetchType.LAZY)//Annotation to represent the relation "Many" to "One"
    @JoinColumn(name = "admin_id")//Annotation to represent to what column is gonna represent the ID who is the foreign key in this side of this relation
    @JsonBackReference//Annotation to do only a query to the entity who represent the side "One" in the relation
    private AdminTradingEntity adminTradingEntityRelation;

    @OneToMany(mappedBy = "userTradingEntityRelation")//Annotation to represent a relation "One" to "Many" where it is mapped the attribute in the another entity who represent the side "Many"
    @JsonManagedReference//Annotation to do only a query to the entity who represent the side "Many" in the relation
    private List<RegistrationTradingEntity> registrationTradingEntityRelation;
}
