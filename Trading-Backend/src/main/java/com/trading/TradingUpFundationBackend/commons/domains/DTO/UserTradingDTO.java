package com.trading.TradingUpFundationBackend.commons.domains.DTO;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.trading.TradingUpFundationBackend.commons.domains.entity.AdminTradingEntity;//Import of the entity "Admin"
import com.trading.TradingUpFundationBackend.commons.domains.entity.RegistrationTradingEntity;//Import of the entity "Registration"
import lombok.AllArgsConstructor;//Import to use all the arguments that a constructor normally has
import lombok.Builder;//Import to create objects easier
import lombok.Data;//Import to add the normal methods that an object has
import lombok.NoArgsConstructor;//Import who allow to create an object without args in the constructor

import java.io.Serializable;//Package to use this class like a byte sequence
import java.util.List;//Package who allows tu use the dynamic list "List"

@Data//Annotation to represent normal methods of a normal class
@Builder//Annotation who allows to build an object in an easier way
@AllArgsConstructor//Annotation who creates a constructor with all the arguments passed like parameters
@NoArgsConstructor//Annotation who creates an empty constructor
/**
 * Class who creates an objecto with a type DTO to the entity "UserTrading"
 * Implements the interface Serializable
 */
public class UserTradingDTO implements Serializable {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private Integer userLevel;
    private boolean status;
    private String backtesting;
    private String auditedAccount;
    private String roleUser;
    @JsonIdentityReference(alwaysAsId = true)
    private AdminTradingEntity adminTradingEntityRelation;
}
