package topic;

import java.util.*;

/**
 * leetcode 685
 */
public class FindRedundantDirectedConnection {
    public static int[] unionSet = null;
    public static int[] endpoint = null;

    /**
     * 负优化！
     * */
    public static boolean isLink(int[] edge) {
        int left = edge[0];
        int right = edge[1];
        List<Integer> nodes = new LinkedList<>();
        while (unionSet[left] != left) {
            nodes.add(left);
            left = unionSet[left];
        }

        while (unionSet[right] != right) {
            nodes.add(right);
            right = unionSet[right];
        }
        nodes.add(right);

        if (left == right) {
            int finalVal = right;
            nodes.forEach(e -> unionSet[e] = finalVal);
        }

        return left == right;
    }


    /**
     * 负优化！
     * */
    public static void link(int[] edge) {
        int left = edge[0];
        int right = edge[1];
        List<Integer> nodes = new LinkedList<>();

        while (unionSet[left] != unionSet[right] && unionSet[left] != left) {
            nodes.add(left);
            left = unionSet[left];
        }

        if (unionSet[left] == left) {
            nodes.add(left);
        }

        nodes.forEach(e -> unionSet[e] = right);
    }

    public static void main(String[] args) {
        int[][] edges = {{5,2},{2,3},{2,4},{4,5},{1,2}};


        unionSet = new int[edges.length + 1];
        endpoint = new int[edges.length + 1];
        for (int i = 0; i < unionSet.length; i++) {
            unionSet[i] = i;
        }
        for (int i = 0; i < endpoint.length; i++) {
            endpoint[i] = -1;
        }

        int delete = 0;
        List<int[]> sameEndEdges = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            if(endpoint[edges[i][1]] > -1){
                sameEndEdges.add(edges[endpoint[edges[i][1]]]);
                sameEndEdges.add(edges[i]);

                continue;
            }
            endpoint[edges[i][1]] = i;

            if (isLink(edges[i])) {
                delete = i;
            } else {
                link(edges[i]);
            }
        }

        if(!sameEndEdges.isEmpty()){

            if(isLink(sameEndEdges.get(1))){
                System.out.println(Arrays.toString(sameEndEdges.get(1)));
                return;
            } else {
                System.out.println(Arrays.toString(sameEndEdges.get(0)));
                return;
            }

        } else {
            System.out.println(Arrays.toString(edges[delete]));
        }

    }

}
