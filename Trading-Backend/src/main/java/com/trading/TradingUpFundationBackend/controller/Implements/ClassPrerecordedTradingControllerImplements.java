package com.trading.TradingUpFundationBackend.controller.Implements;

import com.trading.TradingUpFundationBackend.commons.constant.URLs.IClassPrerecordedTradingEndPoints;
import com.trading.TradingUpFundationBackend.commons.constant.URLs.IClassTradingEndPoints;
import com.trading.TradingUpFundationBackend.commons.constant.response.Responses;
import com.trading.TradingUpFundationBackend.commons.domains.DTO.ClassPrerecordedTradingDTO;
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;
import com.trading.TradingUpFundationBackend.controller.IClassPrerecordedTradingController;
import com.trading.TradingUpFundationBackend.service.Implements.ClassPrerecordedTradingServiceImplements;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Class prerecorded database manage system")
@RequestMapping(IClassPrerecordedTradingEndPoints.URL_CLASS_PRERECORDED)
public class ClassPrerecordedTradingControllerImplements implements IClassPrerecordedTradingController {

    private final ClassPrerecordedTradingServiceImplements service;

    public ClassPrerecordedTradingControllerImplements(ClassPrerecordedTradingServiceImplements service) {
        this.service = service;
    }

    @Override
    @Operation(summary = "Create a new class prerecorded")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = Responses.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ObjectResponse.class))}),
            @ApiResponse(responseCode  = "400", description = Responses.CREATE_FAIL,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode  = "404", description = Responses.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode  = "405", description = Responses.METHOD_FAIL,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode  = "500", description = Responses.INTERNAL_SERVER_ERROR,
                    content = {@Content(mediaType = "application/json")})})
    @PostMapping(IClassPrerecordedTradingEndPoints.URL_CLASS_PRERECORDED_CREATE)
    public ResponseEntity<ObjectResponse> createClassPrerecordedTrading(ClassPrerecordedTradingDTO classPrerecordedTradingDTO) {
        return this.service.createClassPrerecordedTrading(classPrerecordedTradingDTO);
    }

    @Override
    @Operation(summary = "Read a class prerecorded")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = Responses.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ObjectResponse.class))}),
            @ApiResponse(responseCode  = "400", description = Responses.CREATE_FAIL,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode  = "404", description = Responses.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode  = "405", description = Responses.METHOD_FAIL,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode  = "500", description = Responses.INTERNAL_SERVER_ERROR,
                    content = {@Content(mediaType = "application/json")})})
    @GetMapping(IClassPrerecordedTradingEndPoints.URL_CLASS_PRERECORDED_READ)
    public ResponseEntity<ObjectResponse> readClassPrerecordedTrading(ClassPrerecordedTradingDTO classPrerecordedTradingDTO) {
        return this.service.readClassPrerecordedTrading(classPrerecordedTradingDTO);
    }

    @Override
    @Operation(summary = "Read all the classes prerecorded")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = Responses.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ObjectResponse.class))}),
            @ApiResponse(responseCode  = "400", description = Responses.CREATE_FAIL,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode  = "404", description = Responses.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode  = "405", description = Responses.METHOD_FAIL,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode  = "500", description = Responses.INTERNAL_SERVER_ERROR,
                    content = {@Content(mediaType = "application/json")})})
    @GetMapping(IClassPrerecordedTradingEndPoints.URL_CLASSES_PRERECORDED_READ)
    public ResponseEntity<ObjectResponse> readClassesPrerecordedTrading() {
        return this.service.readAllClassesPrerecordedTrading();
    }

    @Override
    @Operation(summary = "Update a class prerecorded")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = Responses.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ObjectResponse.class))}),
            @ApiResponse(responseCode  = "400", description = Responses.CREATE_FAIL,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode  = "404", description = Responses.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode  = "405", description = Responses.METHOD_FAIL,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode  = "500", description = Responses.INTERNAL_SERVER_ERROR,
                    content = {@Content(mediaType = "application/json")})})
    @PutMapping(IClassPrerecordedTradingEndPoints.URL_CLASS_PRERECORDED_UPDATE)
    public ResponseEntity<ObjectResponse> updateClassPrerecordedTrading(ClassPrerecordedTradingDTO classPrerecordedTradingDTO) {
        return this.service.updateClassPrerecordedtrading(classPrerecordedTradingDTO);
    }

    @Override
    @Operation(summary = "Delete a class prerecorded")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = Responses.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ObjectResponse.class))}),
            @ApiResponse(responseCode  = "400", description = Responses.CREATE_FAIL,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode  = "404", description = Responses.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode  = "405", description = Responses.METHOD_FAIL,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode  = "500", description = Responses.INTERNAL_SERVER_ERROR,
                    content = {@Content(mediaType = "application/json")})})
    @PostMapping(IClassPrerecordedTradingEndPoints.URL_CLASS_PRERECORDED_DELETE)
    public ResponseEntity<ObjectResponse> deleteClassPrerecordedTrading(ClassPrerecordedTradingDTO classPrerecordedTradingDTO) {
        return this.service.deleteClassPrerecordedTrading(classPrerecordedTradingDTO);
    }
}
