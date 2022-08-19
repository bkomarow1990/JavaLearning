package program;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Pair<Integer,Integer>> tasks = new ArrayList<Pair<Integer, Integer>>();
    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    public static boolean IsContainsInTasks(int one, int two){
        //System.out.println("one: "+ ta);
        return tasks.stream().anyMatch((pair) ->
                pair.getKey() == one && pair.getValue() == two || pair.getValue() == one && pair.getKey() == two
        );
//        if()
//        {
//
//        }
    }
    public static void main(String[] args){
        //public

        System.out.println("salama!");
        int one;
        int two;
        int maxPoints = 13;
        int points = 0;
        for (int i=0; i<maxPoints; ++i){
            do{
                one = getRandomNumber(1,10);
                two = getRandomNumber(1,10);
                //System.out.println("repeat");
            }
            while(IsContainsInTasks(one, two));
            System.out.print(one + " * " + two + " = ");
            int answer = scanner.nextInt();
            if(answer == one * two){
                ++points;
            }
            tasks.add(new Pair<>(one, two));
            //System.out.println();
        }
        //System.out.println("You get " + maxPoints/12 * points + " from " + maxPoints);
        System.out.println("You get " + maxPoints/12 * points + " from " + 12);
    }
}
