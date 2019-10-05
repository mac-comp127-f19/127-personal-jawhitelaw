package BasicJava;

import java.util.Scanner;

public class BasicStuff {
    public static void main(String[] args){

        double age0=17;
        double age1=19;
        System.out.println("We are " + age0 + " and " + age1 + " years old!");
        double sumOfAges = age0 + age1;
        System.out.println("The sum of our ages is " + sumOfAges);
        System.out.println("The sum of our ages is " + (age0+age1));
        System.out.println(Integer.MIN_VALUE-1);

        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number of hours");
        double x = in.nextDouble();
        double numWeeks = x/168;
        double numDays = x/24;
        System.out.println("Number of weeks: " + numWeeks);
        System.out.println("Number of days: " + numDays);
        System.out.println("Number of hours: " + x);

        System.out.println(1+2-3-4);

    }
}
