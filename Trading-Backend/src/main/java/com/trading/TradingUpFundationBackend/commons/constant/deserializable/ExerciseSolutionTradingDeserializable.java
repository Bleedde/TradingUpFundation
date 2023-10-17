package com.trading.TradingUpFundationBackend.commons.constant.deserializable;

import com.trading.TradingUpFundationBackend.commons.constant.response.Responses;
import com.trading.TradingUpFundationBackend.commons.domains.DTO.ExerciseSolutionTradingDTO;
import com.trading.TradingUpFundationBackend.commons.domains.entity.ExerciseSolutionTradingEntity;
import com.trading.TradingUpFundationBackend.commons.mapper.Mapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class ExerciseSolutionTradingDeserializable {

    public ExerciseSolutionTradingEntity convertExerciseSolutionTradingDTOToExerciseSolutionTradingEntity(ExerciseSolutionTradingDTO exerciseSolutionTradingDTO){
        ExerciseSolutionTradingEntity exerciseSolutionTradingEntity = new ExerciseSolutionTradingEntity();
        try {
            exerciseSolutionTradingEntity = Mapper.modelMapper().map(exerciseSolutionTradingDTO, ExerciseSolutionTradingEntity.class);
        }catch (Exception e){
            log.error(Responses.INTERNAL_SERVER_ERROR + e);
        }
        return exerciseSolutionTradingEntity;
    }

}
