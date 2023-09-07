package com.trading.TradingUpFundationBackend.Commons.Converter.ContentTradingConverter;

import com.trading.TradingUpFundationBackend.Commons.Constant.Response.GeneralResponse;
import com.trading.TradingUpFundationBackend.Commons.Domains.DTO.ContentTradingDTO.ContentTradingDTO;
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.ContentTradingEntity.ContentTradingEntity;
import com.trading.TradingUpFundationBackend.Commons.Helper.HelperMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class ContentTradingConverter {
    public ContentTradingDTO convertContentTradingEntityToContentTradingDTO(ContentTradingEntity contentTradingEntity){
        ContentTradingDTO contentTradingDTO = new ContentTradingDTO();
        try {
            contentTradingDTO = HelperMapper.modelMapper().map(contentTradingEntity, ContentTradingDTO.class);
        }catch (Exception e){
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR + e);
        }
        return contentTradingDTO;
    }

    public ContentTradingEntity converContentTradingDTOToContentTradingEntity(ContentTradingDTO contentTradingDTO){
        ContentTradingEntity contentTradingEntity = new ContentTradingEntity();
        try {
            contentTradingEntity = HelperMapper.modelMapper().map(contentTradingDTO, ContentTradingEntity.class);
        }catch (Exception e){
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR + e);
        }
        return contentTradingEntity;
    }

}
