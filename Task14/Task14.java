package Task14;

import java.util.Scanner;

public class Task14 {
    public static void main(String[] args){

        try (Scanner scaner = new Scanner(System.in);){

            System.out.println("Введите текущий сигнал светофора (RED, YELLOW, GREEN): ");
            String color = scaner.next().trim().toUpperCase();

            System.out.println(TrafficLight.valueOf(color));
        }




    }
}
