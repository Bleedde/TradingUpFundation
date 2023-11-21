package com.trading.TradingUpFundationBackend.controller.Implements;

import com.trading.TradingUpFundationBackend.commons.constant.URLs.IExerciseSolutionTradingEndPoints;
import com.trading.TradingUpFundationBackend.commons.domains.DTO.ExerciseSolutionTradingDTO;
import com.trading.TradingUpFundationBackend.commons.domains.ObjectResponse;
import com.trading.TradingUpFundationBackend.controller.IExerciseSolutionTradingController;
import com.trading.TradingUpFundationBackend.service.Implements.ExerciseSolutionTradingServiceImplements;
import org.hibernate.sql.ast.tree.expression.Over;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(IExerciseSolutionTradingEndPoints.URL_EXERCISE_SOLUTION)
public class ExerciseSolutionTradingControllerImplements implements IExerciseSolutionTradingController {
    private final ExerciseSolutionTradingServiceImplements service;

    /**
     * Constructor that injects dependencies to this class
     * @param service
     */
    public ExerciseSolutionTradingControllerImplements(ExerciseSolutionTradingServiceImplements service) {
        this.service = service;
    }

    /**
     * Method which creates an exercise solution using the service ExerciseSolutionTradingServiceImplements
     * @param exerciseSolutionTradingDTO The exercise solution to be created
     * @return The method "createExerciseSolutionTrading" from the service
     */
    @Override//Annotation that represent an override for a method in another interface
    @PostMapping(IExerciseSolutionTradingEndPoints.URL_EXERCISE_SOLUTION_CREATE)//Annotation which represent this method with a specific endPoint
    public ResponseEntity<ObjectResponse> createExerciseSolutionTrading(@ModelAttribute ExerciseSolutionTradingDTO exerciseSolutionTradingDTO) {
        return this.service.createExerciseSolutionTrading(exerciseSolutionTradingDTO);
    }

    /**
     * Method which reads an exercise using the service ExerciseSolutionServiceImplements
     * @param id The id of the exercise solution to be read
     * @return The method "readExerciseSolutionTrading" from the service
     */
    @Override//Annotation that represent an override for a method in another interface
    @GetMapping(IExerciseSolutionTradingEndPoints.URL_EXERCISE_SOLUTION_READ)
    public ResponseEntity<ObjectResponse> readExerciseSolutionTrading(@PathVariable Integer id) {
        return this.service.readExerciseSolutionTrading(id);
    }

    /**
     * Method which reads all the exercises using the service ExerciseTradingServiceImplements
     * @return The method "readExercisesTrading" from the service
     */
    @Override//Annotation that represent an override for a method in another interface
    @GetMapping(IExerciseSolutionTradingEndPoints.URL_EXERCISE_SOLUTIONS_READ)
    public ResponseEntity<ObjectResponse> readExerciseSolutionsTrading(@PathVariable Integer exerciseId) {
        return this.service.readExercisesSolutionsTrading(exerciseId);
    }

    @Override
    @PostMapping(IExerciseSolutionTradingEndPoints.URL_EXERCISE_SOLUTION_SOLUTIONS_FOR_USER)
    public ResponseEntity<ObjectResponse> getSolutionsOfAExerciseForAUser(@RequestBody ExerciseSolutionTradingDTO exerciseSolutionTradingDTO){
        return this.service.getSolutionsOfAExerciseForAUser(exerciseSolutionTradingDTO);
    }


    /**
     * Method which returns a file
     * @param id The id of the file
     * @return The method "getFile" from the service
     */
    @Override//Annotation that represent an override for a method in another interface
    @GetMapping(IExerciseSolutionTradingEndPoints.URL_EXERCISE_SOLUTION_FILE)//Annotation which represent this method with a specific endPoint
    public ResponseEntity<byte[]> getFile(@PathVariable Integer id) {
        return this.service.getFile(id);
    }
}
