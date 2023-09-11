package com.trading.TradingUpFundationBackend.Commons.Domains.DTO.AdminTradingDTO;

import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.UserTradingEntity.UserTradingEntity;//Import of the entity "User"
import lombok.AllArgsConstructor;//Import to use all the arguments that a constructor normally has
import lombok.Builder;//Import to create objects easier
import lombok.Data;//Import to add the normal methods that an object has
import lombok.NoArgsConstructor;//Import who allow to create an object without args in the constructor

import java.io.Serializable;//Package to use this class like a byte sequence
import java.util.List;//Package who give the dynamic list "List"

@Data//Annotation to represent normal methods of a normal class
@Builder//Annotation who allows to build an object in an easier way
@AllArgsConstructor//Annotation who creates a constructor with all the arguments passed like parameters
@NoArgsConstructor//Annotation who creates an empty constructor
/**
 * Class who creates an objecto with a type DTO to the entity "AdminTrading"
 * Implements the interface Serializable
 */
public class AdminTradingDTO implements Serializable {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private List<UserTradingEntity> userTradingEntityRelation;
}
