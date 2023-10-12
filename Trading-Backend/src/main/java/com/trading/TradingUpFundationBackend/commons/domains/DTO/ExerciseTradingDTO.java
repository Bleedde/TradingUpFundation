package com.trading.TradingUpFundationBackend.commons.domains.DTO;

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
 * Class who creates an objecto with a type DTO to the entity "ExcerciseTrading"
 * Implements the interface Serializable
 */

public class ExerciseTradingDTO implements Serializable {
    private Integer id;
    private String subtitle;
    private String description;
    private String dataEnd;
    private String dataStart;
    private Integer level;
    private String urlHomework;
    private String comment;
    private String urlSolution;
}
