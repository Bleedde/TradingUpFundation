package com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse.Converter;

import com.trading.TradingUpFundationBackend.commons.constant.response.GeneralResponse;//Package to use a general response created in another package
import com.trading.TradingUpFundationBackend.commons.domains.DTO.ContentTradingDTO;//Package to import the DTO object "Content"
import com.trading.TradingUpFundationBackend.commons.domains.entity.ContentTradingEntity;//Package to import the entity "Content"
import com.trading.TradingUpFundationBackend.commons.helper.HelperMapper;//Package to import yhe object "HelpeperMapper"
import lombok.extern.log4j.Log4j2;//Package who allows log better responses
import org.springframework.stereotype.Component;//Package to represent this class like a component in the spring context

@Component//Annotation to represent this class like a "Bean" or a "Component" in java context
@Log4j2//Annotation to log some messages depending on the context
/**
 * Class to represent the converter between the object "ClassTradingEntity" and "ContentTradingDTO"
 */
public class ContentTradingConverter {
    /**
     * Method to turn a object with a type "ClassTradingEntity" to an object with type "ClassTradingDTO"
     * @param contentTradingEntity The object who is going to turn into a ClassTradingDTO
     * @return The object gave for param converted to a ClassTradingDTO type
     */
    public ContentTradingDTO convertContentTradingEntityToContentTradingDTO(ContentTradingEntity contentTradingEntity){
        ContentTradingDTO contentTradingDTO = new ContentTradingDTO();
        try {
            contentTradingDTO = HelperMapper.modelMapper().map(contentTradingEntity, ContentTradingDTO.class);
        }catch (Exception e){
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR + e);
        }
        return contentTradingDTO;
    }
    /**
     * Method to turn an object with a type "ClassTradingDTO" to an object with type "ClassTradingEntity"
     * @param contentTradingDTO The object who is going to turn into a ClassTradingDTO
     * @return The object gave for param converted to a ClassTradingEntity type
     */
    public ContentTradingEntity converContentTradingDTOToContentTradingEntity(ContentTradingDTO contentTradingDTO){
        ContentTradingEntity contentTradingEntity = new ContentTradingEntity();
        try {
            contentTradingEntity = HelperMapper.modelMapper().map(contentTradingDTO, ContentTradingEntity.class);
        }catch (Exception e){
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR + e);
        }
        return contentTradingEntity;
    }

}
