package com.trading.TradingUpFundationBackend.service.IMPL;

import com.trading.TradingUpFundationBackend.commons.constant.response.GeneralResponse;//Package that allows the use of a GeneralResponse
import com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse.ILevelTradingResponse;//Package that allows the use of the response of the entity LevelTrading
import com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse.Converter.LevelTradingConverter;//Package that allows use the object LevelTradingConverter
import com.trading.TradingUpFundationBackend.commons.domains.DTO.LevelTradingDTO;//Package that allows to use the serializable version of the entity LevelTradingEntity; LevelTradingDTO
import com.trading.TradingUpFundationBackend.commons.domains.entity.LevelTradingEntity;//Package that allows to use the Entity LevelTradingEntity
import com.trading.TradingUpFundationBackend.commons.domains.GenericResponseDTO;//Package that allows a Generic Response with a type DTO
import com.trading.TradingUpFundationBackend.repository.ILevelTradingRepository;//Package that allows to use the repository ILevelTradingRepository
import com.trading.TradingUpFundationBackend.service.ILevelTradingService;//Package that allows the use of the interface "ILevelTradingService"
import lombok.extern.log4j.Log4j2;//Package that allows the use of logs to represent a specific message
import org.springframework.beans.factory.annotation.Autowired;//Package that allows the use of the annotation @Autowired to represent the injection of dependencies in the spring context
import org.springframework.http.HttpStatus;//Package that allows the use of Http codes
import org.springframework.http.ResponseEntity;//Package that allows the creations and use of an Entity's response
import org.springframework.stereotype.Service;//Package that allows the use the annotation @Service to represent this class like a service in the spring context

import java.util.List;//Package that allows the use of dynamic list
import java.util.Optional;//Package that allows the use of the datatype "Optional"

@Service//Annotation who represent this class like a component with type "Service" in the spring context
@Log4j2//Annotation who allows the use of specifics responses
/**
 * Class that represents all the services of the entity "LevelTrading"
 */

public class LevelTradingService implements ILevelTradingService {

    @Autowired//Annotation that injects the dependencies from de repository related with the entity "LevelTrading"
    private ILevelTradingRepository repository;
    @Autowired//Annotation that injects the dependencies from the converter related with the entity "LevelTrading"
    private LevelTradingConverter converter;

    /**
     * Method that creates a level
     * @param levelTradingDTO The level to be created
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<GenericResponseDTO> createLevelTrading(LevelTradingDTO levelTradingDTO) {
        try {
            Optional<LevelTradingEntity> levelTradingExist = this.repository.findById(levelTradingDTO.getId());
            if (!levelTradingExist.isPresent()) {
                LevelTradingEntity entity = this.converter.converterLevelTradingDTOToLevelTradingEntity(levelTradingDTO);
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .objectResponse(ILevelTradingResponse.LEVEL_REGISTRATION_SUCCESS)
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(ILevelTradingResponse.LEVEL_REGISTRATION_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        } catch (Exception e) {
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body(GenericResponseDTO.builder()
                            .message(GeneralResponse.INTERNAL_SERVER_ERROR)
                            .objectResponse(null)
                            .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }

    /**
     * Method that reads a level
     * @param levelTradingDTO The level to be readed
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<GenericResponseDTO> readLevelTrading(LevelTradingDTO levelTradingDTO) {
        try {
            Optional<LevelTradingEntity> levelTradingExist = this.repository.findById(levelTradingDTO.getId());
            if (!levelTradingExist.isPresent()) {
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .objectResponse(levelTradingExist)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(ILevelTradingResponse.LEVEL_SEARCHED_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        } catch (Exception e) {
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(GenericResponseDTO.builder()
                    .message(GeneralResponse.INTERNAL_SERVER_ERROR)
                    .objectResponse(null)
                    .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build());
        }
    }

    /**
     * Method that reads all the levels
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<GenericResponseDTO> readLevelsTrading() {
        try {
            List<LevelTradingEntity> levelTradingEntityList = this.repository.findAll();
            if (!levelTradingEntityList.isEmpty()) {
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .objectResponse(levelTradingEntityList)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(ILevelTradingResponse.LEVEL_SEARCHED_FAILED)
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
     * Method that updates a level
     * @param levelTradingDTO The level to be updated
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<GenericResponseDTO> updateLevelTrading(LevelTradingDTO levelTradingDTO) {
        try {
            Optional<LevelTradingEntity> levelTradingExist = this.repository.findById(levelTradingDTO.getId());
            if (!levelTradingExist.isPresent()) {
                LevelTradingEntity entity = this.converter.converterLevelTradingDTOToLevelTradingEntity(levelTradingDTO);
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .objectResponse(ILevelTradingResponse.LEVEL_UPDATED_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(ILevelTradingResponse.LEVEL_UPDATED_FAILED)
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
     * Method that deletes a level
     * @param levelId The level to be deleted
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<GenericResponseDTO> deleteLevelTrading(Integer levelId) {
        try {
            Optional<LevelTradingEntity> levelTradingExist = this.repository.findById(levelId);
            if (levelTradingExist.isPresent()) {
                this.repository.deleteById(levelId);
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .objectResponse(ILevelTradingResponse.LEVEL_DELETED_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(ILevelTradingResponse.LEVEL_DELETED_FAILED)
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
}