package arrays;

import java.util.Arrays;

public class ArraySort {

    private static String[] merge(String[] a, String[] b) {
        int newLength = a.length + b.length;

        String[] merged = new String[newLength];

        for (int i = 0, ai = 0, bi = 0; i < newLength-1; i++) {
            if (a[ai]==null){
                merged[i] = b[bi];
                bi++;
            }
            else if (b[bi]==null){
                merged[i] = a[ai];
                ai++;
            }
            else if (a[ai].compareToIgnoreCase(b[bi]) < 0) {
                merged[i] = a[ai];
                ai++;
            } else {
                merged[i] = b[bi];
                bi++;
            }
            if (bi==b.length&&ai+1==a.length){
                merged[newLength-1] = a[ai];
            }
            else if (ai==a.length&&bi+1==b.length){
                merged[newLength-1] = b[bi];
            }
        }

        return merged;
    }

    public static String[] sort(String[] a) {
        if (a == null){
            return null;
        }
        if (a.length == 0){
            return a;
        }
        if (a.length == 1) {
            return a;
        }

        int mid = a.length / 2;

        String[] front = Arrays.copyOfRange(a, 0, mid);
        String[] back = Arrays.copyOfRange(a, mid, a.length);

        return merge(sort(front), sort(back));
    }

}
