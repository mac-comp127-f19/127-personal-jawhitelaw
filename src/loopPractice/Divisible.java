package loopPractice;

import java.util.Scanner;

public class Divisible {
    public static void main (String [] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter a upper bound:");
        int upper = in.nextInt();
        System.out.println("Please enter a lower bound:");
        int lower = in.nextInt();
        for (int i = lower + 1; i<upper; i++){
            if(i%4==0&&i%5!=0){
                System.out.print(i + " ");
            }
        }
        in.close();
    }
}
