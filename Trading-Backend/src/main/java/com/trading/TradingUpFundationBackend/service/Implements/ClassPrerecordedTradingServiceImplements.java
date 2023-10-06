package com.trading.TradingUpFundationBackend.service.Implements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;//Package that allows the use of Http codes
import org.springframework.http.ResponseEntity;//Package that allows the creations and use of an Entity's response
import org.springframework.stereotype.Service;//Package that allows the use the annotation @Service to represent this class like a service in the spring context

import com.trading.TradingUpFundationBackend.commons.constant.deserializable.ClassPrerecordedTradingDeserializable;//Package that allows the use of the object ClassPrerecordedTradingDeserializable
import com.trading.TradingUpFundationBackend.commons.constant.response.Responses;//Package that gives responses to possible situations
import com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse.IClassPrerecordedeTradingResponse;//Package that allows the use of the response of the entity ClassPrerecordedTrading
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;//Package that creates a response like a object
import com.trading.TradingUpFundationBackend.commons.domains.DTO.ClassPrerecordedTradingDTO;//Package that allows the use of the response of the entity ClassPrerecordedTrading
import com.trading.TradingUpFundationBackend.commons.domains.entity.ClassPrerecordedTradingEntity;//Package that allows to use the Entity ClassPrereccordedTradingEntity
import com.trading.TradingUpFundationBackend.repository.IClassPrerecordedTradingRepository;//Package that allows to use the repository IClassPrerecordedTradingRepository
import com.trading.TradingUpFundationBackend.service.IClassPrerecordedTradingService;//Package that allows the use of the interface "IBookTradingService"

import lombok.extern.log4j.Log4j2;//Package that allows the use of logs to represent a specific message

import java.util.List;//Package that allows the use of dynamic list
import java.util.Optional;//Package that allows the use of the datatype "Optional"

@Service//Annotation who represents this class like a component with type "Service" in the spring context
@Log4j2//Annotation who allows the use of specifics responses
/**
 * Class that represents all the services of the entity "ClassPrerecordedTrading"
 */
public class ClassPrerecordedTradingServiceImplements implements IClassPrerecordedTradingService{

    @Autowired//Annotation that injects the dependencies from de repository related with the entity "ClassPrerecordedTrading"
    private IClassPrerecordedTradingRepository repository;

    @Autowired//Annotation that injects the dependencies from the converter related with the entity "ClassPrerecordedTrading"
    private ClassPrerecordedTradingDeserializable converter;

    @Override//Annotation that represent an override for a method in another interface
    /**
     * Method that creates a class prerecorded
     * @param classPrerecordedTradingDTO The class prerecorded to be created
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    public ResponseEntity<ObjectResponse> createClassPrerecordedTrading(ClassPrerecordedTradingDTO classPrerecordedTradingDTO) {
        try{
            Optional<ClassPrerecordedTradingEntity> classPrerecordedTradingExist = this.repository.findById(classPrerecordedTradingDTO.getId());
            if(!classPrerecordedTradingExist.isPresent()){
                ClassPrerecordedTradingEntity entity = this.converter.convertClassPrerecordedTradingDTOToClassPrerecordedTradingEntity(classPrerecordedTradingDTO);
                this.repository.save(entity);
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .objectResponse(IClassPrerecordedeTradingResponse.CLASS_PRERECORDED_REGISTRATION_SUCCESS)
                        .build());
            }  else{
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL)
                        .objectResponse(IClassPrerecordedeTradingResponse.CLASS_PRERECORDED_REGISTRATION_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        } catch (Exception e){
            log.error(Responses.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body(ObjectResponse.builder()
                            .message(Responses.INTERNAL_SERVER_ERROR)
                            .objectResponse(null)
                            .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }

    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> readClassPrerecordedTrading(ClassPrerecordedTradingDTO classPrerecordedTradingDTO) {
        try{
            Optional<ClassPrerecordedTradingEntity> classPrerecordedTradingExist = this.repository.findById(classPrerecordedTradingDTO.getId());
            if(classPrerecordedTradingExist.isPresent()){
                ClassPrerecordedTradingEntity entity = this.converter.convertClassPrerecordedTradingDTOToClassPrerecordedTradingEntity(classPrerecordedTradingDTO);
                return ResponseEntity.ok(ObjectResponse.builder()
                            .message(Responses.OPERATION_SUCCESS)
                            .objectResponse(entity)
                            .httpResponse(HttpStatus.OK.value())
                            .build());
            } else{
                return ResponseEntity.ok(ObjectResponse.builder()
                            .message(Responses.OPERATION_FAIL)
                            .objectResponse(IClassPrerecordedeTradingResponse.CLASS_PRERECORDED_SEARCHED_FAILED)
                            .httpResponse(HttpStatus.BAD_REQUEST.value())
                            .build());
            }
        } catch(Exception e){
            log.error(Responses.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.ok(ObjectResponse.builder()
                            .message(Responses.INTERNAL_SERVER_ERROR)
                            .objectResponse(null)
                            .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
        
    }

    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> readAllClassesPrerecordedTrading() {
        try{
            List<ClassPrerecordedTradingEntity> classPrerecordedTradingList = this.repository.findAll();
            if(!classPrerecordedTradingList.isEmpty()){
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_SUCCESS)
                        .objectResponse(classPrerecordedTradingList)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            } else{
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL)
                        .objectResponse(IClassPrerecordedeTradingResponse.CLASS_PRERECORDED_SEARCHED_FAILED)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            }
        } catch (Exception e){
            log.error(Responses.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.ok(ObjectResponse.builder()
                    .message(Responses.OPERATION_FAIL)
                    .objectResponse(Responses.INTERNAL_SERVER_ERROR)
                    .httpResponse(HttpStatus.OK.value())
                    .build());
        }
    }

    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> updateClassPrerecordedtrading(ClassPrerecordedTradingDTO classPrerecordedTradingDTO) {
        try {
            Optional<ClassPrerecordedTradingEntity> classPrerecordedTradingExist = this.repository.findById(classPrerecordedTradingDTO.getId());
            if (classPrerecordedTradingExist.isPresent()) {
                ClassPrerecordedTradingEntity entity = this.converter.convertClassPrerecordedTradingDTOToClassPrerecordedTradingEntity(classPrerecordedTradingDTO);
                entity.setId(classPrerecordedTradingExist.get().getId());
                this.repository.save(entity);
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_SUCCESS)
                        .objectResponse(IClassPrerecordedeTradingResponse.CLASS_PRERECORDED_UPDATE_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL)
                        .objectResponse(IClassPrerecordedeTradingResponse.CLASS_PRERECORDED_UPDATE_FAILED)
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

    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> deleteClassPrerecordedTrading(ClassPrerecordedTradingDTO classPrerecordedTradingDTO) {
            try {
                Optional<ClassPrerecordedTradingEntity> classPrerecordedTradingExist = this.repository.findById(classPrerecordedTradingDTO.getId());
                if (classPrerecordedTradingExist.isPresent()) {
                    this.repository.deleteById(classPrerecordedTradingExist.get().getId());
                    return ResponseEntity.ok(ObjectResponse.builder()
                            .message(Responses.OPERATION_SUCCESS)
                            .objectResponse(IClassPrerecordedeTradingResponse.CLASS_PRERECORDED_DELETE_SUCCESS)
                            .httpResponse(HttpStatus.OK.value())
                            .build());
                } else {
                    return ResponseEntity.badRequest().body(ObjectResponse.builder()
                            .message(Responses.OPERATION_FAIL)
                            .objectResponse(IClassPrerecordedeTradingResponse.CLASS_PRERECORDED_DELETE_FAILED)
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

