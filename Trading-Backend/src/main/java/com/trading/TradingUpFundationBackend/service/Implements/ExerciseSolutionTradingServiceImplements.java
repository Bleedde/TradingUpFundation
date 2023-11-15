package com.trading.TradingUpFundationBackend.service.Implements;

import com.trading.TradingUpFundationBackend.commons.constant.deserializable.ExerciseSolutionTradingDeserializable;
import com.trading.TradingUpFundationBackend.commons.constant.response.Responses;
import com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse.IClassTradingResponse;
import com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse.IExerciseSolutionTradingResponse;
import com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse.IExerciseTradingResponse;
import com.trading.TradingUpFundationBackend.commons.domains.DTO.ExerciseSolutionTradingDTO;
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;
import com.trading.TradingUpFundationBackend.commons.domains.entity.ExerciseSolutionTradingEntity;
import com.trading.TradingUpFundationBackend.commons.domains.entity.ExerciseTradingEntity;
import com.trading.TradingUpFundationBackend.commons.domains.entity.UserTradingEntity;
import com.trading.TradingUpFundationBackend.repository.IExerciseSolutionTradingRepository;
import com.trading.TradingUpFundationBackend.repository.IExerciseTradingRepository;
import com.trading.TradingUpFundationBackend.repository.IUserTradingRepository;
import com.trading.TradingUpFundationBackend.service.IExerciseSolutionTradingService;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Log4j2
public class ExerciseSolutionTradingServiceImplements implements IExerciseSolutionTradingService {

    private final IExerciseSolutionTradingRepository repository;
    private final ExerciseSolutionTradingDeserializable converter;
    private final IExerciseTradingRepository exerciseRepository;
    private final IUserTradingRepository userRepository;
    private final Environment env;
    public ExerciseSolutionTradingServiceImplements(IExerciseSolutionTradingRepository repository, ExerciseSolutionTradingDeserializable converter,
                                                    IExerciseTradingRepository exerciseRepository, IUserTradingRepository userRepository, Environment env) {
        this.repository = repository;
        this.converter = converter;
        this.exerciseRepository = exerciseRepository;
        this.userRepository = userRepository;
        this.env = env;
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
            Optional<UserTradingEntity> userDatabase = this.userRepository.findByEmail(exerciseSolutionTradingDTO.getUserEmail());
            Optional<ExerciseTradingEntity> exerciseDatabase = this.exerciseRepository.findById(exerciseSolutionTradingDTO.getExerciseId());
            if (exerciseSolutionTradingExist.isEmpty()){
                if(userDatabase.isPresent()){
                    if(exerciseDatabase.isPresent()){
                        ExerciseSolutionTradingEntity entity = this.converter.convertExerciseSolutionTradingDTOToExerciseSolutionTradingEntity(exerciseSolutionTradingDTO);
                        String fileName = StringUtils.cleanPath(Objects.requireNonNull(exerciseSolutionTradingDTO.getFile().getOriginalFilename()));
                        String uploadDirection = env.getProperty("exerciseSolution.upload.path") + File.separator + entity.getId();
                        Files.createDirectories(Paths.get(uploadDirection));
                        Path uploadPath = Paths.get(uploadDirection, fileName);
                        Files.copy(exerciseSolutionTradingDTO.getFile().getInputStream(), uploadPath, StandardCopyOption.REPLACE_EXISTING);
                        entity.setUserName(userDatabase.get().getName());
                        this.repository.save(entity);
                        return ResponseEntity.ok(ObjectResponse.builder()
                                .message(Responses.OPERATION_SUCCESS)
                                .objectResponse(IExerciseSolutionTradingResponse.EXERCISE_SOLUTION_REGISTRATION_SUCCESS)
                                .httpResponse(HttpStatus.OK.value())
                                .build());
                    } else {
                        return ResponseEntity.badRequest().body(ObjectResponse.builder()
                                .message(Responses.OPERATION_FAIL + ", the exercise doesnt exist")
                                .objectResponse(IExerciseSolutionTradingResponse.EXERCISE_SOLUTION_REGISTRATION_FAILED)
                                .httpResponse(HttpStatus.BAD_REQUEST.value())
                                .build());
                    }
                } else {
                    return ResponseEntity.badRequest().body(ObjectResponse.builder()
                            .message(Responses.OPERATION_FAIL + ", the user doesnt exist")
                            .objectResponse(IExerciseSolutionTradingResponse.EXERCISE_SOLUTION_REGISTRATION_FAILED)
                            .httpResponse(HttpStatus.BAD_REQUEST.value())
                            .build());
                }
            } else {
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL + ", the id of the register already exist")
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
     * @param id The id of the exercise solution to read
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> readExerciseSolutionTrading(Integer id) {
        try {
            Optional<ExerciseSolutionTradingEntity> exerciseSolutionTradingExist = this.repository.findById(id);
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

    @Override
    public ResponseEntity<ObjectResponse> updateExerciseSolutionTrading(ExerciseSolutionTradingDTO exerciseSolutionTradingDTO){
        try {
            Optional<ExerciseSolutionTradingEntity> exerciseSolutionTradingEntityExist = this.repository.findById(exerciseSolutionTradingDTO.getId());
            Optional<UserTradingEntity> userDatabase = this.userRepository.findByEmail(exerciseSolutionTradingDTO.getUserEmail());
            Optional<ExerciseTradingEntity> exerciseDatabase = this.exerciseRepository.findById(exerciseSolutionTradingDTO.getExerciseId());
            if(exerciseSolutionTradingEntityExist.isPresent()){
                if (userDatabase.isPresent()){
                    if (exerciseDatabase.isPresent()){
                        ExerciseSolutionTradingEntity entity = this.converter.convertExerciseSolutionTradingDTOToExerciseSolutionTradingEntity(exerciseSolutionTradingDTO);
                        String existingFilePath = exerciseSolutionTradingEntityExist.get().getFile();
                        MultipartFile newFile = exerciseSolutionTradingDTO.getFile();
                        if(existingFilePath != null && !existingFilePath.isEmpty()){
                            Files.delete(Paths.get(existingFilePath));
                        }
                        if (newFile != null && !newFile.isEmpty()) {
                            String fileName = StringUtils.cleanPath(Objects.requireNonNull(newFile.getOriginalFilename()));
                            String uploadDirection = env.getProperty("exerciseSolution.upload.path") + File.separator + exerciseSolutionTradingDTO.getId();
                            Files.createDirectories(Paths.get(uploadDirection));
                            Path uploadPath = Paths.get(uploadDirection, fileName);
                            Files.copy(newFile.getInputStream(), uploadPath, StandardCopyOption.REPLACE_EXISTING);
                            entity.setFile(uploadPath.toString());
                        }
                        this.repository.save(entity);
                        return ResponseEntity.ok(ObjectResponse.builder()
                                .message(Responses.OPERATION_SUCCESS)
                                .objectResponse(IExerciseSolutionTradingResponse.EXERCISE_SOLUTION_REGISTRATION_SUCCESS)
                                .httpResponse(HttpStatus.OK.value())
                                .build());
                    } else {
                        return ResponseEntity.badRequest().body(ObjectResponse.builder()
                                .message(Responses.OPERATION_FAIL + ", the exercise doesnt exist")
                                .objectResponse(IExerciseSolutionTradingResponse.EXERCISE_SOLUTION_REGISTRATION_FAILED)
                                .httpResponse(HttpStatus.BAD_REQUEST.value())
                                .build());
                    }
                } else {
                    return ResponseEntity.badRequest().body(ObjectResponse.builder()
                            .message(Responses.OPERATION_FAIL + ", the user doesnt exist")
                            .objectResponse(IExerciseSolutionTradingResponse.EXERCISE_SOLUTION_REGISTRATION_FAILED)
                            .httpResponse(HttpStatus.BAD_REQUEST.value())
                            .build());
                }
            } else {
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL + ", the exercise solution doesnt exist")
                        .objectResponse(IExerciseSolutionTradingResponse.EXERCISE_SOLUTION_REGISTRATION_FAILED)
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