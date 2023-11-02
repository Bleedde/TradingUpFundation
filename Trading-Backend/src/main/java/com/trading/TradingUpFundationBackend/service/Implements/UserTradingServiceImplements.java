package com.trading.TradingUpFundationBackend.service.Implements;

import com.trading.TradingUpFundationBackend.commons.constant.response.Responses;//Package that allows the use of a Responses
import com.trading.TradingUpFundationBackend.commons.constant.deserializable.UserTradingDeserializable;
import com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse.IUserTradingResponse;//Package that allows use the object UserTradingDeserializable
import com.trading.TradingUpFundationBackend.commons.domains.DTO.UserTradingDTO;//Package that allows to use the serializable version of the entity UserTradingEntity; RegistrationTradingDTO
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;//Package that allows to use a response with type ObjectResponse
import com.trading.TradingUpFundationBackend.commons.domains.entity.UserTradingEntity;//Package that allows to use the Entity UserTradingEntity
import com.trading.TradingUpFundationBackend.repository.IUserTradingRepository;//Package that allows to use the repository ILevelTradingRepository
import com.trading.TradingUpFundationBackend.security.Encryption;
import com.trading.TradingUpFundationBackend.service.IUserTradingService;//Package that allows the use of the interface "IUserTradingService"
import lombok.extern.log4j.Log4j2;//Package that allows the use of logs to represent a specific message
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;//Package that allows the use of Http codes
import org.springframework.http.ResponseEntity;//Package that allows the creations and use of an Entity's response
import org.springframework.stereotype.Component;//Package that allows to use the annotation @Component to represent this class like a spring component
import org.springframework.stereotype.Service;//Package that allows the use the annotation @Service to represent this class like a service in the spring context

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.List;//Package that allows the use of dynamic list
import java.util.Optional;//Package that allows the use of the datatype "Optional"

@Component//Annotation which indicates this class like a spring component
@Service//Annotation who represent this class like a component with type "Service" in the spring context
@Log4j2//Annotation who allows the use of specifics responses

/**
 * Class that represents all the services of the entity "UserTrading"
 */
public class UserTradingServiceImplements implements IUserTradingService {

    private final IUserTradingRepository repository;
    private final UserTradingDeserializable converter;

    private final Encryption encryption;

    @Autowired
    public UserTradingServiceImplements(IUserTradingRepository repository, UserTradingDeserializable converter, Encryption encryption) {
        this.converter = converter;
        this.repository = repository;
        this.encryption = encryption;
    }

    public static SecretKey generateAESKey() {
        KeyGenerator keyGen = null;
        try {
            keyGen = KeyGenerator.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        keyGen.init(128);
        return keyGen.generateKey();
    }

    SecretKey secretKey = generateAESKey();

    @Override
    public ResponseEntity<ObjectResponse> login(UserTradingDTO userTradingDTO) {
        try {
            Optional<UserTradingEntity> userTradingExist = this.repository.findByEmail(userTradingDTO.getEmail());
            if(userTradingExist.isPresent()){
                String encodedPassword = userTradingExist.get().getPassword();
                String rawPassword = encryption.decryptAES(encodedPassword, secretKey);
                if(userTradingExist.get().isStatus() && rawPassword.equals(userTradingDTO.getPassword())) {
                    return ResponseEntity.ok(ObjectResponse.builder()
                            .message(Responses.OPERATION_SUCCESS + " I am " + userTradingExist.get().getUserRole())
                            .objectResponse(userTradingExist)
                            .httpResponse(HttpStatus.OK.value())
                            .build());
                } else {
                    return ResponseEntity.badRequest().body(ObjectResponse.builder()
                            .message(Responses.OPERATION_FAIL)
                            .httpResponse(HttpStatus.BAD_REQUEST.value())
                            .objectResponse(IUserTradingResponse.USER_LOGIN_STATUS_FALSE)
                            .build());
                }
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
     * Method that creates a user
     * @param userTradingDTO The user to be created
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> createUserTrading(UserTradingDTO userTradingDTO) {
        try {
            Optional<UserTradingEntity> userTradingExist = this.repository.findByEmail(userTradingDTO.getEmail());
            if (!userTradingExist.isPresent()) {
                String passwordEncrypted = encryption.encryptAES(userTradingDTO.getPassword(), secretKey);
                UserTradingEntity entity = this.converter.convertUserTradingDTOToUserTradingEntity(userTradingDTO);
                entity.setPassword(passwordEncrypted);
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
    public ResponseEntity<ObjectResponse> readUserTrading(Integer id) {
        try {
            Optional<UserTradingEntity> userTradingExist = this.repository.findById(id);
            if (userTradingExist.isPresent()) {
                    UserTradingEntity entity = userTradingExist.get();
                    entity.setPassword(encryption.decryptAES(userTradingExist.get().getPassword(), secretKey));
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
                String passwordEncoded = userTradingExist.get().getPassword();
                String passwordRaw = encryption.decryptAES(passwordEncoded, secretKey);
                if(!userTradingDTO.getPassword().equals(passwordRaw)){
                    entity.setPassword(encryption.encryptAES(userTradingDTO.getPassword(), secretKey));
                }
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