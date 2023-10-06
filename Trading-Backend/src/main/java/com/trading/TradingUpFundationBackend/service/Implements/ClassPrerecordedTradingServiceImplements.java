package com.trading.TradingUpFundationBackend.service.Implements;

import com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse.IUserTradingResponse;
import com.trading.TradingUpFundationBackend.commons.domains.entity.UserTradingEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.trading.TradingUpFundationBackend.commons.constant.deserializable.ClassPrerecordedTradingDeserializable;
import com.trading.TradingUpFundationBackend.commons.constant.response.Responses;
import com.trading.TradingUpFundationBackend.commons.constant.response.entittyResponse.IClassPrerecordedeTradingResponse;
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;
import com.trading.TradingUpFundationBackend.commons.domains.DTO.ClassPrerecordedTradingDTO;
import com.trading.TradingUpFundationBackend.commons.domains.entity.ClassPrerecordedTradingEntity;
import com.trading.TradingUpFundationBackend.repository.IClassPrerecordedTradingRepository;
import com.trading.TradingUpFundationBackend.service.IClassPrerecordedTradingService;

import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class ClassPrerecordedTradingServiceImplements implements IClassPrerecordedTradingService{

    private IClassPrerecordedTradingRepository repository;
    private ClassPrerecordedTradingDeserializable converter;

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
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

