package com.trading.TradingUpFundationBackend.commons.constant.deserializable;

import com.trading.TradingUpFundationBackend.commons.constant.response.Responses;//Package to use a general response created in another package
import com.trading.TradingUpFundationBackend.commons.domains.DTO.ClassTradingDTO;//Package to import the DTO object "Class"
import com.trading.TradingUpFundationBackend.commons.domains.entity.ClassTradingEntity;//Package to import the entity "Class"
import com.trading.TradingUpFundationBackend.commons.mapper.Mapper;//Package to import yhe object "HelpeperMapper"
import lombok.extern.log4j.Log4j2;//Package who allows log better responses
import org.springframework.stereotype.Component;//Package to represent this class like a component in the spring context

@Component//Annotation to represent this class like a "Bean" or a "Component" in java context
@Log4j2//Annotation to log some messages depending on the context
/**
 * Class to represent the converter between the object "ClassTradingEntity" and "ClassTradingDTO"
 */
public class ClassTradingDeserializable {

    /**
     * Method to turn an object with a type "ClassTradingDTO" to an object with type "ClassTradingEntity"
     * @param classTradingDTO The object who is going to turn into a ClassTradingDTO
     * @return The object gave for param converted to a ClassTradingEntity type
     */
    public ClassTradingEntity convertClassTradingDTOToClassTradingEntity(ClassTradingDTO classTradingDTO){
        ClassTradingEntity classTradingEntity = new ClassTradingEntity();
        try{
            classTradingEntity = Mapper.modelMapper().map(classTradingDTO, ClassTradingEntity.class);
        } catch (Exception e){
            log.error(Responses.INTERNAL_SERVER_ERROR + e);
        }
        return classTradingEntity;
    }
}
