package com.trading.TradingUpFundationBackend.controller.Implements;

import com.trading.TradingUpFundationBackend.commons.constant.URLs.ILoginEndPoints;
import com.trading.TradingUpFundationBackend.commons.constant.response.Responses;
import com.trading.TradingUpFundationBackend.commons.domains.DTO.UserTradingDTO;
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;
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
            @ApiResponse(responseCode  = "200", description = Responses.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ObjectResponse.class))}),
            @ApiResponse(responseCode  = "400", description = Responses.CREATE_FAIL,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode  = "404", description = Responses.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "405", description = Responses.OPERATION_FAIL,
                    content = {@Content(mediaType = "aplication/json")}),
            @ApiResponse(responseCode  = "500", description = Responses.INTERNAL_SERVER_ERROR,
                    content = {@Content(mediaType = "application/json")})})
    public ResponseEntity<ObjectResponse> login(@RequestBody UserTradingDTO userTradingDTO) {
        return this.service.login(userTradingDTO);
    }
}