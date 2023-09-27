package com.trading.TradingUpFundationBackend.controller.IMPL;

import com.trading.TradingUpFundationBackend.commons.constant.endPoints.ILoginEndPoints;
import com.trading.TradingUpFundationBackend.commons.constant.response.GeneralResponse;
import com.trading.TradingUpFundationBackend.commons.domains.DTO.UserTradingDTO;
import com.trading.TradingUpFundationBackend.commons.domains.GenericResponseDTO;
import com.trading.TradingUpFundationBackend.controller.ILoginController;
import com.trading.TradingUpFundationBackend.service.IMPL.LoginTradingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ILoginEndPoints.URL_BASE_LOGIN)
public class LoginTradingControllerImplements implements ILoginController {
    @Autowired
    private LoginTradingService service;
    @Override
    @PostMapping(ILoginEndPoints.URL_LOGIN)
    @Operation(summary = "Delete an admin")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = GeneralResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode  = "400", description = GeneralResponse.CREATE_FAIL,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode  = "404", description = GeneralResponse.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "405", description = GeneralResponse.OPERATION_FAIL,
                    content = {@Content(mediaType = "aplication/json")}),
            @ApiResponse(responseCode  = "500", description = GeneralResponse.INTERNAL_SERVER_ERROR,
                    content = {@Content(mediaType = "application/json")})})
    public ResponseEntity<GenericResponseDTO> login(@RequestBody UserTradingDTO userTradingDTO) {
        return this.service.login(userTradingDTO);
    }
}