package ru.gb.lesson1.homework;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> menu = new ArrayList<>( Arrays.asList( "Выход", "Заполнить список числами", "Посчитать среднее по четным числам списка" ) );
        View view = new View();
        Scanner sc = new Scanner( System.in, Charset.defaultCharset() );
        Calculations calc = new Calculations();
        List<Integer> list = new ArrayList<>();

        while ( true ) {
            System.out.println("Введите поочередно числа для списка, либо слово end для завершения формирования списка:");
            view.showMenu( menu );
            if ( sc.hasNextInt() ) {
                switch( sc.nextInt() ) {
                    case 1:
                        return;
                    case 2:
                        fillArray(list, sc);
                    case 3:{
                        calc.setListOfInteger( list );
                        System.out.println(calc.getTheAverageOfEvenNumbers());}
                }
            } else {
                System.out.println( "Введен неверный пункт меню!" );
                sc.next();
            }
        }
    }

    private static void fillArray(List<Integer> list , Scanner sc){
        while ( true ) {
            if ( sc.hasNextInt() ) {
                list.add( sc.nextInt() );
                System.out.println("Текущий список: " + list);
            } else {
                if ( sc.next().equals( "end" ) ) break;
                else {
                    System.out.println( "Введите число или слово end!" );
                }
            }
        }
    }


}
