package com.trading.TradingUpFundationBackend.components;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

@Component
@Log4j2
public class DeleteFilesTablesRelated {

    @Autowired
    private Environment env;


    public void deleteExerciseSolutionFiles(Integer id){
        try {
            String folderPath = this.env.getProperty("exerciseSolution.upload.path") + File.separator + id;
            if (!folderPath.isEmpty()) {
                Files.walk(Paths.get(folderPath))
                        .sorted(Comparator.reverseOrder())
                        .map(Path::toFile)
                        .forEach(File::delete);
            }
        } catch (Exception e) {
            log.error("Something wrong deleting the file of the exercise solution with id " + id, e);
        }
    }

    public void deleteExerciseFiles(Integer id){
        try {
            String folderPath = this.env.getProperty("exercise.upload.path") + File.separator + id;
            if (!folderPath.isEmpty()) {
                Files.walk(Paths.get(folderPath))
                        .sorted(Comparator.reverseOrder())
                        .map(Path::toFile)
                        .forEach(File::delete);
            }
        } catch (Exception e){
            log.error("Something wron deleting exercise file with id " + id, e);
        }
    }
}
