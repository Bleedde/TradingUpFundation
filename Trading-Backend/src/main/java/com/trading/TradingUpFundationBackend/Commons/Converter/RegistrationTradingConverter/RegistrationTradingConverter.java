package com.trading.TradingUpFundationBackend.Commons.Converter.RegistrationTradingConverter;

import com.trading.TradingUpFundationBackend.Commons.Constant.Response.GeneralResponse;
import com.trading.TradingUpFundationBackend.Commons.Domains.DTO.RegistrationTradingDTO.RegistrationTradingDTO;
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.RegistrationTradingEntity.RegistrationTradingEntity;
import com.trading.TradingUpFundationBackend.Commons.Helper.HelperMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class RegistrationTradingConverter {
    public RegistrationTradingDTO convertRegistrationTradingEntityToRegistrationTradingDTO(RegistrationTradingEntity registrationTradingEntity){
        RegistrationTradingDTO registrationTradingDTO = new RegistrationTradingDTO();
        try {
            registrationTradingDTO = HelperMapper.modelMapper().map(registrationTradingEntity, RegistrationTradingDTO.class);
        }catch (Exception e){
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR + e);
        }
        return registrationTradingDTO;
    }

    public RegistrationTradingEntity convertRegistrationTradingDTOToRegistrationTradingEntity(RegistrationTradingDTO registrationTradingDTO){
        RegistrationTradingEntity registrationTradingEntity = new RegistrationTradingEntity();
        try {
            registrationTradingEntity = HelperMapper.modelMapper().map(registrationTradingDTO, RegistrationTradingEntity.class);
        }catch (Exception e){
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR + e);
        }
        return registrationTradingEntity;
    }
}
