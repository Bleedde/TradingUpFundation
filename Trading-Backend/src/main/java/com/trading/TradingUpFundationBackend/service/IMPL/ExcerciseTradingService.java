package com.trading.TradingUpFundationBackend.service.IMPL;

import com.trading.TradingUpFundationBackend.commons.constant.response.Responses;
import com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse.IExcerciseTradingResponse;//Package that allows the use of the response of the entity ExcerciseTrading
import com.trading.TradingUpFundationBackend.commons.constant.deserializable.ExcerciseTradingDeserializable;//Package that allows use the object ExcerciseTradingDeserializable
import com.trading.TradingUpFundationBackend.commons.domains.DTO.ExcerciseTradingDTO;//Package that allows to use the serializable version of the entity ExcerciseTradingEntity; ExcerciseTradingDTO
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;
import com.trading.TradingUpFundationBackend.commons.domains.entity.ExcerciseTradingEntity;//Package that allows to use the Entity ExcerciseTradingEntity
import com.trading.TradingUpFundationBackend.repository.IExcerciseTradingRepository;//Package that allows to use the repository IExcerciseTradingRepository
import com.trading.TradingUpFundationBackend.service.IExcerciseTradingService;//Package that allows the use of the interface "IExcerciseTradingService"
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
 * Class that represents all the services of the entity "ExcerciseTrading"
 */
public class ExcerciseTradingService implements IExcerciseTradingService {

    @Autowired//Annotation that injects the dependencies from de repository related with the entity "ExcerciseTrading"
    private IExcerciseTradingRepository repository;
    @Autowired//Annotation that injects the dependencies from the converter related with the entity "ExcerciseTrading"
    private ExcerciseTradingDeserializable converter;

    /**
     * Method that creates an excercise
     * @param excerciseTradingDTO The excercise to be created
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> createExcerciseTrading(ExcerciseTradingDTO excerciseTradingDTO) {
        try {
            Optional<ExcerciseTradingEntity> excerciseTradingExist = this.repository.findById(excerciseTradingDTO.getId());
            if (!excerciseTradingExist.isPresent()) {
                ExcerciseTradingEntity entity = this.converter.convertExcerciseTradingDTOToExcerciseTradingEntity(excerciseTradingDTO);
                this.repository.save(entity);
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .objectResponse(IExcerciseTradingResponse.EXERCISE_REGISTRATION_SUCCESS)
                        .build());
            } else {
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL)
                        .objectResponse(IExcerciseTradingResponse.EXERCISE_REGISTRATION_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        } catch (Exception e) {
            log.error(Responses.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body(ObjectResponse.builder()
                            .message(Responses.INTERNAL_SERVER_ERROR)
                            .objectResponse(null)
                            .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }

    /**
     * Method that reads a excercise
     * @param excerciseTradingDTO The excercise to be readed
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> readExcerciseTrading(ExcerciseTradingDTO excerciseTradingDTO) {
        try {
            Optional<ExcerciseTradingEntity> excerciseTradingExist = this.repository.findById(excerciseTradingDTO.getId());
            if (!excerciseTradingExist.isPresent()) {
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_SUCCESS)
                        .objectResponse(excerciseTradingExist)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL)
                        .objectResponse(IExcerciseTradingResponse.EXERCISE_SEARCHED_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        } catch (Exception e) {
            log.error(Responses.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ObjectResponse.builder()
                    .message(Responses.INTERNAL_SERVER_ERROR)
                    .objectResponse(null)
                    .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build());
        }
    }

    /**
     * Method that reads all the excercise
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> readExcecisesTrading() {
        try {
            List<ExcerciseTradingEntity> exerciseTradingEntityList = this.repository.findAll();
            if (!exerciseTradingEntityList.isEmpty()) {
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_SUCCESS)
                        .objectResponse(exerciseTradingEntityList)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL)
                        .objectResponse(IExcerciseTradingResponse.EXERCISE_SEARCHED_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        } catch (Exception e) {
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
     * Method that updates a excercise
     * @param exerciseTradingDTO The excercise to be updated
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> updateExcerciseTrading(ExcerciseTradingDTO exerciseTradingDTO) {
        try {
            Optional<ExcerciseTradingEntity> exerciseTradingExist = this.repository.findById(exerciseTradingDTO.getId());
            if (!exerciseTradingExist.isPresent()) {
                ExcerciseTradingEntity entity = this.converter.convertExcerciseTradingDTOToExcerciseTradingEntity(exerciseTradingDTO);
                this.repository.save(entity);
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_SUCCESS)
                        .objectResponse(IExcerciseTradingResponse.EXERCISE_UPDATE_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL)
                        .objectResponse(IExcerciseTradingResponse.EXERCISE_UPDATE_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        } catch (Exception e) {
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
     * Method that deletes an exercise
     * @param exerciseId The exercise to be deleted
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> deleteExcerciseTrading(Integer exerciseId) {
        try {
            Optional<ExcerciseTradingEntity> exerciseTradingExist = this.repository.findById(exerciseId);
            if (exerciseTradingExist.isPresent()) {
                this.repository.deleteById(exerciseId);
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_SUCCESS)
                        .objectResponse(IExcerciseTradingResponse.EXERCISE_DELETE_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL)
                        .objectResponse(IExcerciseTradingResponse.EXERCISE_DELETED_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        } catch (Exception e) {
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
