package com.trading.TradingUpFundationBackend.service.IMPL;

import com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse.IAdminTradingResponse;//Package that allows the use of the response of the entity AdminTrading
import com.trading.TradingUpFundationBackend.commons.constant.response.GeneralResponse;//Package that allows the use of a GeneralResponse
import com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse.Converter.AdminTradingConverter;//Package that allows use the object AdminTradingConverter
import com.trading.TradingUpFundationBackend.commons.domains.DTO.AdminTradingDTO;//Package that allows to use the serializable version of the entity AdminTradingEntity; AdminTradingDTO
import com.trading.TradingUpFundationBackend.commons.domains.entity.AdminTradingEntity;//Package that allows to use the Entity AdminTradingEntity
import com.trading.TradingUpFundationBackend.commons.domains.GenericResponseDTO;//Package that allows a Generic Response with a type DTO
import com.trading.TradingUpFundationBackend.repository.IAdminTradingRepository;//Package that allows to use the repository IAdminTradingRepository
import com.trading.TradingUpFundationBackend.service.IAdminTradingService;//Package that allows the use of the interface "IAdminTradingService"
import lombok.extern.log4j.Log4j2;//Package that allows the use of logs to represent a specific message
import org.springframework.beans.factory.annotation.Autowired;//Package that allows the use of the annotation @Autowired to represent the injection of dependencies in the spring context
import org.springframework.http.HttpStatus;//Package that allows the use of Http codes
import org.springframework.http.ResponseEntity;//Package that allows the creations and use of an Entity's response
import org.springframework.stereotype.Service;//Package that allows the use the annotation @Service to represent this class like a service in the spring context

import java.util.List;//Package that allows the use of dynamic list
import java.util.Optional;//Package

@Service
@Log4j2
public class AdminTradingService implements IAdminTradingService {

    @Autowired
    private IAdminTradingRepository respository;
    @Autowired
    private AdminTradingConverter converter;

    /**
     * Method who creates an admin
     * @param adminTradingDTO An admin who is gonna bre created
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override
    public ResponseEntity<GenericResponseDTO> createAdminTrading(AdminTradingDTO adminTradingDTO) {
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
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(IAdminTradingResponse.ADMIN_REGISTRATION_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        } catch (Exception e) {
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponseDTO.builder()
                            .message(GeneralResponse.INTERNAL_SERVER_ERROR)
                            .objectResponse(null)
                            .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }

    /**
     * Method who reads an admin
     * @param adminTradingDTO An admin who is gonna be readed
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override
    public ResponseEntity<GenericResponseDTO> readAdminTrading(AdminTradingDTO adminTradingDTO) {
        try {
            Optional<AdminTradingEntity> adminTradingExist = this.respository.findById(adminTradingDTO.getId());
            if(!adminTradingExist.isPresent()){
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .objectResponse(adminTradingExist)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            }else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(IAdminTradingResponse.ADMIN_SEARCHED_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        }catch (Exception e){
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponseDTO.builder()
                            .message(GeneralResponse.OPERATION_FAIL)
                            .objectResponse(null)
                            .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }

    /**
     * Method who reads all the admins
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override
    public ResponseEntity<GenericResponseDTO> readAdminsTrading() {
        try {
            List<AdminTradingEntity> listAdminsTrading = this.respository.findAll();
            if(!listAdminsTrading.isEmpty()){
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .objectResponse(listAdminsTrading)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            }else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(IAdminTradingResponse.ADMIN_SEARCHED_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        }catch (Exception e){
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponseDTO.builder()
                            .message(GeneralResponse.INTERNAL_SERVER_ERROR)
                            .objectResponse(null)
                            .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }

    /**
     * Method that update an admin
     * @param adminTradingDTO The admin who is gonna be updated
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override
    public ResponseEntity<GenericResponseDTO> updateAdminTrading(AdminTradingDTO adminTradingDTO) {
        try {
            Optional<AdminTradingEntity> adminTradingExist = this.respository.findById(adminTradingDTO.getId());
            if(!adminTradingExist.isPresent()){
                AdminTradingEntity adminTradingEntity = this.converter.convertAdminTradingDTOToAdminTradingEntity(adminTradingDTO);
                this.respository.save(adminTradingEntity);
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .objectResponse(IAdminTradingResponse.ADMIN_UPDATE_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            }else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(IAdminTradingResponse.ADMIN_UPDATE_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        }catch (Exception e){
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponseDTO.builder()
                            .message(GeneralResponse.INTERNAL_SERVER_ERROR)
                            .objectResponse(null)
                            .httpResponse(HttpStatus.BAD_REQUEST.value())
                            .build());
        }
    }

    /**
     * Method that update an admin
     * @param adminId The id of the admin who is gonna be deleted
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override
    public ResponseEntity<GenericResponseDTO> deleteAdminTrading(Integer adminId) {
        try {
            Optional<AdminTradingEntity> adminTradingExist = this.respository.findById(adminId);
            if(adminTradingExist.isPresent()){
                this.respository.deleteById(adminId);
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .objectResponse(IAdminTradingResponse.ADMIN_DELETE_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            }else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(IAdminTradingResponse.ADMIN_DELETE_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        }catch (Exception e){
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponseDTO.builder()
                            .message(GeneralResponse.INTERNAL_SERVER_ERROR)
                            .objectResponse(null)
                            .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }
}