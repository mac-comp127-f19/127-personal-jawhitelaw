package loopPractice;

import java.util.Scanner;

public class LowAndHigh {
    public static void main (String [] args){
        Scanner in = new Scanner (System.in);
        System.out.println("Please enter a number");
        int current = in.nextInt();
        int highest = current;
        int lowest = current;
        System.out.println("Please enter a number");
        while(current!=-1){
            current=in.nextInt();
            if (current>highest&&current!=-1){
                highest = current;
            }
            if (current<lowest&&current!=-1){
                lowest = current;
            }
            System.out.println("Please enter a number");
        }
        System.out.println("The highest number was " + highest);
        System.out.println("The lowest number was " + lowest);
        in.close();
    }
}
