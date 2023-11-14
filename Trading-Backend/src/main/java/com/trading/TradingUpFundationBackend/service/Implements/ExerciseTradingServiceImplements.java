package com.trading.TradingUpFundationBackend.service.Implements;

import com.trading.TradingUpFundationBackend.commons.constant.response.Responses;
import com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse.IExerciseTradingResponse;//Package that allows the use of the response of the entity ExcerciseTrading
import com.trading.TradingUpFundationBackend.commons.constant.deserializable.ExcerciseTradingDeserializable;//Package that allows use the object ExerciseTradingDeserializable
import com.trading.TradingUpFundationBackend.commons.domains.DTO.ExerciseTradingDTO;//Package that allows to use the serializable version of the entity ExerciseTradingEntity; ExerciseTradingDTO
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;
import com.trading.TradingUpFundationBackend.commons.domains.entity.ExerciseTradingEntity;
import com.trading.TradingUpFundationBackend.repository.IExerciseTradingRepository;//Package that allows to use the repository IExerciseTradingRepository
import com.trading.TradingUpFundationBackend.service.IExerciseTradingService;//Package that allows the use of the interface "IExerciseTradingService"
import lombok.extern.log4j.Log4j2;//Package that allows the use of logs to represent a specific message
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;//Package that allows the use of Http codes
import org.springframework.http.ResponseEntity;//Package that allows the creations and use of an Entity's response
import org.springframework.stereotype.Service;//Package that allows the use the annotation @Service to represent this class like a service in the spring context
import org.springframework.util.StringUtils;
import org.springframework.core.env.Environment;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

@Service//Annotation who represent this class like a component with type "Service" in the spring context
@Log4j2//Annotation who allows the use of specifics responses

/**
 * Class that represents all the services of the entity "ExerciseTrading"
 */
public class ExerciseTradingServiceImplements implements IExerciseTradingService {


    private final IExerciseTradingRepository repository;
    private final ExcerciseTradingDeserializable converter;
    private final Environment env;
    private final ResourceLoader resourceLoader;
    public ExerciseTradingServiceImplements(IExerciseTradingRepository repository, ExcerciseTradingDeserializable converter, Environment env, ResourceLoader resourceLoader) {
        this.repository = repository;
        this.converter = converter;
        this.env = env;
        this.resourceLoader = resourceLoader;
    }

    /**
     * Method that creates an exercise
     * @param exerciseTradingDTO The excercise to be created
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> createExerciseTrading(ExerciseTradingDTO exerciseTradingDTO) {
        try {
            Optional<ExerciseTradingEntity> exerciseTradingExist = this.repository.findById(exerciseTradingDTO.getId());
            if (!exerciseTradingExist.isPresent()) {
                ExerciseTradingEntity entity = this.converter.convertExerciseTradingDTOToExerciseTradingEntity(exerciseTradingDTO);
                String fileName = StringUtils.cleanPath(Objects.requireNonNull(exerciseTradingDTO.getFile().getOriginalFilename()));
                String uploadDirection = env.getProperty("exercise.upload.path") + File.separator + entity.getId();
                Files.createDirectories(Paths.get(uploadDirection));
                Path uploadPath = Paths.get(uploadDirection, fileName);
                Files.copy(exerciseTradingDTO.getFile().getInputStream(), uploadPath, StandardCopyOption.REPLACE_EXISTING);
                entity.setFile(uploadPath.toString());
                this.repository.save(entity);
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .objectResponse(IExerciseTradingResponse.EXERCISE_REGISTRATION_SUCCESS)
                        .build());
            } else {
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL)
                        .objectResponse(IExerciseTradingResponse.EXERCISE_REGISTRATION_FAILED)
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
     * Method that reads an exercise
     * @param id The id of the exercise to read
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> readExerciseTrading(Integer id) {
        try {
            Optional<ExerciseTradingEntity> exerciseTradingExist = this.repository.findById(id);
            if (exerciseTradingExist.isPresent()) {
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_SUCCESS)
                        .objectResponse(exerciseTradingExist)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL)
                        .objectResponse(IExerciseTradingResponse.EXERCISE_SEARCHED_FAILED)
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
     * Method that reads all the exercises
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> readExercisesTrading(Integer level) {
        try {
            List<ExerciseTradingEntity> exerciseTradingEntityList = this.repository.findAll();
            if (!exerciseTradingEntityList.isEmpty()) {
                List<ExerciseTradingEntity> listForLevel = new ArrayList<>();
                for(ExerciseTradingEntity exerciseTrading : exerciseTradingEntityList){
                    if(exerciseTrading.getLevel() == level){
                        listForLevel.add(exerciseTrading);
                    }
                }
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_SUCCESS)
                        .objectResponse(listForLevel)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL)
                        .objectResponse(IExerciseTradingResponse.EXERCISE_SEARCHED_FAILED)
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
     * Method that updates an exercise
     * @param exerciseTradingDTO The exercise to be updated
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> updateExerciseTrading(ExerciseTradingDTO exerciseTradingDTO) {
        try {
            Optional<ExerciseTradingEntity> exerciseTradingExist = this.repository.findById(exerciseTradingDTO.getId());
            if (exerciseTradingExist.isPresent()) {
                ExerciseTradingEntity entity = this.converter.convertExerciseTradingDTOToExerciseTradingEntity(exerciseTradingDTO);
                String existingFilePath = exerciseTradingExist.get().getFile();
                MultipartFile newFile = exerciseTradingDTO.getFile();
                if(existingFilePath != null && !existingFilePath.isEmpty()){
                    Files.delete(Paths.get(existingFilePath));
                }
                if (newFile != null && !newFile.isEmpty()) {
                    String fileName = StringUtils.cleanPath(Objects.requireNonNull(newFile.getOriginalFilename()));
                    String uploadDirection = env.getProperty("exercise.upload.path") + File.separator + exerciseTradingDTO.getId();
                    Files.createDirectories(Paths.get(uploadDirection));
                    Path uploadPath = Paths.get(uploadDirection, fileName);
                    Files.copy(newFile.getInputStream(), uploadPath, StandardCopyOption.REPLACE_EXISTING);
                    entity.setFile(uploadPath.toString());
                }
                this.repository.save(entity);
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_SUCCESS)
                        .objectResponse(IExerciseTradingResponse.EXERCISE_UPDATE_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL)
                        .objectResponse(IExerciseTradingResponse.EXERCISE_UPDATE_FAILED)
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
     * @param id The id of the exercise to be deleted
     * @return A ResponseEntity who creates a specific response (objectResponse, httpResponse and a message) of each possible situation
     */
    @Override//Annotation that represent an override for a method in another interface
    public ResponseEntity<ObjectResponse> deleteExerciseTrading(Integer id) {
        try {
            Optional<ExerciseTradingEntity> exerciseTradingExist = this.repository.findById(id);
            if (exerciseTradingExist.isPresent()) {
                String folderPath = env.getProperty("exercise.upload.path") + File.separator + id;
                if(folderPath != null && !folderPath.isEmpty()){
                    Files.walk(Paths.get(folderPath))
                            .sorted(Comparator.reverseOrder())
                            .map(Path::toFile)
                            .forEach(File::delete);
                }
                this.repository.deleteById(exerciseTradingExist.get().getId());
                return ResponseEntity.ok(ObjectResponse.builder()
                        .message(Responses.OPERATION_SUCCESS)
                        .objectResponse(IExerciseTradingResponse.EXERCISE_DELETE_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(ObjectResponse.builder()
                        .message(Responses.OPERATION_FAIL)
                        .objectResponse(IExerciseTradingResponse.EXERCISE_DELETED_FAILED)
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
    public ResponseEntity<byte[]> getFile(Integer id) {
        try {
            Optional<ExerciseTradingEntity> exerciseTradingEntityExist = this.repository.findById(id);
            if(exerciseTradingEntityExist.isPresent()){
                ExerciseTradingEntity entity = exerciseTradingEntityExist.get();
                String filePath = entity.getFile();
                var path = Paths.get(filePath);
                byte[] fileContent = Files.readAllBytes(path);
                String fileName = path.getFileName().toString();
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                headers.setContentDispositionFormData("attachment", fileName);
                return new ResponseEntity<>(fileContent, headers, HttpStatus.OK);
            } else {
                return ResponseEntity.badRequest().body(null);
            }
        } catch (Exception e) {
            log.error(Responses.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
