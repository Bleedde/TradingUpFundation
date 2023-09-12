package com.trading.TradingUpFundationBackend.Commons.Converter.LevelTradingConverter;

import com.trading.TradingUpFundationBackend.Commons.Constant.Response.GeneralResponse;//Package to use a general response created in another package
import com.trading.TradingUpFundationBackend.Commons.Domains.DTO.LevelTradingDTO.LevelTradingDTO;//Package to import the DTO object "Level"
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.LevelTradingEntity.LevelTradingEntity;//Package to import the entity "Level"
import com.trading.TradingUpFundationBackend.Commons.Helper.HelperMapper;//Package to import the object "HelpeperMapper"
import lombok.extern.log4j.Log4j2;//Package who allows log better responses
import org.springframework.stereotype.Component;//Package to represent this class like a component in the spring context

@Component//Annotation to represent this class like a "Bean" or a "Component" in java context
@Log4j2//Annotation to log some messages depending on the context
/**
 * Class to represent the converter between the object "LevelTradingEntity" and "LevelTradingDTO"
 */
public class LevelTradingConverter {

    /**
     * Method to turn an object with a type "LevelTradingDTO" to an object with type "LevelTradingEntity"
     * @param levelTradingDTO The object who is going to turn into a LevelTradingDTO
     * @return The object gave for param converted to a LevelTradingEntity type
     */
    public LevelTradingEntity converterLevelTradingDTOToLevelTradingEntity(LevelTradingDTO levelTradingDTO){
        LevelTradingEntity levelTradingEntity = new LevelTradingEntity();
        try {
            levelTradingEntity = HelperMapper.modelMapper().map(levelTradingDTO, LevelTradingEntity.class);
        }catch (Exception e){
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR + e);
        }
        return levelTradingEntity;
    }

    /**
     * Method to turn an object with a type "LevelTradingEntity" to an object with type "LevelTradingDTO"
     * @param levelTradingEntity The object who is going to turn into a LevelTradingDTO
     * @return The object gave for param converted to a LevelTradingDTO type
     */
    public LevelTradingDTO convertLevelTradingEntityToLevelTradingDTO(LevelTradingEntity levelTradingEntity){
        LevelTradingDTO levelTradingDTO = new LevelTradingDTO();
        try {
            levelTradingDTO = HelperMapper.modelMapper().map(levelTradingEntity, LevelTradingDTO.class);
        }catch (Exception e){
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR + e);
        }
        return levelTradingDTO;
    }
}
