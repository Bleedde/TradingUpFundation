package com.trading.TradingUpFundationBackend.commons.constant.deserializable;

import com.trading.TradingUpFundationBackend.commons.constant.response.Responses;
import com.trading.TradingUpFundationBackend.commons.domains.DTO.UserTradingDTO;
import com.trading.TradingUpFundationBackend.commons.domains.entity.UserTradingEntity;
import com.trading.TradingUpFundationBackend.commons.mapper.Mapper;//Package to import the object "HelperMapper"
import lombok.extern.log4j.Log4j2;//Package who allows log better responses
import org.springframework.stereotype.Component;//Package to represent this class like a component in the spring context

@Component//Annotation to represent this class like a "Bean" or a "Component" in java context
@Log4j2//Annotation to log some messages depending on the context
public class UserTradingDeserializable {

    /**
     * Method to turn an object with a type "UserTradingDTO" to an object with type "UserTradingEntity"
     * @param userTradingDTO The object who is going to turn into a UserTradingDTO
     * @return The object gave for param converted to a UserTradingEntity type
     */
    public UserTradingEntity convertUserTradingDTOToUserTradingEntity(UserTradingDTO userTradingDTO){
        UserTradingEntity userTradingEntity = new UserTradingEntity();
        try {
            userTradingEntity = Mapper.modelMapper().map(userTradingDTO, UserTradingEntity.class);
        }catch (Exception e){
            log.error(Responses.INTERNAL_SERVER_ERROR + e);
        }
        return userTradingEntity;
    }
}