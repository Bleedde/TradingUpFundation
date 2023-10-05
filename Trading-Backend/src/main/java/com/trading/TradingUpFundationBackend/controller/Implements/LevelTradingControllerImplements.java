package com.trading.TradingUpFundationBackend.controller.Implements;

import com.trading.TradingUpFundationBackend.commons.constant.URLs.ILevelTradingEndPoints;
import com.trading.TradingUpFundationBackend.commons.constant.response.Responses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;
import com.trading.TradingUpFundationBackend.commons.domains.DTO.LevelTradingDTO;
import com.trading.TradingUpFundationBackend.controller.ILevelTradingController;
import com.trading.TradingUpFundationBackend.service.IMPL.LevelTradingService;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Level database manage system", description = "Create, read, read all, update and delete a level")
@RequestMapping(ILevelTradingEndPoints.URL_LEVEL)
public class LevelTradingControllerImplements implements ILevelTradingController{

    private final LevelTradingService service;
    public LevelTradingControllerImplements(LevelTradingService service){
        this.service = service;
    }

    @Override
    @Operation(summary = "Create a lavel")
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
    @PostMapping(ILevelTradingEndPoints.URL_LEVEL_CREATE)
    public ResponseEntity<ObjectResponse> createLevelTrading(@RequestBody LevelTradingDTO levelTradingDTO) {
        return this.service.createLevelTrading(levelTradingDTO);
    }

    @Override
    @Operation(summary = "Read a level")
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
    @GetMapping(ILevelTradingEndPoints.URL_LEVEL_READ)
    public ResponseEntity<ObjectResponse> readLevelTrading( @RequestBody LevelTradingDTO levelTradingDTO) {
        return this.service.readLevelTrading(levelTradingDTO);
    }

    @Override
    @Operation(summary = "Read all the levels")
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
    @GetMapping(ILevelTradingEndPoints.URL_LEVELS_READ)
    public ResponseEntity<ObjectResponse> readLevelsTrading() {
        return this.service.readLevelsTrading();
    }

    @Override
    @Operation(summary = "Update a level")
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
    @PutMapping(ILevelTradingEndPoints.URL_LEVEL_UPDATE)
    public ResponseEntity<ObjectResponse> updateLevelTrading(@RequestBody LevelTradingDTO levelTradingDTO) {
        return this.service.updateLevelTrading(levelTradingDTO);
    }

    @Override
    @Operation(summary = "Delete a level")
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
    @PostMapping(ILevelTradingEndPoints.URL_LEVEL_DELETE)
    public ResponseEntity<ObjectResponse> deleteLevelTrading(@RequestBody LevelTradingDTO levelTradingDTO) {
        return this.service.deleteLevelTrading(levelTradingDTO);
    }
}
