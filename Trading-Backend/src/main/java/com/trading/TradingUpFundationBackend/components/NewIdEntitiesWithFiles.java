package com.trading.TradingUpFundationBackend.components;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NewIdEntitiesWithFiles {
    public Integer getHigherNumber(List<Integer> list){
        if(list == null || list.isEmpty()){
            return 0;
        }
        Integer maxNumber = list.get(0);
        for(Integer number : list){
            if(number > maxNumber){
                maxNumber = number;
            }
        }
        return maxNumber;
    }
}
