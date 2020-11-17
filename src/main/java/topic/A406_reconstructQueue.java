package topic;

import java.util.Arrays;
import java.util.Comparator;

import static java.util.Comparator.comparingInt;

public class A406_reconstructQueue {


    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, Comparator.comparingInt((int[] p) -> p[0])
                .thenComparingInt(p -> p[1]));



        return people;
    }


}
