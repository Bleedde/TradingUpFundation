package com.trading.TradingUpFundationBackend.commons.domains.DTO;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.trading.TradingUpFundationBackend.commons.domains.entity.LevelTradingEntity;//Import of the entity "Level"
import com.trading.TradingUpFundationBackend.commons.domains.entity.UserTradingEntity;//Import of the entity "User"
import lombok.AllArgsConstructor;//Import to use all the arguments that a constructor normally has
import lombok.Builder;//Import to create objects easier
import lombok.Data;//Import to add the normal methods that an object has
import lombok.NoArgsConstructor;//Import who allow to create an object without args in the constructor

import java.io.Serializable;//Package to use this class like a byte sequence
@Data//Annotation to represent normal methods of a normal class
@Builder//Annotation who allows to build an object in an easier way
@AllArgsConstructor//Annotation who creates a constructor with all the arguments passed like parameters
@NoArgsConstructor//Annotation who creates an empty constructor
/**
 * Class who creates an objecto with a type DTO to the entity "RegistrationTrading"
 * Implements the interface Serializable
 */
public class RegistrationTradingDTO implements Serializable {
    private Integer id;
    @JsonIdentityReference(alwaysAsId = true)
    private UserTradingEntity userTradingEntityRelation;
    @JsonIdentityReference(alwaysAsId = true)
    private LevelTradingEntity levelTradingEntityRelation;
}
