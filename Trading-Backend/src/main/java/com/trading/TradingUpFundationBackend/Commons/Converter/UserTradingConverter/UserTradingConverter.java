package com.trading.TradingUpFundationBackend.Commons.Converter.UserTradingConverter;

import com.trading.TradingUpFundationBackend.Commons.Constant.Response.GeneralResponse;
import com.trading.TradingUpFundationBackend.Commons.Domains.DTO.UserTradingDTO.UserTradingDTO;
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.UserTradingEntity.UserTradingEntity;
import com.trading.TradingUpFundationBackend.Commons.Helper.HelperMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class UserTradingConverter {
    public UserTradingDTO convertUserTradingEntityToUserTradingDTO(UserTradingEntity userTradingEntity){
        UserTradingDTO userTradingDTO = new UserTradingDTO();
        try {
            userTradingDTO = HelperMapper.modelMapper().map(userTradingEntity, UserTradingDTO.class);
        }catch (Exception e){
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR + e);
        }
        return userTradingDTO;
    }

    public UserTradingEntity convertUserTradingDTOToUserTradingEntity(UserTradingDTO userTradingDTO){
        UserTradingEntity userTradingEntity = new UserTradingEntity();
        try {
            userTradingEntity = HelperMapper.modelMapper().map(userTradingDTO, UserTradingEntity.class);
        }catch (Exception e){
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR + e);
        }
        return userTradingEntity;
    }
}
