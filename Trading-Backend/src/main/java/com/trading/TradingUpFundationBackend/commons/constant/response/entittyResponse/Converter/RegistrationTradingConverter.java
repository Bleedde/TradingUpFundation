package com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse.Converter;

import com.trading.TradingUpFundationBackend.commons.constant.response.GeneralResponse;//Package to use a general response created in another package
import com.trading.TradingUpFundationBackend.commons.domains.DTO.RegistrationTradingDTO;//Package to import the DTO object "Registration"
import com.trading.TradingUpFundationBackend.commons.domains.entity.RegistrationTradingEntity;//Package to import the entity "Registration"
import com.trading.TradingUpFundationBackend.commons.helper.HelperMapper;//Package to import the object "HelpeperMapper"
import lombok.extern.log4j.Log4j2;//Package who allows log better responses
import org.springframework.stereotype.Component;//Package to represent this class like a component in the spring context

@Component//Annotation to represent this class like a "Bean" or a "Component" in java context
@Log4j2//Annotation to log some messages depending on the context
/**
 * Class to represent the converter between the object "LevelTradingEntity" and "LevelTradingDTO"
 */
public class RegistrationTradingConverter {
    /**
     * Method to turn an object with a type "RegistrationTradingEntity" to an object with type "RegistrationTradingDTO"
     * @param registrationTradingEntity The object who is going to turn into a RegistrationTradingDTO
     * @return The object gave for param converted to a RegistrationTradingDTO type
     */
    public RegistrationTradingDTO convertRegistrationTradingEntityToRegistrationTradingDTO(RegistrationTradingEntity registrationTradingEntity){
        RegistrationTradingDTO registrationTradingDTO = new RegistrationTradingDTO();
        try {
            registrationTradingDTO = HelperMapper.modelMapper().map(registrationTradingEntity, RegistrationTradingDTO.class);
        }catch (Exception e){
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR + e);
        }
        return registrationTradingDTO;
    }

    /**
     * Method to turn an object with a type "RegistrationTradingDTO" to an object with type "RegistrationTradingEntity"
     * @param registrationTradingDTO The object who is going to turn into a RegistrationTradingDTO
     * @return The object gave for param converted to a RegistrationTradingEntity type
     */
    public RegistrationTradingEntity convertRegistrationTradingDTOToRegistrationTradingEntity(RegistrationTradingDTO registrationTradingDTO){
        RegistrationTradingEntity registrationTradingEntity = new RegistrationTradingEntity();
        try {
            registrationTradingEntity = HelperMapper.modelMapper().map(registrationTradingDTO, RegistrationTradingEntity.class);
        }catch (Exception e){
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR + e);
        }
        return registrationTradingEntity;
    }
}
