package com.trading.TradingUpFundationBackend.commons.constant.deserializable;

import com.trading.TradingUpFundationBackend.commons.constant.response.Responses;//Package to use a general response created in another package
import com.trading.TradingUpFundationBackend.commons.domains.DTO.RegistrationTradingDTO;//Package to import the DTO object "Registration"
import com.trading.TradingUpFundationBackend.commons.domains.entity.RegistrationTradingEntity;//Package to import the entity "Registration"
import com.trading.TradingUpFundationBackend.commons.mapper.Mapper;//Package to import the object "HelpeperMapper"
import lombok.extern.log4j.Log4j2;//Package who allows log better responses
import org.springframework.stereotype.Component;//Package to represent this class like a component in the spring context

@Component//Annotation to represent this class like a "Bean" or a "Component" in java context
@Log4j2//Annotation to log some messages depending on the context
/**
 * Class to represent the converter between the object "LevelTradingEntity" and "LevelTradingDTO"
 */
public class RegistrationTradingDeserializable {

    /**
     * Method to turn an object with a type "RegistrationTradingDTO" to an object with type "RegistrationTradingEntity"
     * @param registrationTradingDTO The object who is going to turn into a RegistrationTradingDTO
     * @return The object gave for param converted to a RegistrationTradingEntity type
     */
    public RegistrationTradingEntity convertRegistrationTradingDTOToRegistrationTradingEntity(RegistrationTradingDTO registrationTradingDTO){
        RegistrationTradingEntity registrationTradingEntity = new RegistrationTradingEntity();
        try {
            registrationTradingEntity = Mapper.modelMapper().map(registrationTradingDTO, RegistrationTradingEntity.class);
        }catch (Exception e){
            log.error(Responses.INTERNAL_SERVER_ERROR + e);
        }
        return registrationTradingEntity;
    }
}
