package com.trading.TradingUpFundationBackend.commons.constant.deserializable;

import com.trading.TradingUpFundationBackend.commons.constant.response.Responses;//Package to use a general response created in another package
import com.trading.TradingUpFundationBackend.commons.domains.DTO.ExerciseTradingDTO;
import com.trading.TradingUpFundationBackend.commons.domains.entity.ExerciseTradingEntity;
import com.trading.TradingUpFundationBackend.commons.mapper.Mapper;//Package to import yhe object "Mapper"
import lombok.extern.log4j.Log4j2;//Package who allows log better responses
import org.springframework.stereotype.Component;//Package to represent this class like a component in the spring context

@Component//Annotation to represent this class like a "Bean" or a "Component" in java context
@Log4j2//Annotation to log some messages depending on the context
public class ExerciseTradingDeserializable {

    /**
     * Method to turn an object with a type "ExerciseTradingDTO" to an object with type "ExerciseTradingEntity"
     * @param exerciseTradingDTO The object who is going to turn into a ClassTradingDTO
     * @return The object gave for param converted to a ExerciseTradingEntity type
     */
    public ExerciseTradingEntity convertExerciseTradingDTOToExerciseTradingEntity(ExerciseTradingDTO exerciseTradingDTO){
        ExerciseTradingEntity exerciseTradingEntity = new ExerciseTradingEntity();
        try {
            exerciseTradingEntity = Mapper.modelMapper().map(exerciseTradingDTO, ExerciseTradingEntity.class);
        }catch (Exception e){
            log.error(Responses.INTERNAL_SERVER_ERROR + e);
        }
        return exerciseTradingEntity;
    }
}
