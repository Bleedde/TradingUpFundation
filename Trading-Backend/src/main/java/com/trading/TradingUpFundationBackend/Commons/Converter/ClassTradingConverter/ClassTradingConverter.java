package com.trading.TradingUpFundationBackend.Commons.Converter.ClassTradingConverter;

import com.trading.TradingUpFundationBackend.Commons.Constant.Response.GeneralResponse;//Package to use a general response created in another package
import com.trading.TradingUpFundationBackend.Commons.Domains.DTO.ClassTradingDTO.ClassTradingDTO;//Package to import the DTO object "Class"
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.ClassTradingEntity.ClassTradingEntity;//Package to import the entity "Class"
import com.trading.TradingUpFundationBackend.Commons.Helper.HelperMapper;//Package to import yhe object "HelpeperMapper"
import lombok.extern.log4j.Log4j2;//Package who allows log better responses
import org.springframework.stereotype.Component;//Package to represent this class like a component in the spring context

@Component//Annotation to represent this class like a "Bean" or a "Component" in java context
@Log4j2//Annotation to log some messages depending on the context
/**
 * Class to represent the converter between the object "ClassTradingEntity" and "ClassTradingDTO"
 */
public class ClassTradingConverter {
    /**
     * Method to turn an object with a type "ClassTradingEntity" to an object with type "ClassTradingDTO"
     * @param classTradingEntity The object who is going to turn into a ClassTradingDTO
     * @return The object gave for param converted to a ClassTradingDTO type
     */
    public ClassTradingDTO convertClassTradingEntityToClassTradingDTO(ClassTradingEntity classTradingEntity){
        ClassTradingDTO classTradingDTO = new ClassTradingDTO();
        try {
            classTradingDTO = HelperMapper.modelMapper().map(classTradingEntity, ClassTradingDTO.class);
        } catch (Exception e){
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR + e);
        }
        return classTradingDTO;
    }
    /**
     * Method to turn an object with a type "ClassTradingDTO" to an object with type "ClassTradingEntity"
     * @param classTradingDTO The object who is going to turn into a ClassTradingDTO
     * @return The object gave for param converted to a ClassTradingEntity type
     */
    public ClassTradingEntity convertClassTradingDTOToClassTradingEntity(ClassTradingDTO classTradingDTO){
        ClassTradingEntity classTradingEntity = new ClassTradingEntity();
        try{
            classTradingEntity = HelperMapper.modelMapper().map(classTradingDTO, ClassTradingEntity.class);
        } catch (Exception e){
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR + e);
        }
        return classTradingEntity;
    }
}
