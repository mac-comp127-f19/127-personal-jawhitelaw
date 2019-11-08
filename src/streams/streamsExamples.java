package streams;

import java.util.*;
import java.util.stream.Collectors.*;

public class streamsExamples {
    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();
        names.add("j");
        names.add("fasdfas");
        names.add("charles");
        names.add("jake");
        names.add("steve");
        names.add("steven");
        names.add("jason");
        names.add("luca");
        names.add("nico");
        names.add("sean");

/*        names.stream().forEach(System.out :: println);
        names.stream().filter(g -> g.length()==4).forEach(System.out :: println);
        names.stream().filter(g -> g.substring(0,1).equals("j")).forEach(System.out :: println);
        names.stream().sorted().forEach(System.out :: println);
*/

        names.stream().sorted(Comparator.comparing(s -> s.length()*(-1))).forEach(System.out::println);
    }
}
