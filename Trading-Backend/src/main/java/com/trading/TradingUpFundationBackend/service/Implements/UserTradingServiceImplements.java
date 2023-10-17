package com.trading.TradingUpFundationBackend.service.Implements;

import com.trading.TradingUpFundationBackend.commons.constant.response.Responses;//Package that allows the use of a Responses
import com.trading.TradingUpFundationBackend.commons.constant.deserializable.UserTradingDeserializable;
import com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse.IUserTradingResponse;//Package that allows use the object UserTradingDeserializable
import com.trading.TradingUpFundationBackend.commons.domains.DTO.UserTradingDTO;//Package that allows to use the serializable version of the entity UserTradingEntity; RegistrationTradingDTO
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;//Package that allows to use a response with type ObjectResponse
import com.trading.TradingUpFundationBackend.commons.domains.entity.UserTradingEntity;//Package that allows to use the Entity UserTradingEntity
import com.trading.TradingUpFundationBackend.repository.IUserTradingRepository;//Package that allows to use the repository ILevelTradingRepository
//import com.trading.TradingUpFundationBackend.security.SecretEncryption;
import com.trading.TradingUpFundationBackend.service.IUserTradingService;//Package that allows the use of the interface "IUserTradingService"
import lombok.extern.log4j.Log4j2;//Package that allows the use of logs to represent a specific message
import org.springframework.beans.factory.annotation.Autowired;//Package that allows the use of the annotation @Autowired to represent the injection of dependencies in the spring context
import org.springframework.beans.factory.annotation.Value;//Package that gives a value to a specific property
import org.springframework.http.HttpStatus;//Package that allows the use of Http codes
import org.springframework.http.ResponseEntity;//Package that allows the creations and use of an Entity's response
import org.springframework.stereotype.Component;//Package that allows to use the annotation @Component to represent this class like a spring component
import org.springframework.stereotype.Service;//Package that allows the use the annotation @Service to represent this class like a service in the spring context

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.List;//Package that allows the use of dynamic list
import java.util.Optional;//Package that allows the use of the datatype "Optional"

@Component//Annotation which indicates this class like a spring component
@Service//Annotation who represent this class like a component with type "Service" in the spring context
@Log4j2//Annotation who allows the use of specifics responses

/**
 * Class that represents all the services of the entity "UserTrading"
 */
public class UserTradingServiceImplements implements IUserTradingService {

    @Autowired//Annotation that injects the dependencies from de repository related with the entity "UserTrading"
    private IUserTradingRepository repository;
    @Autowired//Annotation that injects the dependencies from the converter related with the entity "UserTrading"
    private UserTradingDeserializable converter;
    @Value("user.secretKey")
    private String contrasenia;
    @Value("encryption.Method")
    private String encryptedMethod;



    /**
     * Method that creates a user
     * @param userTradingDTO The user to be created
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> createUserTrading(UserTradingDTO userTradingDTO) {
        try {
            Optional<UserTradingEntity> userTradingExist = this.repository.findByEmail(userTradingDTO.getEmail());
            if (!userTradingExist.isPresent()) {
                UserTradingEntity entity = this.converter.convertUserTradingDTOToUserTradingEntity(userTradingDTO);
                /*
                SecretKey key = new SecretKeySpec(contrasenia.getBytes(), encryptedMethod);
                System.out.println("prueba");
                entity.setPassword(SecretEncryption.encrypt(entity.getPassword(), key));
                */
                this.repository.save(entity);
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .objectResponse(IUserTradingResponse.USER_REGISTRATION_SUCCESS)
                        .build());
            } else {
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL)
                        .objectResponse(IUserTradingResponse.USER_REGISTRATION_FAILED)
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
     * Method that reads a user
     * @param userTradingDTO The user to be readed
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> readUserTrading(UserTradingDTO userTradingDTO) {
        try {
            Optional<UserTradingEntity> userTradingExist = this.repository.findByEmail(userTradingDTO.getEmail());
            if (userTradingExist.isPresent()) {
                    UserTradingEntity entity = userTradingExist.get();
                    /*
                    SecretKey key = new SecretKeySpec(contrasenia.getBytes(), encryptedMethod);
                    entity.setPassword(SecretEncryption.decrypt(entity.getPassword(), key));
                    */
                    return ResponseEntity.ok(ObjectResponse.builder()
                            .message(Responses.OPERATION_SUCCESS)
                            .objectResponse(entity)
                            .httpResponse(HttpStatus.OK.value())
                            .build());
                } else {
                    return ResponseEntity.badRequest().body(ObjectResponse.builder()
                            .message(Responses.OPERATION_FAIL)
                            .objectResponse(IUserTradingResponse.USER_SEARCHED_FAILED)
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
     * Method that reads all the users
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> readUsersTrading() {
        try {
            List<UserTradingEntity> userTradingEntityList = this.repository.findAll();
            if (!userTradingEntityList.isEmpty()) {
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_SUCCESS)
                        .objectResponse(userTradingEntityList)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL)
                        .objectResponse(IUserTradingResponse.USER_SEARCHED_FAILED)
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
     * Method that updates a user
     * @param userTradingDTO The user to be updated
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> updateUserTrading(UserTradingDTO userTradingDTO) {
        try {
            Optional<UserTradingEntity> userTradingExist = this.repository.findByEmail(userTradingDTO.getEmail());
            if (userTradingExist.isPresent()) {
                UserTradingEntity entity = this.converter.convertUserTradingDTOToUserTradingEntity(userTradingDTO);
                entity.setId(userTradingExist.get().getId());
                this.repository.save(entity);
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_SUCCESS)
                        .objectResponse(IUserTradingResponse.USER_UPDATED_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL)
                        .objectResponse(IUserTradingResponse.USER_UPDATED_FAILED)
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
     * Method that deletes a user
     * @param userTradingDTO The user to be deleted
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> deleteUserTrading(UserTradingDTO userTradingDTO) {
        try {
            Optional<UserTradingEntity> userTradingExist = this.repository.findByEmail(userTradingDTO.getEmail());
            if (userTradingExist.isPresent()) {
                this.repository.deleteById(userTradingExist.get().getId());
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_SUCCESS)
                        .objectResponse(IUserTradingResponse.USER_DELETED_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL)
                        .objectResponse(IUserTradingResponse.USER_DELETED_FAILED)
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