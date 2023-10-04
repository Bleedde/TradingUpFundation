package com.trading.TradingUpFundationBackend.commons.constant.deserializable;

import com.trading.TradingUpFundationBackend.commons.constant.response.Responses;//Package to use a general response created in another package
import com.trading.TradingUpFundationBackend.commons.domains.DTO.LevelTradingDTO;//Package to import the DTO object "Level"
import com.trading.TradingUpFundationBackend.commons.domains.entity.LevelTradingEntity;//Package to import the entity "Level"
import com.trading.TradingUpFundationBackend.commons.mapper.Mapper;//Package to import the object "HelpeperMapper"
import lombok.extern.log4j.Log4j2;//Package who allows log better responses
import org.springframework.stereotype.Component;//Package to represent this class like a component in the spring context

@Component//Annotation to represent this class like a "Bean" or a "Component" in java context
@Log4j2//Annotation to log some messages depending on the context
/**
 * Class to represent the converter between the object "LevelTradingEntity" and "LevelTradingDTO"
 */
public class LevelTradingDeserializable {

    /**
     * Method to turn an object with a type "LevelTradingDTO" to an object with type "LevelTradingEntity"
     * @param levelTradingDTO The object who is going to turn into a LevelTradingDTO
     * @return The object gave for param converted to a LevelTradingEntity type
     */
    public LevelTradingEntity converterLevelTradingDTOToLevelTradingEntity(LevelTradingDTO levelTradingDTO){
        LevelTradingEntity levelTradingEntity = new LevelTradingEntity();
        try {
            levelTradingEntity = Mapper.modelMapper().map(levelTradingDTO, LevelTradingEntity.class);
        }catch (Exception e){
            log.error(Responses.INTERNAL_SERVER_ERROR + e);
        }
        return levelTradingEntity;
    }
}
