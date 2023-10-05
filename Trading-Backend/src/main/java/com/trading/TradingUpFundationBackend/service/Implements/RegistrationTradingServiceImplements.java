package com.trading.TradingUpFundationBackend.service.Implements;

import com.trading.TradingUpFundationBackend.commons.constant.response.Responses;//Package that allows the use of a Responses
import com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse.IRegistrationTradingResponse;//Package that allows use the object RegistrationTradingDeserializable
import com.trading.TradingUpFundationBackend.commons.constant.deserializable.RegistrationTradingDeserializable;//Package that allows use the object RegistrationTradingDeserializable
import com.trading.TradingUpFundationBackend.commons.domains.DTO.RegistrationTradingDTO;//Package that allows to use the serializable version of the entity RegistrationTradingEntity; RegistrationTradingDTO
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;
import com.trading.TradingUpFundationBackend.commons.domains.entity.RegistrationTradingEntity;//Package that allows to use the Entity RegistrationTradingEntity
import com.trading.TradingUpFundationBackend.repository.IRegistrationTradingRepository;//Package that allows to use the repository ILevelTradingRepository
import com.trading.TradingUpFundationBackend.service.IRegistrationTradingService;//Package that allows the use of the interface "ILevelTradingService"
import lombok.extern.log4j.Log4j2;//Package that allows the use of logs to represent a specific message
import org.springframework.beans.factory.annotation.Autowired;//Package that allows the use of the annotation @Autowired to represent the injection of dependencies in the spring context
import org.springframework.http.HttpStatus;//Package that allows the use of Http codes
import org.springframework.http.ResponseEntity;//Package that allows the creations and use of an Entity's response
import org.springframework.stereotype.Component;//Package that allows the use the annotation @Service to represent this class like a service in the spring context

import java.util.List;//Package that allows the use of dynamic list
import java.util.Optional;//Package that allows the use of the datatype "Optional"

@Component//Annotation who represent this class like a component with type "Service" in the spring context
@Log4j2//Annotation who allows the use of specifics responses

/**
 * Class that represents all the services of the entity "RegistrationTrading"
 */
public class RegistrationTradingServiceImplements implements IRegistrationTradingService {

    @Autowired//Annotation that injects the dependencies from de repository related with the entity "LevelTrading"
    private IRegistrationTradingRepository repository;
    @Autowired//Annotation that injects the dependencies from the converter related with the entity "LevelTrading"
    private RegistrationTradingDeserializable converter;

    /**
     * Method that creates a registration
     * @param registrationTradingDTO The registration to be created
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> createRegistrationTrading(RegistrationTradingDTO registrationTradingDTO) {
        try{
            Optional<RegistrationTradingEntity> registrationTradingExist = this.repository.findById(registrationTradingDTO.getId());
            if(!registrationTradingExist.isPresent()){
                RegistrationTradingEntity entity = this.converter.convertRegistrationTradingDTOToRegistrationTradingEntity(registrationTradingDTO);
                this.repository.save(entity);
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_SUCCESS)
                        .objectResponse(IRegistrationTradingResponse.REGISTRATION_REGISTRATION_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            }else{
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL)
                        .objectResponse(IRegistrationTradingResponse.REGISTRATION_REGISTRATION_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        }catch (Exception e) {
            log.error(Responses.INTERNAL_SERVER_ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ObjectResponse.builder()
                            .message(Responses.INTERNAL_SERVER_ERROR)
                            .objectResponse(null)
                            .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }

    /**
     * Method that reads a registration
     * @param registrationTradingDTO The registration to be readed
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> readRegistrationTrading(RegistrationTradingDTO registrationTradingDTO) {
        try {
            Optional<RegistrationTradingEntity> registrationTradingExist = this.repository.findById(registrationTradingDTO.getId());
            if(!registrationTradingExist.isPresent()){
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_SUCCESS)
                        .objectResponse(registrationTradingExist)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            }else {
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL)
                        .objectResponse(IRegistrationTradingResponse.REGISTRATION_SEARCHED_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        }catch (Exception e){
            log.error(Responses.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ObjectResponse.builder()
                            .message(Responses.INTERNAL_SERVER_ERROR)
                            .objectResponse(null)
                            .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }

    /**
     * Method that reads all the registrations
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> readRegistrationsTrading() {
        try {
            List<RegistrationTradingEntity> registrationTradingList = this.repository.findAll();
            if(!registrationTradingList.isEmpty()){
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_SUCCESS)
                        .objectResponse(registrationTradingList)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            }else{
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL)
                        .objectResponse(IRegistrationTradingResponse.REGISTRATION_SEARCHED_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        }catch (Exception e){
            log.error(Responses.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ObjectResponse.builder()
                            .message(Responses.INTERNAL_SERVER_ERROR)
                            .objectResponse(null)
                            .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }

    /**
     * Method that updates a registration
     * @param registrationTradingDTO The registration to be updated
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> updateRegistrationTrading(RegistrationTradingDTO registrationTradingDTO) {
        try {
            Optional<RegistrationTradingEntity> registrationTradingExist = this.repository.findById(registrationTradingDTO.getId());
            if(registrationTradingExist.isPresent()){
                RegistrationTradingEntity entity = this.converter.convertRegistrationTradingDTOToRegistrationTradingEntity(registrationTradingDTO);
                this.repository.save(entity);
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_SUCCESS)
                        .objectResponse(IRegistrationTradingResponse.REGISTRATION_UPDATED_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            }else {
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL)
                        .objectResponse(IRegistrationTradingResponse.REGISTRATION_UPDATED_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        }catch (Exception e){
            log.error(Responses.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ObjectResponse.builder()
                            .message(Responses.INTERNAL_SERVER_ERROR)
                            .objectResponse(null)
                            .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }

    /**
     * Method that deletes a registration
     * @param registrationId The id of the registration to be deleted
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override
    public ResponseEntity<ObjectResponse> deleteRegistrationTrading(Integer registrationId) {
        try {
            Optional<RegistrationTradingEntity> registrationTradingExist = this.repository.findById(registrationId);
            if(registrationTradingExist.isPresent()){
                this.repository.deleteById(registrationId);
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_SUCCESS)
                        .objectResponse(IRegistrationTradingResponse.REGISTRATION_DELETED_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            }else{
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL)
                        .objectResponse(IRegistrationTradingResponse.REGISTRATION_DELETED_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        } catch (Exception e){
            log.error(Responses.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ObjectResponse.builder()
                            .message(Responses.INTERNAL_SERVER_ERROR)
                            .objectResponse(null)
                            .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }
}
