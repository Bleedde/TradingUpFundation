package com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse.Converter;

import com.trading.TradingUpFundationBackend.commons.constant.response.GeneralResponse;//Package to use a general response created in another package
import com.trading.TradingUpFundationBackend.commons.domains.DTO.AdminTradingDTO;//Package to import the DTO object "Admin"
import com.trading.TradingUpFundationBackend.commons.domains.entity.AdminTradingEntity;//Package to import the entity "Admin"
import com.trading.TradingUpFundationBackend.commons.helper.HelperMapper;//Package to import yhe object "HelpeperMapper"
import lombok.extern.log4j.Log4j2;//Package who allows log better responses
import org.springframework.stereotype.Component;//Package to represent this class like a component in the spring context

@Component//Annotation to represent this class like a "Bean" or a "Component" in java context
@Log4j2//Annotation to log some messages depending on the context
/**
 * Class to represent the converter between the object "AdminTradingEntity" and "AdminTradingDTO"
 */
public class AdminTradingConverter {
    /**
     * Method to turn an object with a type "AdminTradingEntity" to an object with type "AdminTradingDTO"
     * @param adminTradingEntity The object who is going to turn into a AdminTradingDTO
     * @return The object gave for param converted to a AdminTradingDTO type
     */
    public AdminTradingDTO convertAdminTradingEntityToAdminTradingDTO(AdminTradingEntity adminTradingEntity){
        AdminTradingDTO adminTradingDTO = new AdminTradingDTO();
        try {
            adminTradingDTO = HelperMapper.modelMapper().map(adminTradingEntity, AdminTradingDTO.class);
        } catch (Exception e){
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR + e);
        }
        return adminTradingDTO;
    }

    /**
     * Method to turn an object with a type "AdminTradingDTO" to an object with type "AdminTradingEntity"
     * @param adminTradingDTO The object who is going to turn into a AdminTradingEntity
     * @return The object gave for param converted to a AdminTradingEntity type
     */
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
