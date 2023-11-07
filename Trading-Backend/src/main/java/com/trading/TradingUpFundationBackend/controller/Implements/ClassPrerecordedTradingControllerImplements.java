package com.trading.TradingUpFundationBackend.controller.Implements;

import com.trading.TradingUpFundationBackend.commons.constant.URLs.IClassPrerecordedTradingEndPoints;//Package which gives the urls for the entity ClassPrerecordedTrading
import com.trading.TradingUpFundationBackend.commons.domains.DTO.ClassPrerecordedTradingDTO;//Package that allows to use the serializable version of the entity ClassPrerecordedTradingEntity; ClassPrerecordedTradingDTO
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;//Package that creates a response like an object
import com.trading.TradingUpFundationBackend.controller.IClassPrerecordedTradingController;//Package which implements the interface IClassPrerecordedTradingController
import com.trading.TradingUpFundationBackend.service.Implements.ClassPrerecordedTradingServiceImplements;//Package which bring the service of the entity ClassPrerecordedTrading

import org.springframework.http.ResponseEntity;//Package that allows the use the annotation @Service to represent this class like a service in the spring context
import org.springframework.web.bind.annotation.*;//Package that gives the possible methods of an HTTP query

@RestController//Annotation that represents this class like  a controller in the spring context
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
    @PostMapping(IClassPrerecordedTradingEndPoints.URL_CLASS_PRERECORDED_CREATE)
    public ResponseEntity<ObjectResponse> createClassPrerecordedTrading(@RequestBody ClassPrerecordedTradingDTO classPrerecordedTradingDTO) {
        return this.service.createClassPrerecordedTrading(classPrerecordedTradingDTO);
    }

    /**
     * Method which reads a class prerecorded using the service ClassPrerecordedTradingServiceImplements
     * @param classPrerecordedTradingDTO The class prerecorded to be read
     * @return The method "readClassPrerecordedTrading" from the service
     */
    @Override//Annotation that represent an override for a method in another interface
    @GetMapping(IClassPrerecordedTradingEndPoints.URL_CLASS_PRERECORDED_READ)
    public ResponseEntity<ObjectResponse> readClassPrerecordedTrading(@RequestBody ClassPrerecordedTradingDTO classPrerecordedTradingDTO) {
        return this.service.readClassPrerecordedTrading(classPrerecordedTradingDTO);
    }

    /**
     * Method which reads all the classes prerecorded using the service ClassPrerecordedTradingServiceImplements
     * @return The method "readClassesPrerecordedBookTrading" from the service
     */
    @Override//Annotation that represent an override for a method in another interface
    @GetMapping(IClassPrerecordedTradingEndPoints.URL_CLASSES_PRERECORDED_READ)
    public ResponseEntity<ObjectResponse> readClassesPrerecordedTrading(@PathVariable Integer level) {
        return this.service.readAllClassesPrerecordedTrading(level);
    }

    /**
     * Method which updates a class prerecorded using the service ClassPrerecordedTradingServiceImplements
     * @param classPrerecordedTradingDTO The class prerecorded to be updated
     * @return The method "createBookTrading" from the service
     */
    @Override//Annotation that represent an override for a method in another interface
    @PutMapping(IClassPrerecordedTradingEndPoints.URL_CLASS_PRERECORDED_UPDATE)
    public ResponseEntity<ObjectResponse> updateClassPrerecordedTrading(@RequestBody ClassPrerecordedTradingDTO classPrerecordedTradingDTO) {
        return this.service.updateClassPrerecordedTrading(classPrerecordedTradingDTO);
    }

    /**
     * Method which deletes a class prerecorded using the service BookTradingServiceImplements
     * @param id The id of the class prerecorded to be deleted
     * @return The method "deleteClassPrerecordedTrading" from the service
     */
    @Override//Annotation that represent an override for a method in another interface
    @DeleteMapping(IClassPrerecordedTradingEndPoints.URL_CLASS_PRERECORDED_DELETE)
    public ResponseEntity<ObjectResponse> deleteClassPrerecordedTrading(@PathVariable Integer id) {
        return this.service.deleteClassPrerecordedTrading(id);
    }
}