package com.trading.TradingUpFundationBackend.service.Implements;

import com.trading.TradingUpFundationBackend.commons.constant.deserializable.ExcerciseTradingDeserializable;
import com.trading.TradingUpFundationBackend.commons.constant.deserializable.ExerciseSolutionTradingDeserializable;
import com.trading.TradingUpFundationBackend.commons.constant.response.Responses;
import com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse.IExerciseSolutionTradingResponse;
import com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse.IExerciseTradingResponse;
import com.trading.TradingUpFundationBackend.commons.domains.DTO.ExerciseSolutionTradingDTO;
import com.trading.TradingUpFundationBackend.commons.domains.DTO.ExerciseTradingDTO;
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;
import com.trading.TradingUpFundationBackend.commons.domains.entity.ExerciseSolutionTradingEntity;
import com.trading.TradingUpFundationBackend.commons.domains.entity.ExerciseTradingEntity;
import com.trading.TradingUpFundationBackend.repository.IExerciseSolutionTradingRepository;
import com.trading.TradingUpFundationBackend.repository.IExerciseTradingRepository;
import com.trading.TradingUpFundationBackend.service.IExerciseSolutionTradingService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class ExerciseSolutionTradingServiceImplements implements IExerciseSolutionTradingService {

    private final IExerciseSolutionTradingRepository repository;
    private final ExerciseSolutionTradingDeserializable converter;
    public ExerciseSolutionTradingServiceImplements(IExerciseSolutionTradingRepository repository, ExerciseSolutionTradingDeserializable converter) {
        this.repository = repository;
        this.converter = converter;
    }

    /**
     * Method that creates an exercise solution
     * @param exerciseSolutionTradingDTO The exercise solution to be created
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> createExerciseSolutionTrading(ExerciseSolutionTradingDTO exerciseSolutionTradingDTO) {
        try {
            Optional<ExerciseSolutionTradingEntity> exerciseSolutionTradingExist = this.repository.findById(exerciseSolutionTradingDTO.getId());
            if (exerciseSolutionTradingExist.isEmpty()) {
                ExerciseSolutionTradingEntity entity = this.converter.convertExerciseSolutionTradingDTOToExerciseSolutionTradingEntity(exerciseSolutionTradingDTO);
                this.repository.save(entity);
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .objectResponse(IExerciseSolutionTradingResponse.EXERCISE_SOLUTION_REGISTRATION_SUCCESS)
                        .build());
            } else {
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL)
                        .objectResponse(IExerciseSolutionTradingResponse.EXERCISE_SOLUTION_REGISTRATION_FAILED)
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
     * Method that reads an exercise solution
     * @param exerciseSolutionTradingDTO The exercise solution to read
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> readExerciseSolutionTrading(ExerciseSolutionTradingDTO exerciseSolutionTradingDTO) {
        try {
            Optional<ExerciseSolutionTradingEntity> exerciseSolutionTradingExist = this.repository.findById(exerciseSolutionTradingDTO.getId());
            if (exerciseSolutionTradingExist.isPresent()) {
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_SUCCESS)
                        .objectResponse(exerciseSolutionTradingExist)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL)
                        .objectResponse(IExerciseSolutionTradingResponse.EXERCISE_SOLUTION_SEARCH_FAILED)
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
     * Method that reads all the exercise solutions
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> readExercisesSolutionsTrading() {
        try {
            List<ExerciseSolutionTradingEntity> exerciseSolutionsTradingEntityList = this.repository.findAll();
            if (!exerciseSolutionsTradingEntityList.isEmpty()) {
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_SUCCESS)
                        .objectResponse(exerciseSolutionsTradingEntityList)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL)
                        .objectResponse(IExerciseSolutionTradingResponse.EXERCISE_SOLUTION_SEARCH_FAILED)
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
