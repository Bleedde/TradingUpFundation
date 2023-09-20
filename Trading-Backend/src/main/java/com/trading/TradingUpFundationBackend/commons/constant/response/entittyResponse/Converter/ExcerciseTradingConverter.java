package com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse.Converter;

import com.trading.TradingUpFundationBackend.commons.constant.response.GeneralResponse;//Package to use a general response created in another package
import com.trading.TradingUpFundationBackend.commons.domains.DTO.ExcerciseTradingDTO;//Package to import the DTO object "Excercise"
import com.trading.TradingUpFundationBackend.commons.domains.entity.ExcerciseTradingEntity;//Package to import the entity "Excercise"
import com.trading.TradingUpFundationBackend.commons.helper.HelperMapper;//Package to import yhe object "HelpeperMapper"
import lombok.extern.log4j.Log4j2;//Package who allows log better responses
import org.springframework.stereotype.Component;//Package to represent this class like a component in the spring context

@Component//Annotation to represent this class like a "Bean" or a "Component" in java context
@Log4j2//Annotation to log some messages depending on the context
/**
 * Class to represent the converter between the object "ExcerciseTradingEntity" and "ExcerciseTradingDTO"
 */
public class ExcerciseTradingConverter {
    /**
     * Method to turn an object with a type "ExcerciseTradingEntity" to an object with type "ExcerciseTradingDTO"
     * @param excerciseTradingEntity The object who is going to turn into a ExcerciseTradingDTO
     * @return The object gave for param converted to a ExcerciseTradingDTO type
     */
    public ExcerciseTradingDTO convertExcerciseTradingEntityToExcerciseTradingDTO(ExcerciseTradingEntity excerciseTradingEntity){
        ExcerciseTradingDTO excerciseTradingDTO = new ExcerciseTradingDTO();
        try {
            excerciseTradingDTO = HelperMapper.modelMapper().map(excerciseTradingEntity, ExcerciseTradingDTO.class);
        }catch (Exception e) {
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR + e);
        }
        return excerciseTradingDTO;
    }
    /**
     * Method to turn an object with a type "ExcerciseTradingDTO" to an object with type "ExcerciseTradingEntity"
     * @param excerciseTradingDTO The object who is going to turn into a ClassTradingDTO
     * @return The object gave for param converted to a ExcerciseTradingEntity type
     */
    public ExcerciseTradingEntity convertExcerciseTradingDTOToExcerciseTradingEntity(ExcerciseTradingDTO excerciseTradingDTO){
        ExcerciseTradingEntity excerciseTradingEntity = new ExcerciseTradingEntity();
        try {
            excerciseTradingEntity = HelperMapper.modelMapper().map(excerciseTradingDTO, ExcerciseTradingEntity.class);
        }catch (Exception e){
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR + e);
        }
        return excerciseTradingEntity;
    }
}
