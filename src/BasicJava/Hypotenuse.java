package BasicJava;

import java.util.Scanner;

public class Hypotenuse {
    public static double calculateHypotenuse(double length1, double length2){
        return Math.sqrt((length1*length1)+(length2*length2));
    }
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the first side length:");
        double x = in.nextDouble();
        System.out.println("Please enter the second side length:");
        double y = in.nextDouble();
        System.out.println("The hypotenuse is " + calculateHypotenuse(x,y));

    }
}
