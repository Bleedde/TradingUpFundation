package com.trading.TradingUpFundationBackend.components;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class Dates {
    public LocalDate transformStringToLocalDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate newDate = LocalDate.parse(date, formatter);
        return newDate;
    }

    public boolean compareDates(LocalDate startDate, LocalDate endDate, LocalDate solutionDate){
        return (solutionDate.equals(startDate) || solutionDate.isAfter(startDate) && solutionDate.equals(endDate) || solutionDate.isBefore(endDate));
    }
}
