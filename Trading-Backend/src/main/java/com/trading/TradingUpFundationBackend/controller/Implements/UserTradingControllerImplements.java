package com.trading.TradingUpFundationBackend.controller.Implements;

import com.trading.TradingUpFundationBackend.commons.constant.URLs.IUserTradingEndPoints;
import com.trading.TradingUpFundationBackend.commons.constant.response.Responses;
import com.trading.TradingUpFundationBackend.commons.domains.DTO.UserTradingDTO;
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;
import com.trading.TradingUpFundationBackend.controller.IUserTradingController;
import com.trading.TradingUpFundationBackend.service.Implements.UserTradingServiceImplements;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "User database manage system", description = "Create, read, delete and update users")
@RequestMapping(IUserTradingEndPoints.URL_USER)
public class UserTradingControllerImplements implements IUserTradingController {

    private final UserTradingServiceImplements service;

    public UserTradingControllerImplements(UserTradingServiceImplements service){
        this.service = service;
    }
    @Override
    @Operation(summary = "Create a new user")
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
    @PostMapping(IUserTradingEndPoints.URL_USER_CREATE)
    public ResponseEntity<ObjectResponse> createUserTrading(@RequestBody UserTradingDTO userTradingDTO) {

        return this.service.createUserTrading(userTradingDTO);
    }

    @Override
    @Operation(summary = "Read an user")
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
    @GetMapping(IUserTradingEndPoints.URL_USER_READ)
    public ResponseEntity<ObjectResponse> readUserTrading(@RequestBody UserTradingDTO usertradingDTO) {
        return this.service.readUserTrading(usertradingDTO);
    }

    @Override
    @Operation(summary = "Read all the users")
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
    @GetMapping(IUserTradingEndPoints.URL_USERS_READ)
    public ResponseEntity<ObjectResponse> readUsersTrading() {
        return this.service.readUsersTrading();
    }

    @Override
    @Operation(summary = "Update an user")
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
    @PutMapping (IUserTradingEndPoints.URL_USER_UPDATE)
    public ResponseEntity<ObjectResponse> updateUserTrading(@RequestBody UserTradingDTO userTradingDTO) {
        return this.service.updateUserTrading(userTradingDTO);
    }

    @Override
    @Operation(summary = "Delete an user")
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
    @PostMapping(IUserTradingEndPoints.URL_USER_DELETE)
    public ResponseEntity<ObjectResponse> deleteUserTrading(@RequestBody UserTradingDTO userTradingDTO) {
        return this.service.deleteUserTrading(userTradingDTO);
    }
}
