package com.trading.TradingUpFundationBackend.Commons.Converter.ExcerciseTradingConverter;

import com.trading.TradingUpFundationBackend.Commons.Constant.Response.GeneralResponse;
import com.trading.TradingUpFundationBackend.Commons.Domains.DTO.ExcerciseTradingDTO.ExcerciseTradingDTO;
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.ExcerciseTradingEntity.ExcerciseTradingEntity;
import com.trading.TradingUpFundationBackend.Commons.Helper.HelperMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class ExcerciseTradingConverter {
    public ExcerciseTradingDTO convertExcerciseTradingEntityToExcerciseTradingDTO(ExcerciseTradingEntity excerciseTradingEntity){
        ExcerciseTradingDTO excerciseTradingDTO = new ExcerciseTradingDTO();
        try {
            excerciseTradingDTO = HelperMapper.modelMapper().map(excerciseTradingEntity, ExcerciseTradingDTO.class);
        }catch (Exception e) {
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR + e);
        }
        return excerciseTradingDTO;
    }

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
