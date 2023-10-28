package com.trading.TradingUpFundationBackend.service.Implements;

import com.trading.TradingUpFundationBackend.commons.constant.response.Responses;//Package that allows the use of a Responses
import com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse.IUserTradingResponse;//Package that allows use the object UserTradingDeserializable
import com.trading.TradingUpFundationBackend.commons.domains.DTO.UserTradingDTO;//Package that allows to use the serializable version of the entity UserTradingEntity; RegistrationTradingDTO
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;//Package that allows to use a response with type ObjectResponse
import com.trading.TradingUpFundationBackend.commons.domains.entity.UserTradingEntity;//Package that allows to use the Entity UserTradingEntity
import com.trading.TradingUpFundationBackend.repository.IUserTradingRepository;//Package that allows to use the repository ILevelTradingRepository
import com.trading.TradingUpFundationBackend.service.ILoginTradingService;//Package that allows the use of the interface "ILoginTradingService"
import lombok.extern.log4j.Log4j2;//Package that allows the use of logs to represent a specific message
import org.springframework.http.HttpStatus;//Package that allows the use of Http codes
import org.springframework.http.ResponseEntity;//Package that allows the creations and use of an Entity's response
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;//Package that allows to use the annotation @Component to represent this class like a spring component
import org.springframework.stereotype.Service;//Package that allows the use the annotation @Service to represent this class like a service in the spring context

import java.util.Optional;

@Component//Annotation which indicates this class like a spring component
@Log4j2//Annotation who represent this class like a component with type "Service" in the spring context
@Service//Annotation who allows the use of specifics responses

/**
 * Class that represents all the services of a log-in
 */
public class LoginTradingServiceImplements implements ILoginTradingService {

    private final IUserTradingRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;

    public LoginTradingServiceImplements(IUserTradingRepository repository, BCryptPasswordEncoder passwordEncoder){
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Method that log-in a user
     * @param userTradingDTO The user to log-in
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override
    public ResponseEntity<ObjectResponse> login(UserTradingDTO userTradingDTO) {
        try {
            String rawPassword = userTradingDTO.getPassword();
            Optional<UserTradingEntity> userTradingExist = this.repository.findByEmail(userTradingDTO.getEmail());
            if(userTradingExist.isPresent()){
                String encodePassword = userTradingExist.get().getPassword();
                if (passwordEncoder.matches(rawPassword, encodePassword)) {
                    if(userTradingExist.get().isStatus()) {
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
            }else{
                log.error(IUserTradingResponse.USER_LOGIN_PASSWORD_ERROR);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ObjectResponse.builder()
                    .message(Responses.INTERNAL_SERVER_ERROR)
                    .objectResponse(null)
                    .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
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
}
