package com.app.lotto.service;

import com.app.lotto.repository.SelectedNumbers;
import com.app.lotto.repository.SelectedNumbersRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

@Service
@Transactional
@AllArgsConstructor
public class SelectedNumbersServiceImpl implements SelectedNumbersService{
    private final Logger logger = LoggerFactory.getLogger(SelectedNumbersServiceImpl.class);
    private final SelectedNumbersRepository repository;

    @Override
    public List<SelectedNumbers> getAll() {
        return repository.findAll();
    }

    @Override
    public SelectedNumbers save(SelectedNumbers numbers) {
        return repository.save(numbers);
    }

    @Override
    public SelectedNumbers save(String gameType, String numbers) {
        SelectedNumbers selectedNumbers = new SelectedNumbers();
        selectedNumbers.setGameType(gameType);
        selectedNumbers.setNumbers(numbers);
        selectedNumbers.setCreatedTime(LocalDateTime.now());
        logger.info(selectedNumbers.toString());
        if(validateNumbers(numbers, gameType)){
            return repository.save(selectedNumbers);
        } else {
            return selectedNumbers;
        }

    }

    private boolean validateNumbers(String numbers, String gameType){
        boolean result = false;
        int numbersQuantity = -1;
        int min = 1000;
        int max = -1;
        List<Integer> numberList = parseFromStringToListInteger(numbers);
        switch (gameType){
            case "Lotto": numbersQuantity = 6;
            if(numberList.size() != numbersQuantity){
                logger.info("Incorrect numbers quantity.");
            } else {
                for(int i=0; i<numberList.size(); i++){
                    min = Math.min(numberList.get(i), min);
                    max = Math.max(numberList.get(i), max);
                }
                if((min > 0 && min < 37) && (max > 0 && max < 37)){
                    result = true;
                }
            }
            break;
            default: logger.info("Unknown name game.");
        }
        return result;
    }

    private List<Integer> parseFromStringToListInteger(String numbers){
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<numbers.length()/2; i++){
            if(numbers.charAt(i) == '0'){
                result.add(new Integer(numbers.charAt(i + 1)));
            } else {
                result.add(new Integer(numbers.substring(i, 2)));
            }
        }
        return result;
    }
}
