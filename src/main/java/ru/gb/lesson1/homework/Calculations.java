package ru.gb.lesson1.homework;

import java.util.List;

public class Calculations {

    private List<Integer> listOfInteger;

    public void setListOfInteger(List<Integer> listOfInteger) {
        this.listOfInteger = listOfInteger;
    }

    public double getTheAverageOfEvenNumbers(){

        double res = listOfInteger.stream()
                .filter(x -> x % 2 == 0)
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
        return res;
    }
}
