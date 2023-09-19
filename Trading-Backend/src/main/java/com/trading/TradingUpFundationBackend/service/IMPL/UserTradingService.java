package com.trading.TradingUpFundationBackend.service.IMPL;

import com.trading.TradingUpFundationBackend.commons.constant.response.GeneralResponse;//Package that allows the use of a GeneralResponse
import com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse.IUserTradingResponse;//Package that allows use the object UserTradingConverter
import com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse.Converter.UserTradingConverter;//Package that allows use the object UserTradingConverter
import com.trading.TradingUpFundationBackend.commons.domains.DTO.UserTradingDTO;//Package that allows to use the serializable version of the entity UserTradingEntity; RegistrationTradingDTO
import com.trading.TradingUpFundationBackend.commons.domains.entity.UserTradingEntity;//Package that allows to use the Entity UserTradingEntity
import com.trading.TradingUpFundationBackend.commons.domains.GenericResponseDTO;//Package that allows a Generic Response with a type DTO
import com.trading.TradingUpFundationBackend.repository.IUserTradingRepository;//Package that allows to use the repository ILevelTradingRepository
import com.trading.TradingUpFundationBackend.service.IUserTradingService;//Package that allows the use of the interface "ILevelTradingService"
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
 * Class that represents all the services of the entity "UserTrading"
 */
public class UserTradingService implements IUserTradingService {

    @Autowired//Annotation that injects the dependencies from de repository related with the entity "UserTrading"
    private IUserTradingRepository repository;
    @Autowired//Annotation that injects the dependencies from the converter related with the entity "UserTrading"
    private UserTradingConverter converter;

    /**
     * Method that creates a user
     * @param userTradingDTO The user to be created
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<GenericResponseDTO> createUserTrading(UserTradingDTO userTradingDTO) {
        try {
            Optional<UserTradingEntity> userTradingExist = this.repository.findById(userTradingDTO.getId());
            if (!userTradingExist.isPresent()) {
                UserTradingEntity entity = this.converter.convertUserTradingDTOToUserTradingEntity(userTradingDTO);
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .objectResponse(IUserTradingResponse.USER_REGISTRATION_SUCCESS)
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(IUserTradingResponse.USER_REGISTRATION_FAILED)
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
     * Method that reads a user
     * @param userTradingDTO The user to be readed
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<GenericResponseDTO> readUserTrading(UserTradingDTO userTradingDTO) {
        try {
            Optional<UserTradingEntity> userTradingExist = this.repository.findById(userTradingDTO.getId());
            if (!userTradingExist.isPresent()) {
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .objectResponse(userTradingExist)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(IUserTradingResponse.USER_SEARCHED_FAILED)
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
     * Method that reads all the users
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<GenericResponseDTO> readUsersTrading() {
        try {
            List<UserTradingEntity> userTradingEntityList = this.repository.findAll();
            if (!userTradingEntityList.isEmpty()) {
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .objectResponse(userTradingEntityList)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(IUserTradingResponse.USER_SEARCHED_FAILED)
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
     * Method that updates a user
     * @param userTradingDTO The user to be updated
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<GenericResponseDTO> updateUserTrading(UserTradingDTO userTradingDTO) {
        try {
            Optional<UserTradingEntity> userTradingExist = this.repository.findById(userTradingDTO.getId());
            if (!userTradingExist.isPresent()) {
                UserTradingEntity entity = this.converter.convertUserTradingDTOToUserTradingEntity(userTradingDTO);
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .objectResponse(IUserTradingResponse.USER_UPDATED_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(IUserTradingResponse.USER_UPDATED_FAILED)
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
     * Method that deletes a user
     * @param userId The id of the user to be deleted
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<GenericResponseDTO> deleteUserTrading(Integer userId) {
        try {
            Optional<UserTradingEntity> userTradingExist = this.repository.findById(userId);
            if (userTradingExist.isPresent()) {
                this.repository.deleteById(userId);
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .objectResponse(IUserTradingResponse.USER_DELETED_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(IUserTradingResponse.USER_DELETED_FAILED)
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