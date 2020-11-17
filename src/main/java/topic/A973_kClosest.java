package topic;

import java.util.Arrays;

public class A973_kClosest {

    public int[][] kClosest(int[][] points, int K) {
//        Arrays.sort(points, (p1, p2) ->
//                (int) (Math.pow(p1[0], 2) + Math.pow(p1[1], 2) - Math.pow(p2[0], 2) - Math.pow(p2[1], 2))
//        );


        // faster!
        Arrays.sort(points, (p1, p2) -> (p1[0] + p2[0]) * (p1[0] - p2[0])
                + (p1[1] + p2[1]) * (p1[1] - p2[1])
        );

        return Arrays.copyOf(points, K);
    }

    // 前K个 ，考虑快排能有效优化


}
