package com.trading.TradingUpFundationBackend.controller;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.LevelTradingDTO;//Package that allows to use an object with the type of data DTO from the entity LevelTrading
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;//Package that allows to use a generic response with a DTO type
import org.springframework.http.ResponseEntity;//Package that allows to use a generic response with a DTO type
import org.springframework.web.bind.annotation.*;//Package that gives the annotations to represent a specific query

/**
 * Interface that creates method without body to be implemented in the controller of the entity LevelTrading
 */
public interface ILevelTradingController {
    @PostMapping()//Annotation that represent the header of an HTTP query that creates a level with a POST query
    ResponseEntity<ObjectResponse> createLevelTrading(@RequestBody LevelTradingDTO levelTradingDTO);//Method that creates a level
    @GetMapping()//Annotation that represent the header of an HTTP query that reads a level with a GET query
    ResponseEntity<ObjectResponse> readLevelTrading(@RequestBody LevelTradingDTO levelTradingDTO);//Method that reads a level
    @GetMapping()//Annotation that represent the header of an HTTP query that read all the exercises with a GET query
    ResponseEntity<ObjectResponse> readLevelsTrading();//Method that reads all the levels
    @PutMapping//Annotation that represent the header of an HTTP query that updates a level with a PUT query
    ResponseEntity<ObjectResponse> updateLevelTrading(@RequestBody LevelTradingDTO levelTradingDTO);//Method that updates a level
    @PostMapping//Annotation that represent the header of an HTTP query that deletes a level with a DELETE query
    ResponseEntity<ObjectResponse> deleteLevelTrading(@RequestBody LevelTradingDTO levelTradingDTO);//Method that deletes a level
}
