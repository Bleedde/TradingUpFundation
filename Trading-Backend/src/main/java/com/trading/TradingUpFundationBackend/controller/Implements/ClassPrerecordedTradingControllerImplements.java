package com.trading.TradingUpFundationBackend.controller.Implements;

import com.trading.TradingUpFundationBackend.commons.constant.URLs.IClassPrerecordedTradingEndPoints;//Package which gives the urls for the entity ClassPrerecordedTrading
import com.trading.TradingUpFundationBackend.commons.constant.response.Responses;//Package that gives responses to possible situations
import com.trading.TradingUpFundationBackend.commons.domains.DTO.ClassPrerecordedTradingDTO;//Package that allows to use the serializable version of the entity ClassPrerecordedTradingEntity; ClassPrerecordedTradingDTO
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;//Package that creates a response like an object
import com.trading.TradingUpFundationBackend.controller.IClassPrerecordedTradingController;//Package which implements the interface IClassPrerecordedTradingController
import com.trading.TradingUpFundationBackend.service.Implements.ClassPrerecordedTradingServiceImplements;//Package which bring the service of the entity ClassPrerecordedTrading
import io.swagger.v3.oas.annotations.Operation;//Package which give the annotation @Operation from the swagger documentation
import io.swagger.v3.oas.annotations.media.Content;//Package which give the annotation @Content from the swagger documentation
import io.swagger.v3.oas.annotations.media.Schema;//Package which give the annotation @Schema from the swagger documentation
import io.swagger.v3.oas.annotations.responses.ApiResponse;//Package which give the annotation @ApiResponse from the swagger documentation
import io.swagger.v3.oas.annotations.responses.ApiResponses;//Package which give the annotation @ApiResponses from the swagger documentation
import io.swagger.v3.oas.annotations.tags.Tag;//Package which give the annotation @Tag from the swagger documentation
import org.springframework.http.ResponseEntity;//Package that allows the use the annotation @Service to represent this class like a service in the spring context
import org.springframework.web.bind.annotation.*;//Package that gives the possible methods of an HTTP query

@RestController//Annotation that represents this class like  a controller in the spring context
@Tag(name = "Class prerecorded database manage system", description = "Creat, read one, read all, update and delete a class prerecorded")//Annotation that documents this controller
@RequestMapping(IClassPrerecordedTradingEndPoints.URL_CLASS_PRERECORDED)//Annotation which represent this controller with a specific url

/**
 * Controller of the entity ClassPrerecordedTrading
 * Implements the interface IClassPrerecordedTradingController
 */
public class ClassPrerecordedTradingControllerImplements implements IClassPrerecordedTradingController {

    private final ClassPrerecordedTradingServiceImplements service;

    /**
     * Constructor that injects dependencies to this class
     * @param service
     */
    public ClassPrerecordedTradingControllerImplements(ClassPrerecordedTradingServiceImplements service) {
        this.service = service;
    }

    /**
     * Method which creates a class prerecorded using the service ClassPrerecordedTradingServiceImplements
     * @param classPrerecordedTradingDTO The class prerecorded to be created
     * @return The method "createClassPrerecordedTrading" from the service
     */
    @Override//Annotation that represent an override for a method in another interface
    @Operation(summary = "Create a new class prerecorded")//Annotation used to describe a specific action that the method is going to do
    @ApiResponses(value = {//Annotation that gives specific information of some HTTP response with swagger documentation
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
    @PostMapping(IClassPrerecordedTradingEndPoints.URL_CLASS_PRERECORDED_CREATE)
    public ResponseEntity<ObjectResponse> createClassPrerecordedTrading(ClassPrerecordedTradingDTO classPrerecordedTradingDTO) {
        return this.service.createClassPrerecordedTrading(classPrerecordedTradingDTO);
    }

    /**
     * Method which reads a class prerecorded using the service ClassPrerecordedTradingServiceImplements
     * @param classPrerecordedTradingDTO The class prerecorded to be read
     * @return The method "readClassPrerecordedTrading" from the service
     */
    @Override//Annotation that represent an override for a method in another interface
    @Operation(summary = "Read a class prerecorded")//Annotation used to describe a specific action that the method is going to do
    @ApiResponses(value = {//Annotation that gives specific information of some HTTP response with swagger documentation
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
    @GetMapping(IClassPrerecordedTradingEndPoints.URL_CLASS_PRERECORDED_READ)
    public ResponseEntity<ObjectResponse> readClassPrerecordedTrading(ClassPrerecordedTradingDTO classPrerecordedTradingDTO) {
        return this.service.readClassPrerecordedTrading(classPrerecordedTradingDTO);
    }

    /**
     * Method which reads all the classes prerecorded using the service ClassPrerecordedTradingServiceImplements
     * @return The method "readClassesPrerecordedBookTrading" from the service
     */
    @Override//Annotation that represent an override for a method in another interface
    @Operation(summary = "Read all the classes prerecorded")//Annotation used to describe a specific action that the method is going to do
    @ApiResponses(value = {//Annotation that gives specific information of some HTTP response with swagger documentation
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
    @GetMapping(IClassPrerecordedTradingEndPoints.URL_CLASSES_PRERECORDED_READ)
    public ResponseEntity<ObjectResponse> readClassesPrerecordedTrading() {
        return this.service.readAllClassesPrerecordedTrading();
    }

    /**
     * Method which updates a class prerecorded using the service ClassPrerecordedTradingServiceImplements
     * @param classPrerecordedTradingDTO The class prerecorded to be updated
     * @return The method "createBookTrading" from the service
     */
    @Override//Annotation that represent an override for a method in another interface
    @Operation(summary = "Update a class prerecorded")//Annotation used to describe a specific action that the method is going to do
    @ApiResponses(value = {//Annotation that gives specific information of some HTTP response with swagger documentation
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
    @PutMapping(IClassPrerecordedTradingEndPoints.URL_CLASS_PRERECORDED_UPDATE)
    public ResponseEntity<ObjectResponse> updateClassPrerecordedTrading(ClassPrerecordedTradingDTO classPrerecordedTradingDTO) {
        return this.service.updateClassPrerecordedTrading(classPrerecordedTradingDTO);
    }

    /**
     * Method which deletes a class prerecorded using the service BookTradingServiceImplements
     * @param classPrerecordedTradingDTO The class prerecorded to be deleted
     * @return The method "deleteClassPrerecordedTrading" from the service
     */
    @Override//Annotation that represent an override for a method in another interface
    @Operation(summary = "Delete a class prerecorded")//Annotation used to describe a specific action that the method is going to do
    @ApiResponses(value = {//Annotation that gives specific information of some HTTP response with swagger documentation
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
    @PostMapping(IClassPrerecordedTradingEndPoints.URL_CLASS_PRERECORDED_DELETE)
    public ResponseEntity<ObjectResponse> deleteClassPrerecordedTrading(ClassPrerecordedTradingDTO classPrerecordedTradingDTO) {
        return this.service.deleteClassPrerecordedTrading(classPrerecordedTradingDTO);
    }
}