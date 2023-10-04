package com.trading.TradingUpFundationBackend.controller;

import com.trading.TradingUpFundationBackend.commons.domains.DTO.ContentTradingDTO;//Package that allows to use an object with the type of data DTO from the entity ContentTrading
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;//Package that allows to use a generic response with a DTO type
import org.springframework.http.ResponseEntity;//Package that allows to use a generic response with a DTO type
import org.springframework.web.bind.annotation.*;//Package that gives the annotations to represent a specific query

/**
 * Interface that creates method without body to be implemented in the controller of the entity ContentTrading
 */
public interface IContentTradingController {
    @PostMapping()//Annotation that represent the header of an HTTP query that creates a content with a POST query
    ResponseEntity<ObjectResponse> createContentTrading(@RequestBody ContentTradingDTO contentTradingDTO);//Method that creates a content
    @GetMapping()//Annotation that represent the header of an HTTP query that reads a content with a GET query
    ResponseEntity<ObjectResponse> readContentTrading(@RequestBody ContentTradingDTO contentTradingDTO);//Method that reads a content
    @GetMapping()//Annotation that represent the header of an HTTP query that read all the contents with a GET query
    ResponseEntity<ObjectResponse> readContentsTrading();//Method that reads all the content
    @PutMapping//Annotation that represent the header of an HTTP query that updates a content with a PUT query
    ResponseEntity<ObjectResponse> updateContentTrading(@RequestBody ContentTradingDTO contentTradingDTO);//Method that updates a content
    @DeleteMapping//Annotation that represent the header of an HTTP query that deletes a content with a DELETE query
    ResponseEntity<ObjectResponse> deleteContentTrading(@PathVariable Integer contentId);//Method that deletes a content
}
