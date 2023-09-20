package com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse.Converter;

import com.trading.TradingUpFundationBackend.commons.constant.response.GeneralResponse;//Package to use a general response created in another package
import com.trading.TradingUpFundationBackend.commons.domains.DTO.UserTradingDTO;//Package to import the DTO object "User"
import com.trading.TradingUpFundationBackend.commons.domains.entity.AdminTradingEntity;
import com.trading.TradingUpFundationBackend.commons.domains.entity.UserTradingEntity;//Package to import the entity "User"
import com.trading.TradingUpFundationBackend.commons.helper.HelperMapper;//Package to import the object "HelpeperMapper"
import lombok.extern.log4j.Log4j2;//Package who allows log better responses
import org.springframework.stereotype.Component;//Package to represent this class like a component in the spring context

@Component//Annotation to represent this class like a "Bean" or a "Component" in java context
@Log4j2//Annotation to log some messages depending on the context
/**
 * Class to represent the converter between the object "UserTradingEntity" and "UserTradingDTO"
 */
public class UserTradingConverter {
    /**
     * Method to turn an object with a type "UserTradingEntity" to an object with type "UserTradingDTO"
     * @param userTradingEntity The object who is going to turn into a UserTradingDTO
     * @return The object gave for param converted to a UserTradingDTO type
     */
    public UserTradingDTO convertUserTradingEntityToUserTradingDTO(UserTradingEntity userTradingEntity){
        UserTradingDTO userTradingDTO = new UserTradingDTO();
        try {
            userTradingDTO = HelperMapper.modelMapper().map(userTradingEntity, UserTradingDTO.class);
        }catch (Exception e){
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR + e);
        }
        return userTradingDTO;
    }

    /**
     * Method to turn an object with a type "UserTradingDTO" to an object with type "UserTradingEntity"
     * @param userTradingDTO The object who is going to turn into a UserTradingDTO
     * @return The object gave for param converted to a UserTradingEntity type
     */
    public UserTradingEntity convertUserTradingDTOToUserTradingEntity(UserTradingDTO userTradingDTO){
        UserTradingEntity userTradingEntity = new UserTradingEntity();
        try {
            userTradingEntity = HelperMapper.modelMapper().map(userTradingDTO, UserTradingEntity.class);
        }catch (Exception e){
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR + e);
        }
        return userTradingEntity;
    }
}
