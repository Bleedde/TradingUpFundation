package com.trading.TradingUpFundationBackend.commons.domains;

import lombok.Builder;//Import to create objects easier
import lombok.Data;//Import to add the normal methods that an object has

import java.io.Serializable;//Package to use this class like a byte sequence
@Data//Annotation to represent normal methods of a normal class
@Builder//Annotation who allows to build an object in an easier way
public class ObjectResponse implements Serializable{
    public String message;//It's going to send a message
    public Integer httpResponse;//It's going to send a code with an HTTP type
    public Object objectResponse;//It's going to send an object
}
