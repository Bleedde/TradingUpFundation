package com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse.Converter;

import com.trading.TradingUpFundationBackend.commons.constant.response.GeneralResponse;//Package to use a general response created in another package
import com.trading.TradingUpFundationBackend.commons.domains.DTO.ClassPrerecordedTradingDTO;//Package to import the DTO object "Class"
import com.trading.TradingUpFundationBackend.commons.domains.entity.ClassPrerecordedTradingEntity;//Package that allows the use of the entity ClassPrerecordedTrading
import com.trading.TradingUpFundationBackend.commons.helper.HelperMapper;//Package to import yhe object "HelpeperMapper"
import lombok.extern.log4j.Log4j2;//Package who allows log better responses
import org.springframework.stereotype.Component;//Package to represent this class like a component in the spring context

@Component//Annotation to represent this class like a "Bean" or a "Component" in java context
@Log4j2//Annotation to log some messages depending on the context
/**
 * Class to represent the converter between the object "ClassTradingEntity" and "ClassTradingDTO"
 */
public class ClassPrerecordedTradingConverter {
    /**
     *git  Method to turn an object with a type "ClassTradingEntity" to an object with type "ClassTradingDTO"
     * @param classPrerecordedTradingEntity The object who is going to turn into a ClassTradingDTO
     * @return The object gave for param converted to a ClassTradingDTO type
     */
    public ClassPrerecordedTradingDTO convertClassPrerecordedTradingEntityToClassPrerecordedTradingDTO(ClassPrerecordedTradingEntity classPrerecordedTradingEntity){
        ClassPrerecordedTradingDTO classPrerecordedTradingDTO = new ClassPrerecordedTradingDTO();
        try {
            classPrerecordedTradingDTO = HelperMapper.modelMapper().map(classPrerecordedTradingEntity, ClassPrerecordedTradingDTO.class);
        } catch (Exception e){
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR + e);
        }
        return classPrerecordedTradingDTO;
    }
    /**
     * Method to turn an object with a type "ClassTradingDTO" to an object with type "ClassTradingEntity"
     * @param classPrerecordedTradingDTO The object who is going to turn into a ClassTradingDTO
     * @return The object gave for param converted to a ClassTradingEntity type
     */
    public ClassPrerecordedTradingEntity convertClassPrerecordedTradingDTOToClassPrerecordedTradingEntity(ClassPrerecordedTradingDTO classPrerecordedTradingDTO){
        ClassPrerecordedTradingEntity classPrerecordedTradingEntity = new ClassPrerecordedTradingEntity();
        try{
            classPrerecordedTradingEntity = HelperMapper.modelMapper().map(classPrerecordedTradingEntity, ClassPrerecordedTradingEntity.class);
        } catch (Exception e){
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR + e);
        }
        return classPrerecordedTradingEntity;
    }
}
