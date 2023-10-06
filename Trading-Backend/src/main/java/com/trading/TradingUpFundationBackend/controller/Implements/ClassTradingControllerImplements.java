package com.trading.TradingUpFundationBackend.controller.Implements;

import com.trading.TradingUpFundationBackend.commons.constant.URLs.IClassTradingEndPoints;
import com.trading.TradingUpFundationBackend.commons.constant.response.Responses;
import com.trading.TradingUpFundationBackend.commons.domains.DTO.ClassTradingDTO;
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;
import com.trading.TradingUpFundationBackend.controller.IClassTradingController;
import com.trading.TradingUpFundationBackend.service.Implements.ClassTradingServiceImplements;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Class database manage system", description = "Create, read one, read all, update and delete a class")
@RequestMapping(IClassTradingEndPoints.URL_CLASS)
public class ClassTradingControllerImplements implements IClassTradingController {

    private final ClassTradingServiceImplements service;

    public ClassTradingControllerImplements(ClassTradingServiceImplements service) {
        this.service = service;
    }

    @Override
    @Operation(summary = "Create a new class")
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
    @PostMapping(IClassTradingEndPoints.URL_CLASS_CREATE)
    public ResponseEntity<ObjectResponse> createClassTrading(@RequestBody ClassTradingDTO classTradingDTO) {
        return this.service.createClassTrading(classTradingDTO);
    }

    @Override
    @Operation(summary = "Read a class")
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
    @GetMapping(IClassTradingEndPoints.URL_CLASS_READ)
    public ResponseEntity<ObjectResponse> readClassTrading(@RequestBody ClassTradingDTO classTradingDTO) {
        return this.service.readClassTrading(classTradingDTO);
    }

    @Override
    @Operation(summary = "Read all the classes")
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
    @GetMapping(IClassTradingEndPoints.URL_CLASSES_READ)
    public ResponseEntity<ObjectResponse> readClassesTrading() {
        return this.service.readClassesTrading();
    }

    @Override
    @Operation(summary = "Update a class")
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
    @PutMapping(IClassTradingEndPoints.URL_CLASS_UPDATE)
    public ResponseEntity<ObjectResponse> updateClassTrading(@RequestBody ClassTradingDTO classTradingDTO) {
        return this.service.updateClassTrading(classTradingDTO);
    }

    @Override
    @Operation(summary = "Delete a class")
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
    @PostMapping(IClassTradingEndPoints.URL_CLASS_DELETE)
    public ResponseEntity<ObjectResponse> deleteClassTrading(@RequestBody ClassTradingDTO classTradingDTO) {
        return this.service.deleteClassTrading(classTradingDTO);
    }
}
