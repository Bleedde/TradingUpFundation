package com.trading.TradingUpFundationBackend.controller.IMPL;

import com.trading.TradingUpFundationBackend.commons.constant.endPoints.IUserTradingEndPoints;
import com.trading.TradingUpFundationBackend.commons.constant.response.GeneralResponse;
import com.trading.TradingUpFundationBackend.commons.domains.DTO.UserTradingDTO;
import com.trading.TradingUpFundationBackend.commons.domains.GenericResponseDTO;
import com.trading.TradingUpFundationBackend.controller.IUserTradingController;
import com.trading.TradingUpFundationBackend.service.IMPL.UserTradingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "User database manage system", description = "Create, read, delete and update users")
@Log4j2
@RequestMapping(IUserTradingEndPoints.URL_USER)
public class UserTradingControllerImplements implements IUserTradingController {

    private final UserTradingService service;

    public UserTradingControllerImplements(UserTradingService service){
        this.service = service;
    }
    @Override
    @Operation(summary = "Create a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = GeneralResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode  = "400", description = GeneralResponse.CREATE_FAIL,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode  = "404", description = GeneralResponse.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode  = "500", description = GeneralResponse.INTERNAL_SERVER_ERROR,
                    content = {@Content(mediaType = "application/json")})})
    @PostMapping(IUserTradingEndPoints.URL_USER_CREATE)
    public ResponseEntity<GenericResponseDTO> createUserTrading(@RequestBody UserTradingDTO userTradingDTO) {
        System.out.println("aaaaa" + userTradingDTO.getUserLevel());
        return this.service.createUserTrading(userTradingDTO);
    }

    @Override
    @Operation(summary = "Read an user")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = GeneralResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode  = "400", description = GeneralResponse.CREATE_FAIL,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode  = "404", description = GeneralResponse.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode  = "500", description = GeneralResponse.INTERNAL_SERVER_ERROR,
                    content = {@Content(mediaType = "application/json")})})
    @GetMapping(IUserTradingEndPoints.URL_USER_READ)
    public ResponseEntity<GenericResponseDTO> readUserTrading(@RequestBody UserTradingDTO usertradingDTO) {
        return this.service.readUserTrading(usertradingDTO);
    }

    @Override
    @Operation(summary = "Read all the users")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = GeneralResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode  = "400", description = GeneralResponse.CREATE_FAIL,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode  = "404", description = GeneralResponse.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode  = "500", description = GeneralResponse.INTERNAL_SERVER_ERROR,
                    content = {@Content(mediaType = "application/json")})})
    @GetMapping(IUserTradingEndPoints.URL_USERS_READ)
    public ResponseEntity<GenericResponseDTO> readUsersTrading() {
        return this.service.readUsersTrading();
    }

    @Override
    @Operation(summary = "Update an user")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = GeneralResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode  = "400", description = GeneralResponse.CREATE_FAIL,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode  = "404", description = GeneralResponse.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode  = "500", description = GeneralResponse.INTERNAL_SERVER_ERROR,
                    content = {@Content(mediaType = "application/json")})})
    @PutMapping (IUserTradingEndPoints.URL_USER_UPDATE)
    public ResponseEntity<GenericResponseDTO> updateUserTrading(@RequestBody UserTradingDTO userTradingDTO) {
        System.out.println(userTradingDTO);
        return this.service.updateUserTrading(userTradingDTO);
    }

    @Override
    @Operation(summary = "Delete an user")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = GeneralResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode  = "400", description = GeneralResponse.CREATE_FAIL,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode  = "404", description = GeneralResponse.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode  = "500", description = GeneralResponse.INTERNAL_SERVER_ERROR,
                    content = {@Content(mediaType = "application/json")})})
    @PostMapping(IUserTradingEndPoints.URL_USER_DELETE)
    public ResponseEntity<GenericResponseDTO> deleteUserTrading(@RequestBody UserTradingDTO userTradingDTO) {
        return this.service.deleteUserTrading(userTradingDTO);
    }
}
