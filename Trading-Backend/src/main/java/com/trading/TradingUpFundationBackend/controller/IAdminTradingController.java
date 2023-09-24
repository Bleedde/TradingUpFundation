package com.trading.TradingUpFundationBackend.controller;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.AdminTradingDTO;//Package that allows to use an object with the type of data DTO from the entity AdminTrading
import com.trading.TradingUpFundationBackend.commons.domains.GenericResponseDTO;//Package that allows to use a generic response with a DTO type
import org.springframework.http.ResponseEntity;//Package that gives a type of data that represents the response of an entity
import org.springframework.web.bind.annotation.*;//Package that gives the annotations to represent a specific query

/**
 * Interface that creates method without body to be implemented in the controller of the entity AdminTrading
 */
public interface IAdminTradingController {
    @PostMapping()//Annotation that represent the header of an HTTP query that creates an admin with a POST query
    ResponseEntity<GenericResponseDTO> createAdminTrading(@RequestBody AdminTradingDTO adminTradingDTO);//Method
    @GetMapping()//Annotation that represent the header of an HTTP query that reads an admin with a GET query
    ResponseEntity<GenericResponseDTO> readAdminTrading(@RequestBody AdminTradingDTO adminTradingDTO);
    @GetMapping()//Annotation that represent the header of an HTTP query that read all the admins with a GET query
    ResponseEntity<GenericResponseDTO> readAdminsTrading();
    @PutMapping//Annotation that represent the header of an HTTP query that updates an admin with a PUT query
    ResponseEntity<GenericResponseDTO> updateAdminTrading(@RequestBody AdminTradingDTO adminTradingDTO);
    @DeleteMapping//Annotation that represent the header of an HTTP query that deletes an admin with a DELETE query
    ResponseEntity<GenericResponseDTO> deleteAdminTrading(@RequestBody AdminTradingDTO adminTradingDTO);
}
