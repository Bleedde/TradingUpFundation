package com.trading.TradingUpFundationBackend.Commons.Converter.ClassTradingConverter;

import com.trading.TradingUpFundationBackend.Commons.Constant.Response.GeneralResponse;
import com.trading.TradingUpFundationBackend.Commons.Domains.DTO.ClassTradingDTO.ClassTradingDTO;
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.ClassTradingEntity.ClassTradingEntity;
import com.trading.TradingUpFundationBackend.Commons.Helper.HelperMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class ClassTradingConverter {
    public ClassTradingDTO convertClassTradingEntityToClassTradingDTO(ClassTradingEntity classTradingEntity){
        ClassTradingDTO classTradingDTO = new ClassTradingDTO();
        try {
            classTradingDTO = HelperMapper.modelMapper().map(classTradingEntity, ClassTradingDTO.class);
        } catch (Exception e){
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR + e);
        }
        return classTradingDTO;
    }

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
