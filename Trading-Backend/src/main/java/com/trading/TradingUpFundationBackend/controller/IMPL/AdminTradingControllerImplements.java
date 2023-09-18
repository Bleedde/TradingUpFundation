package com.trading.TradingUpFundationBackend.controller.IMPL;

import com.trading.TradingUpFundationBackend.commons.constant.endPoints.IAdminTradingEndPoints;
import com.trading.TradingUpFundationBackend.commons.constant.response.GeneralResponse;
import com.trading.TradingUpFundationBackend.commons.domains.DTO.AdminTradingDTO;
import com.trading.TradingUpFundationBackend.commons.domains.GenericResponseDTO;
import com.trading.TradingUpFundationBackend.controller.IAdminTradingController;
import com.trading.TradingUpFundationBackend.service.IMPL.AdminTradingService;
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
@Tag(name = "Admin database manage system", description = "Create, read, delete and update admins")
@Log4j2
@RequestMapping(IAdminTradingEndPoints.URL_ADMIN)
public class AdminTradingControllerImplements implements IAdminTradingController {

    private final AdminTradingService service;

    public AdminTradingControllerImplements(AdminTradingService service){
        this.service = service;
    }
    @Override
    @Operation(summary = "Create a new admin")
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
    @PostMapping(IAdminTradingEndPoints.URL_ADMIN_CREATE)
    public ResponseEntity<GenericResponseDTO> createAdminTrading(AdminTradingDTO adminTradingDTO) {
        return this.service.createAdminTrading(adminTradingDTO);
    }

    @Override
    @Operation(summary = "Read a new admin")
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
    @GetMapping(IAdminTradingEndPoints.ULR_ADMIN_READ)
    public ResponseEntity<GenericResponseDTO> readAdminTrading(AdminTradingDTO adminTradingDTO) {
        return this.service.readAdminTrading(adminTradingDTO);
    }

    @Override
    @Operation(summary = "Read all the admins")
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
    @GetMapping(IAdminTradingEndPoints.URL_ADMINS_READ)
    public ResponseEntity<GenericResponseDTO> readAdminsTrading() {
        return this.service.readAdminsTrading();
    }

    @Override
    @Operation(summary = "Update an admin")
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
    @PutMapping(IAdminTradingEndPoints.URL_ADMIN_UPDATE)
    public ResponseEntity<GenericResponseDTO> updateAdminTrading(AdminTradingDTO adminTradingDTO) {
        return this.service.updateAdminTrading(adminTradingDTO);
    }

    @Override
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
            @ApiResponse(responseCode  = "500", description = GeneralResponse.INTERNAL_SERVER_ERROR,
                    content = {@Content(mediaType = "application/json")})})
    @DeleteMapping(IAdminTradingEndPoints.URL_ADMIN_DELETE)
    public ResponseEntity<GenericResponseDTO> deleteAdminTrading(Integer adminId) {
        return this.service.deleteAdminTrading(adminId);
    }
}