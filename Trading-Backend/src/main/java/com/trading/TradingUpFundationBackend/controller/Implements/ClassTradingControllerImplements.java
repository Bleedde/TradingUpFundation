package com.trading.TradingUpFundationBackend.controller.Implements;

import com.trading.TradingUpFundationBackend.commons.constant.URLs.IClassTradingEndPoints;//Package which gives the urls for the entity ClassTrading
import com.trading.TradingUpFundationBackend.commons.domains.DTO.ClassTradingDTO;//Package that allows to use the serializable version of the entity ClassTradingEntity; ClassTradingDTO
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;//Package that creates a response like an object
import com.trading.TradingUpFundationBackend.controller.IClassTradingController;//Package which implements the interface IClassTradingController
import com.trading.TradingUpFundationBackend.service.Implements.ClassTradingServiceImplements;//Package which bring the service of the entity ClassTrading

import org.springframework.http.ResponseEntity;//Package that allows the use the annotation @Service to represent this class like a service in the spring context
import org.springframework.web.bind.annotation.*;//Package that gives the possible methods of an HTTP query

@RestController//Annotation that represents this class like  a controller in the spring context
@RequestMapping(IClassTradingEndPoints.URL_CLASS)//Annotation which represent this controller with a specific url

/**
 * Controller of the entity ClassTrading
 * Implements the interface IClassTradingController
 */
public class ClassTradingControllerImplements implements IClassTradingController {

    private final ClassTradingServiceImplements service;

    /**
     * Constructor that injects dependencies to this class
     * @param service
     */
    public ClassTradingControllerImplements(ClassTradingServiceImplements service) {
        this.service = service;
    }

    /**
     * Method which creates a class using the service ClassTradingServiceImplements
     * @param classTradingDTO The class to be created
     * @return The method "createClassTrading" from the service
     */
    @Override//Annotation that represent an override for a method in another interface
    @PostMapping(IClassTradingEndPoints.URL_CLASS_CREATE)
    public ResponseEntity<ObjectResponse> createClassTrading(@RequestBody ClassTradingDTO classTradingDTO) {
           System.out.println("valores de prueba:");
        return this.service.createClassTrading(classTradingDTO);
    }

    /**
     * Method which reads a class using the service ClassTradingServiceImplements
     * @param classTradingDTO The class to be read
     * @return The method "readClassTrading" from the service
     */
    @Override//Annotation that represent an override for a method in another interface
    @GetMapping(IClassTradingEndPoints.URL_CLASS_READ)
    public ResponseEntity<ObjectResponse> readClassTrading(@RequestBody ClassTradingDTO classTradingDTO) {
        return this.service.readClassTrading(classTradingDTO);
    }

    /**
     * Method which reads all the classes using the service ClassTradingServiceImplements
     * @return The method "readClassesTrading" from the service
     */
    @Override//Annotation that represent an override for a method in another interface
    @GetMapping(IClassTradingEndPoints.URL_CLASSES_READ)
    public ResponseEntity<ObjectResponse> readClassesTrading() {
        return this.service.readClassesTrading();
    }

    /**
     * Method which updates a class prerecorded using the service ClassTradingServiceImplements
     * @param classTradingDTO The class to be updated
     * @return The method "updateClassTrading" from the service
     */
    @Override//Annotation that represent an override for a method in another interface
    @PutMapping(IClassTradingEndPoints.URL_CLASS_UPDATE)
    public ResponseEntity<ObjectResponse> updateClassTrading(@RequestBody ClassTradingDTO classTradingDTO) {
        return this.service.updateClassTrading(classTradingDTO);
    }

    /**
     * Method which deletes a class prerecorded using the service ClassTradingServiceImplements
     * @param classTradingDTO The class to be deleted
     * @return The method "deleteClassTrading" from the service
     */
    @Override//Annotation that represent an override for a method in another interface
    @DeleteMapping(IClassTradingEndPoints.URL_CLASS_DELETE)
    public ResponseEntity<ObjectResponse> deleteClassTrading(@PathVariable Integer id) {
        return this.service.deleteClassTrading(id);
    }
}
