package com.trading.TradingUpFundationBackend.service.Implements;

import com.trading.TradingUpFundationBackend.commons.constant.response.Responses;//Package that allows the use of a Responses
import com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse.IClassTradingResponse;//Package that allows the use of the response of the entity ClassTrading
import com.trading.TradingUpFundationBackend.commons.constant.deserializable.ClassTradingDeserializable;//Package that allows use the object ClassTradingDeserializable
import com.trading.TradingUpFundationBackend.commons.domains.DTO.ClassTradingDTO;//Package that allows to use the serializable version of the entity ClassTradingEntity; ClassTradingDTO
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;//Package that allows to use a response with type ObjectResponse
import com.trading.TradingUpFundationBackend.commons.domains.entity.ClassTradingEntity;//Package that allows to use the Entity ClassTradingEntity
import com.trading.TradingUpFundationBackend.repository.IClassTradingRepository;//Package that allows to use the repository IClassTradingRepository
import com.trading.TradingUpFundationBackend.service.IClassTradingService;//Package that allows the use of the interface "IClassTradingService"
import lombok.extern.log4j.Log4j2;//Package that allows the use of logs to represent a specific message
import org.springframework.beans.factory.annotation.Autowired;//Package that allows the use of the annotation @Autowired to represent the injection of dependencies in the spring context
import org.springframework.http.HttpStatus;//Package that allows the use of Http codes
import org.springframework.http.ResponseEntity;//Package that allows the creations and use of an Entity's response
import org.springframework.stereotype.Service;//Package that allows the use the annotation @Service to represent this class like a service in the spring context

import java.util.ArrayList;
import java.util.List;//Package that allows the use of dynamic list
import java.util.Optional;//Package that allows the use of the datatype "Optional"

@Service//Annotation who represent this class like a component with type "Service" in the spring context
@Log4j2//Annotation who allows the use of specifics responses
/**
 * Class that represents all the services of the entity "ClassTrading"
 */
public class ClassTradingServiceImplements implements IClassTradingService {

    @Autowired//Annotation that injects the dependencies from de repository related with the entity "ClassTrading"
    private IClassTradingRepository repository;
    @Autowired//Annotation that injects the dependencies from the converter related with the entity "ClassTrading"
    private ClassTradingDeserializable converter;

    /**
     * Method that creates a class
     * @param classTradingDTO The class to be created
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> createClassTrading(ClassTradingDTO classTradingDTO) {
        System.out.println(classTradingDTO);
        try{
            System.out.println("prueba dentro try catch");
            Optional<ClassTradingEntity> classTradingExist = this.repository.findById(classTradingDTO.getId());
            if(!classTradingExist.isPresent()){
                ClassTradingEntity entity = this.converter.convertClassTradingDTOToClassTradingEntity(classTradingDTO);
                this.repository.save(entity);
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_SUCCESS)
                        .objectResponse(IClassTradingResponse.CLASS_REGISTRATION_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            }else{
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL)
                        .objectResponse(IClassTradingResponse.CLASS_REGISTRATION_FAILED)
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
     * Method that creates a class
     * @param classTradingDTO The class to be read
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> readClassTrading(ClassTradingDTO classTradingDTO) {
        try {
            Optional<ClassTradingEntity> classTradingExist = this.repository.findById(classTradingDTO.getId());
            if(classTradingExist.isPresent()){
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_SUCCESS)
                        .objectResponse(classTradingExist)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            }else {
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL)
                        .objectResponse(IClassTradingResponse.CLASS_SEARCHED_FAILED)
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
     * Method that reads all the classes
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> readClassesTrading(Integer level) {
        try {
            List<ClassTradingEntity> classTradingList = this.repository.findAll();
            if(!classTradingList.isEmpty()){
                List<ClassTradingEntity> listForLevel = new ArrayList<>();
                for (ClassTradingEntity classTrading: classTradingList){
                    if (classTrading.getLevel() == level){
                        listForLevel.add(classTrading);
                    }
                }
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_SUCCESS)
                        .objectResponse(listForLevel)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            }else{
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL)
                        .objectResponse(IClassTradingResponse.CLASS_SEARCHED_FAILED)
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
     * Method that updates a class
     * @param classTradingDTO The class to be updated
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> updateClassTrading(ClassTradingDTO classTradingDTO) {
        try {
            Optional<ClassTradingEntity> classTradingExist = this.repository.findById(classTradingDTO.getId());
            if(classTradingExist.isPresent()){
                ClassTradingEntity entity = this.converter.convertClassTradingDTOToClassTradingEntity(classTradingDTO);
                this.repository.save(entity);
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_SUCCESS)
                        .objectResponse(IClassTradingResponse.CLASS_UPDATED_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            }else {
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL)
                        .objectResponse(IClassTradingResponse.CLASS_UPDATED_FAILED)
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
     * Method that deletes an admin
     * @param id The id of the class to be deleted
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */

    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> deleteClassTrading(Integer id) {
        try {
            Optional<ClassTradingEntity> classTradingExist = this.repository.findById(id);
            if(classTradingExist.isPresent()){
                this.repository.deleteById(classTradingExist.get().getId());
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_SUCCESS)
                        .objectResponse(IClassTradingResponse.CLASS_DELETED_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            }else{
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL)
                        .objectResponse(IClassTradingResponse.CLASS_DELETED_FAILED)
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
