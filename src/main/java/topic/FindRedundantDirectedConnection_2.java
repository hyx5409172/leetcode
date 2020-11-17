package topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 685
 */
public class FindRedundantDirectedConnection_2 {

    public static int[] unionSet = null;
    public static int[] endpoint = null;

    public static boolean isLink(int[] edge) {
        int left = edge[0];
        int right = edge[1];

        while(unionSet[left] != left){
            left = unionSet[left];
        }

        while(unionSet[right] != right){
            right = unionSet[right];
        }

        return left == right;
    }

    public static void link(int[] edge) {
        int left = edge[0];
        int right = edge[1];

        unionSet[right] = left;
    }

    public static void main(String[] args) {
        int[][] edges = {{1,2},{1,3},{2,3}};


        unionSet = new int[edges.length + 1];
        endpoint = new int[edges.length + 1];
        for (int i = 0; i < unionSet.length; i++) {
            unionSet[i] = i;
        }
        for (int i = 0; i < endpoint.length; i++) {
            endpoint[i] = -1;
        }

        List<int[]> sameEndEdges = new ArrayList<>();
        int delete = 0;
        for (int i = 0; i < edges.length; i++) {
            if(endpoint[edges[i][1]] > -1){
                sameEndEdges.add(edges[endpoint[edges[i][1]]]);
                sameEndEdges.add(edges[i]);

                continue;
            }
            endpoint[edges[i][1]] = i;

            if (!isLink(edges[i])) {
                link(edges[i]);
            } else {
                delete = i;
            }
        }

        if(!sameEndEdges.isEmpty()){

            if(!isLink(sameEndEdges.get(1))){
                System.out.println(Arrays.toString(sameEndEdges.get(0)));
                return ;
            } else {
                System.out.println(Arrays.toString(sameEndEdges.get(1)));
                return ;
            }

        } else {
            System.out.println(Arrays.toString(edges[delete]));
            return ;
        }

    }


}
