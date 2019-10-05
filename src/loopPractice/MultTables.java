package loopPractice;

public class MultTables {
    public static void main (String [] args){
        for(int i=1; i<101; i++){
            for(int j=1; j<101; j++){
                System.out.print(i*j + " ");
            }
            System.out.println();
        }
    }
}
