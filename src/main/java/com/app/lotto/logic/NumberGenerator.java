package com.app.lotto.logic;

import java.util.Random;
import java.util.TreeSet;

public class NumberGenerator {
    public static String generateLottoNumbers(){
        String result = "";
        Random rand = new Random();
        TreeSet<Integer> numbers = new TreeSet<>();
        int counter = 0;
        while (counter < 6){
            int num = rand.nextInt(49) + 1;
            if(!numbers.contains(num)){
                numbers.add(num);
                counter++;
            }
        }
        for(Integer i: numbers){
            if(i < 10){
                result += "0" + i.toString();
            } else {
                result += i.toString();
            }
        }
        return result;
    }
}
