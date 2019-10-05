package loopPractice;

public class SeriesSum {
    public static void main (String [] args){
        double sum=0;
        for (int i=1; i<10; i++){
            sum = sum + (1.0/i);
            System.out.println(sum);
        }
    }
}
