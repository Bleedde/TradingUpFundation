package com.trading.TradingUpFundationBackend.Commons.Helper;

import org.modelmapper.ModelMapper;//Package to map an object to another type of object

/**
 * Class to create an object with the type "ModelMapper"
 */
public class HelperMapper {
    public static ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
