package com.trading.TradingUpFundationBackend.Service.AdminTradingService.AdminTradingServiceIMPL;

import com.trading.TradingUpFundationBackend.Commons.Constant.Response.AdminTradingResponse.IAdminTradingResponse;
import com.trading.TradingUpFundationBackend.Commons.Constant.Response.GeneralResponse;
import com.trading.TradingUpFundationBackend.Commons.Converter.AdminTradingConverter.AdminTradingConverter;
import com.trading.TradingUpFundationBackend.Commons.Domains.DTO.AdminTradingDTO.AdminTradingDTO;
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.AdminTradinEntity.AdminTradingEntity;
import com.trading.TradingUpFundationBackend.Commons.Domains.ResponseDTO.GenericResponseDTO;
import com.trading.TradingUpFundationBackend.Repository.AdminTradingRepository.IAdminTradingRepository;
import com.trading.TradingUpFundationBackend.Service.AdminTradingService.IAdminTradingService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class AdminTradingService implements IAdminTradingService {
    @Autowired
    private IAdminTradingRepository respository;
    @Autowired
    private AdminTradingConverter converter;
    public ResponseEntity<GenericResponseDTO> createAdmin(AdminTradingDTO adminTradingDTO) {
        try {
            Optional<AdminTradingEntity> adminTradingExist = this.respository.findById(adminTradingDTO.getId());
            if (!adminTradingExist.isPresent()) {
                AdminTradingEntity entity = this.converter.convertAdminTradingDTOToAdminTradingEntity(adminTradingDTO);
                this.respository.save(entity);
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .objectResponse(IAdminTradingResponse.ADMIN_REGISTRATION_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            }else {
                ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(IAdminTradingResponse.ADMIN_REGISTRATION_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        } catch (Exception e){
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponseDTO.builder()
                            .message(GeneralResponse.INTERNAL_SERVER_ERROR)
                            .objectResponse(null)
                            .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }
}
