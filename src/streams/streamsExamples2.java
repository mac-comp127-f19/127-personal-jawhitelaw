package streams;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class streamsExamples2 {

    public long total =0;
    public void add (long value){
        total +=value;
    }

    public static long sideEffectSum(long n){
        streamsExamples2 streamsExamples2 = new streamsExamples2();
        LongStream.rangeClosed(1,n).parallel().forEach(streamsExamples2::add);
        return streamsExamples2.total;
    }

    public static void sequentialSum(long n){
        Stream.iterate(1L, i-> i+1).limit(n).reduce(0L, Long::sum);
    }

    private static final long N = 10_000_000L;

    public static void main(String[] args) {
/*        long start  = System.nanoTime();
        sequentialSum(N);
        long end = System.nanoTime();
        System.out.println(end-start);
        */

        System.out.println("side effect " + sideEffectSum(30));
    }
}

//  643428106
//  195211517