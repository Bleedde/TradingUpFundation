package com.trading.TradingUpFundationBackend.commons.mapper;

import org.modelmapper.ModelMapper;//Package to map an object to another type of object

/**
 * Class to create an object with the type "ModelMapper"
 */
public class Mapper {
    public static ModelMapper modelMapper(){
        return new ModelMapper();//Object which map an object to the class of another object
    }
}