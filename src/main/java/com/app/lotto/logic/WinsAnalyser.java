package com.app.lotto.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinsAnalyser {
    Logger logger = LoggerFactory.getLogger(WinsAnalyser.class);

    public List<Integer> findLottoGameHits(String result, List<String> numbers){
        List<Integer> hits = new ArrayList<>();
        numbers.stream().forEach(n -> {
            hits.add(findHitQuantity(result, n));
        });
        return hits;
    }

    public Integer findHitQuantity(String result, String numbers){
        Set<Integer> resultSet = convertToIntegersSet(result);
        Set<Integer> numbersSet = convertToIntegersSet(numbers);
        final int[] hitsQuantity = {0};
        numbersSet.forEach(n -> {
            if(resultSet.contains(n)){
                hitsQuantity[0]++;
            }
        });
        logger.info("Number of hits: " + hitsQuantity[0]);
        return hitsQuantity[0];
    }

    public Set<Integer> convertToIntegersSet(String numbers){
        Set<Integer> result = new HashSet<>();
        for (int i=0; i<numbers.length(); i+=2){
            result.add(new Integer(numbers.substring(i, i+2)));
        }
        return result;
    }
}
