package com.trading.TradingUpFundationBackend.service.IMPL;

import com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse.IExcerciseTradingResponse;//Package that allows the use of the response of the entity ExcerciseTrading
import com.trading.TradingUpFundationBackend.commons.constant.response.GeneralResponse;//Package that allows the use of a GeneralResponse
import com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse.Converter.ExcerciseTradingConverter;//Package that allows use the object ExcerciseTradingConverter
import com.trading.TradingUpFundationBackend.commons.domains.DTO.ExcerciseTradingDTO;//Package that allows to use the serializable version of the entity ExcerciseTradingEntity; ExcerciseTradingDTO
import com.trading.TradingUpFundationBackend.commons.domains.entity.ExcerciseTradingEntity;
import com.trading.TradingUpFundationBackend.commons.domains.GenericResponseDTO;
import com.trading.TradingUpFundationBackend.repository.IExcerciseTradingRepository;
import com.trading.TradingUpFundationBackend.service.IExcerciseTradingService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class ExcerciseTradingService implements IExcerciseTradingService {
    @Autowired
    private IExcerciseTradingRepository repository;
    @Autowired
    private ExcerciseTradingConverter converter;

    @Override
    public ResponseEntity<GenericResponseDTO> createExcerciseTrading(ExcerciseTradingDTO excerciseTradingDTO) {
        try {
            Optional<ExcerciseTradingEntity> excerciseTradingExist = this.repository.findById(excerciseTradingDTO.getId());
            if (!excerciseTradingExist.isPresent()) {
                ExcerciseTradingEntity entity = this.converter.convertExcerciseTradingDTOToExcerciseTradingEntity(excerciseTradingDTO);
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .objectResponse(IExcerciseTradingResponse.EXERCISE_REGISTRATION_SUCCESS)
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(IExcerciseTradingResponse.EXERCISE_REGISTRATION_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        } catch (Exception e) {
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body(GenericResponseDTO.builder()
                            .message(GeneralResponse.INTERNAL_SERVER_ERROR)
                            .objectResponse(null)
                            .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }

    @Override
    public ResponseEntity<GenericResponseDTO> readExcerciseTrading(ExcerciseTradingDTO excerciseTradingDTO) {
        try {
            Optional<ExcerciseTradingEntity> excerciseTradingExist = this.repository.findById(excerciseTradingDTO.getId());
            if (!excerciseTradingExist.isPresent()) {
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .objectResponse(excerciseTradingExist)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(IExcerciseTradingResponse.EXERCISE_SEARCHED_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        } catch (Exception e) {
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(GenericResponseDTO.builder()
                    .message(GeneralResponse.INTERNAL_SERVER_ERROR)
                    .objectResponse(null)
                    .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build());
        }
    }
    @Override
    public ResponseEntity<GenericResponseDTO> readExcecisesTrading() {
        try {
            List<ExcerciseTradingEntity> exerciseTradingEntityList = this.repository.findAll();
            if (!exerciseTradingEntityList.isEmpty()) {
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .objectResponse(exerciseTradingEntityList)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(IExcerciseTradingResponse.EXERCISE_SEARCHED_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        } catch (Exception e) {
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponseDTO.builder()
                            .message(GeneralResponse.INTERNAL_SERVER_ERROR)
                            .objectResponse(null)
                            .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }

    @Override
    public ResponseEntity<GenericResponseDTO> updateExcerciseTrading(ExcerciseTradingDTO exerciseTradingDTO) {
        try {
            Optional<ExcerciseTradingEntity> exerciseTradingExist = this.repository.findById(exerciseTradingDTO.getId());
            if (!exerciseTradingExist.isPresent()) {
                ExcerciseTradingEntity entity = this.converter.convertExcerciseTradingDTOToExcerciseTradingEntity(exerciseTradingDTO);
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .objectResponse(IExcerciseTradingResponse.EXERCISE_UPDATE_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(IExcerciseTradingResponse.EXERCISE_UPDATE_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        } catch (Exception e) {
            log.error(GeneralResponse.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponseDTO.builder()
                            .message(GeneralResponse.INTERNAL_SERVER_ERROR)
                            .objectResponse(null)
                            .httpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }

    @Override
    public ResponseEntity<GenericResponseDTO> deleteExcerciseTrading(Integer exerciseId) {
        try {
            Optional<ExcerciseTradingEntity> exerciseTradingExist = this.repository.findById(exerciseId);
            if (exerciseTradingExist.isPresent()) {
                this.repository.deleteById(exerciseId);
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .objectResponse(IExcerciseTradingResponse.EXERCISE_DELETE_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(IExcerciseTradingResponse.EXERCISE_DELETED_FAILED)
                        .httpResponse(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        } catch (Exception e) {
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
