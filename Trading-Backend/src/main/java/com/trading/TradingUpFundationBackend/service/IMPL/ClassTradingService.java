package com.trading.TradingUpFundationBackend.service.IMPL;

import com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse.IClassTradingResponse;//Package that allows the use of the response of the entity ClassTrading
import com.trading.TradingUpFundationBackend.commons.constant.response.GeneralResponse;//Package that allows the use of a GeneralResponse
import com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse.Converter.ClassTradingConverter;//Package that allows use the object ClassTradingConverter
import com.trading.TradingUpFundationBackend.commons.domains.DTO.ClassTradingDTO;//Package that allows to use the serializable version of the entity ClassTradingEntity; ClassTradingDTO
import com.trading.TradingUpFundationBackend.commons.domains.entity.ClassTradingEntity;//Package that allows to use the Entity ClassTradingEntity
import com.trading.TradingUpFundationBackend.commons.domains.GenericResponseDTO;//Package that allows a Generic Response with a type DTO
import com.trading.TradingUpFundationBackend.repository.IClassTradingRepository;//Package that allows to use the repository IClassTradingRepository
import com.trading.TradingUpFundationBackend.service.IClassTradingService;//Package that allows the use of the interface "IClassTradingService"
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
 * Class that represents all the services of the entity "ClassTrading"
 */
public class ClassTradingService implements IClassTradingService {

    @Autowired//Annotation that injects the dependencies from de repository related with the entity "ClassTrading"
    private IClassTradingRepository repository;
    @Autowired//Annotation that injects the dependencies from the converter related with the entity "ClassTrading"
    private ClassTradingConverter converter;

    /**
     * Method that creates a class
     * @param classTradingDTO The class to be created
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<GenericResponseDTO> createClassTrading(ClassTradingDTO classTradingDTO) {
        try{
            Optional<ClassTradingEntity> classTradingExist = this.repository.findById(classTradingDTO.getId());
            if(!classTradingExist.isPresent()){
                ClassTradingEntity entity = this.converter.convertClassTradingDTOToClassTradingEntity(classTradingDTO);
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .objectResponse(IClassTradingResponse.CLASS_REGISTRATION_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            }else{
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(IClassTradingResponse.CLASS_REGISTRATION_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        }catch (Exception e) {
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponseDTO.builder()
                            .message(GeneralResponse.INTERNAL_SERVER_ERROR)
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
    public ResponseEntity<GenericResponseDTO> readClassTrading(ClassTradingDTO classTradingDTO) {
        try {
            Optional<ClassTradingEntity> classTradingExist = this.repository.findById(classTradingDTO.getId());
            if(!classTradingExist.isPresent()){
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .objectResponse(classTradingExist)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            }else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(IClassTradingResponse.CLASS_SEARCHED_FAILED)
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
     * Method that reads all the classes
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<GenericResponseDTO> readClassesTrading() {
        try {
            List<ClassTradingEntity> classTradingList = this.repository.findAll();
            if(!classTradingList.isEmpty()){
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .objectResponse(classTradingList)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            }else{
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(IClassTradingResponse.CLASS_SEARCHED_FAILED)
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
     * Method that updates a class
     * @param classTradingDTO The class to be updated
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<GenericResponseDTO> updateClassTrading(ClassTradingDTO classTradingDTO) {
        try {
            Optional<ClassTradingEntity> classTradingExist = this.repository.findById(classTradingDTO.getId());
            if(classTradingExist.isPresent()){
                ClassTradingEntity entity = this.converter.convertClassTradingDTOToClassTradingEntity(classTradingDTO);
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .objectResponse(IClassTradingResponse.CLASS_UPDATED_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            }else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(IClassTradingResponse.CLASS_UPDATED_FAILED)
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
     * Method that deletes an admin
     * @param classId The id of the class to be deleted
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */

    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<GenericResponseDTO> deleteClassTrading(Integer classId) {
        try {
            Optional<ClassTradingEntity> classTradingExist = this.repository.findById(classId);
            if(classTradingExist.isPresent()){
                this.repository.deleteById(classId);
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .objectResponse(IClassTradingResponse.CLASS_DELETED_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            }else{
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(IClassTradingResponse.CLASS_DELETED_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        } catch (Exception e){
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
