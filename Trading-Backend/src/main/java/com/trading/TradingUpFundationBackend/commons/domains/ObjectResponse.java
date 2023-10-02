package com.trading.TradingUpFundationBackend.commons.domains;

import lombok.Builder;//Import to create objects easier
import lombok.Data;//Import to add the normal methods that an object has

import java.io.Serializable;//Package to use this class like a byte sequence
@Data//Annotation to represent normal methods of a normal class
@Builder//Annotation who allows to build an object in an easier way
/**
 * Class who creates a response with the type DTO
 * Implements the interface Serializable
 */
public class ObjectResponse implements Serializable{
    public String message;
    public Integer httpResponse;
    public Object objectResponse;
}
