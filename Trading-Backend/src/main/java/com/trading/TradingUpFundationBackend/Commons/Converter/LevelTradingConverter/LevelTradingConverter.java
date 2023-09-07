package com.trading.TradingUpFundationBackend.Commons.Converter.LevelTradingConverter;

import com.trading.TradingUpFundationBackend.Commons.Constant.Response.GeneralResponse;
import com.trading.TradingUpFundationBackend.Commons.Domains.DTO.LevelTradingDTO.LevelTradingDTO;
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.LevelTradingEntity.LevelTradingEntity;
import com.trading.TradingUpFundationBackend.Commons.Helper.HelperMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class LevelTradingConverter {
    public LevelTradingEntity converterLevelTradingDTOToLevelTradingEntity(LevelTradingDTO levelTradingDTO){
        LevelTradingEntity levelTradingEntity = new LevelTradingEntity();
        try {
            levelTradingEntity = HelperMapper.modelMapper().map(levelTradingDTO, LevelTradingEntity.class);
        }catch (Exception e){
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR + e);
        }
        return levelTradingEntity;
    }

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
