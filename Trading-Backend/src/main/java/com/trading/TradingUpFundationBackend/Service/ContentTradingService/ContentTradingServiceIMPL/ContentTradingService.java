package com.trading.TradingUpFundationBackend.Service.ContentTradingService.ContentTradingServiceIMPL;

import com.trading.TradingUpFundationBackend.Commons.Constant.Response.ClassTradingResponse.IClassTradingResponse;
import com.trading.TradingUpFundationBackend.Commons.Constant.Response.ContentTradingResponse.IContentTradingResponse;
import com.trading.TradingUpFundationBackend.Commons.Constant.Response.GeneralResponse;
import com.trading.TradingUpFundationBackend.Commons.Converter.ContentTradingConverter.ContentTradingConverter;
import com.trading.TradingUpFundationBackend.Commons.Domains.DTO.ContentTradingDTO.ContentTradingDTO;
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.ClassTradingEntity.ClassTradingEntity;
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.ContentTradingEntity.ContentTradingEntity;
import com.trading.TradingUpFundationBackend.Commons.Domains.ResponseDTO.GenericResponseDTO;
import com.trading.TradingUpFundationBackend.Repository.ContentTradingRepository.IContentTradingRepository;
import com.trading.TradingUpFundationBackend.Service.ContentTradingService.IContentTradingService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class ContentTradingService implements IContentTradingService {
    @Autowired
    private IContentTradingRepository repository;
    @Autowired
    private ContentTradingConverter converter;

    @Override
    public ResponseEntity<GenericResponseDTO> createContentTrading(ContentTradingDTO contentTradingDTO) {
        try {
            Optional<ContentTradingEntity> contentTradingExist = this.repository.findById(contentTradingDTO.getId());
            if (!contentTradingExist.isPresent()) {
                ContentTradingEntity entity = this.converter.converContentTradingDTOToContentTradingEntity(contentTradingDTO);
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .objectResponse(IContentTradingResponse.CONTENT_REGISTRATION_SUCCESS)
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(IContentTradingResponse.CONTENT_REGISTRATION_FAILED)
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
    public ResponseEntity<GenericResponseDTO> readContentTrading(ContentTradingDTO contentTradingDTO) {
        try {
            Optional<ContentTradingEntity> contentTradingExist = this.repository.findById(contentTradingDTO.getId());
            if (!contentTradingExist.isPresent()) {
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .objectResponse(contentTradingExist)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(IContentTradingResponse.CONTENT_SEARCHED_FAILED)
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
    public ResponseEntity<GenericResponseDTO> readContentsTrading() {
        try {
            List<ContentTradingEntity> contentTradingEntityList = this.repository.findAll();
            if (!contentTradingEntityList.isEmpty()) {
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .objectResponse(contentTradingEntityList)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(IContentTradingResponse.CONTENT_SEARCHED_FAILED)
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
    public ResponseEntity<GenericResponseDTO> updateContentTrading(ContentTradingDTO contentTradingDTO) {
        try {
            Optional<ContentTradingEntity> contentTradingExist = this.repository.findById(contentTradingDTO.getId());
            if (!contentTradingExist.isPresent()) {
                ContentTradingEntity entity = this.converter.converContentTradingDTOToContentTradingEntity(contentTradingDTO);
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .objectResponse(IContentTradingResponse.CONTENT_UPDATE_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(IContentTradingResponse.CONTENT_UPDATE_FAILED)
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
    public ResponseEntity<GenericResponseDTO> deleteContentTrading(Integer contentId) {
        try {
            Optional<ContentTradingEntity> contentTradingExist = this.repository.findById(contentId);
            if (contentTradingExist.isPresent()) {
                this.repository.deleteById(contentId);
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .objectResponse(IContentTradingResponse.CONTENT_DELETE_SUCCESS)
                        .httpResponse(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_FAIL)
                        .objectResponse(IContentTradingResponse.CONTENT_DELETED_FAILED)
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
