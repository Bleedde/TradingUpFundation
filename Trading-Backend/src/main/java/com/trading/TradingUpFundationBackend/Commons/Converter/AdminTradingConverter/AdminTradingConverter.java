package com.trading.TradingUpFundationBackend.Commons.Converter.AdminTradingConverter;

import com.trading.TradingUpFundationBackend.Commons.Constant.Response.AdminTradingResponse.IAdminTradingResponse;
import com.trading.TradingUpFundationBackend.Commons.Constant.Response.GeneralResponse;
import com.trading.TradingUpFundationBackend.Commons.Domains.DTO.AdminTradingDTO.AdminTradingDTO;
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.AdminTradinEntity.AdminTradingEntity;
import com.trading.TradingUpFundationBackend.Commons.Helper.HelperMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class AdminTradingConverter {
    public AdminTradingDTO convertAdminTradingEntityToAdminTradingDTO(AdminTradingEntity adminTradingEntity){
        AdminTradingDTO adminTradingDTO = new AdminTradingDTO();
        try {
            adminTradingDTO = HelperMapper.modelMapper().map(adminTradingEntity, AdminTradingDTO.class);
        } catch (Exception e){
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR + e);
        }
        return adminTradingDTO;
    }

    public AdminTradingEntity convertAdminTradingDTOToAdminTradingEntity(AdminTradingDTO adminTradingDTO){
        AdminTradingEntity adminTradingEntity = new AdminTradingEntity();
        try {
            adminTradingEntity = HelperMapper.modelMapper().map(adminTradingDTO, AdminTradingEntity.class);
        } catch (Exception e){
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR + e);
        }
        return adminTradingEntity;
    }
}
