package topic;


import java.util.*;

/**
 * leetcode 834
 * */
public class SumOfDistancesInTree {

    public static void main(String[] args) {
        int N = 6;
        int [][] edges={{0,1},{0,2},{2,3},{2,4},{2,5}};
        SumOfDistancesInTree sumOfDistancesInTree = new SumOfDistancesInTree();

        int[] ans = sumOfDistancesInTree.sumOfDistancesInTree2(N, edges);
        System.out.println(Arrays.toString(ans));
    }

    // out of time
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        LinkedList<int[]> queue = new LinkedList<>();
        Map<Integer, List<int[]>> edgesCache = new HashMap<>();
        Map<String, Integer> distCache = new HashMap<>();
        for (int i = 0, length = edges.length; i < length; i++) {
            edgesCache.computeIfAbsent(edges[i][1], k -> new LinkedList<>());
            edgesCache.computeIfAbsent(edges[i][0], k -> new LinkedList<>());
            edgesCache.get(edges[i][0]).add(edges[i]);
            edgesCache.get(edges[i][1]).add(edges[i]);
        }

        int[] ans = new int[N];

        for (int i = 0; i < N; i++) {
            int curPath = 1;
            int[] reachedNodes = new int[N];
            reachedNodes[i] = 1;
            int distance = 0;

            if(edgesCache.containsKey(i)){
                queue.addAll(edgesCache.get(i));
            }

            while(!queue.isEmpty()){
                for (int j = 0,size = queue.size(); j < size; j++) {
                    int[] edge = queue.pollFirst();
                    if(reachedNodes[edge[0]] == 1 && reachedNodes[edge[1]] == 1){
                       continue;
                    }

                    int startNode = edge[0];
                    if(reachedNodes[edge[0]] == 1){
                        startNode = edge[1];
                    }

                    distance += curPath;
                    reachedNodes[startNode] = 1;

                    List<int[]> divEdges = edgesCache.get(startNode);
                    divEdges.forEach(tempEdge -> {
                        if (reachedNodes[tempEdge[0]] != 1 || reachedNodes[tempEdge[1]] != 1){
                            queue.offerLast(tempEdge);
                        }
                    });
                }
                curPath += 1;
            }

            ans[i] = distance;
        }

        return ans;
    }

    // 107ms 还是dp快
    public int[] sumOfDistancesInTree2(int N, int[][] edges) {
        LinkedList<int[]> queue = new LinkedList<>();
        Map<Integer, List<int[]>> edgesCache = new HashMap<>();

        for (int i = 0, length = edges.length; i < length; i++) {
            edgesCache.computeIfAbsent(edges[i][1], k -> new LinkedList<>());
            edgesCache.computeIfAbsent(edges[i][0], k -> new LinkedList<>());
            edgesCache.get(edges[i][0]).add(edges[i]);
            edgesCache.get(edges[i][1]).add(edges[i]);
        }

        int[] ans = new int[N];
        Map<Integer, Integer> nodesBehind = new HashMap<>();
        Map<Integer, Integer> nodesParent = new HashMap<>();
        Map<Integer, List<Integer>> nodesChildren = new HashMap<>();
        // 一次遍历，确定扩散方向
        for (int i = 0; i < 1; i++) {
            int curPath = 1;
            int[] reachedNodes = new int[N];
            reachedNodes[i] = 1;
            int distance = 0;

            if(edgesCache.containsKey(i)){
                queue.addAll(edgesCache.get(i));
            }

            while(!queue.isEmpty()){
                for (int j = 0,size = queue.size(); j < size; j++) {
                    int[] edge = queue.pollFirst();
                    if(reachedNodes[edge[0]] == 1 && reachedNodes[edge[1]] == 1){
                        continue;
                    }

                    int fromNode = edge[1];
                    int startNode = edge[0];
                    if(reachedNodes[edge[0]] == 1){
                        startNode = edge[1];
                        fromNode = edge[0];
                    }

                    // 找到一个节点
                    distance += curPath;
                    reachedNodes[startNode] = 1;

                    // 统计父节点
                    nodesParent.put(startNode, fromNode);
                    // 统计子节点
                    nodesChildren.computeIfAbsent(fromNode, k -> new LinkedList<>());
                    nodesChildren.get(fromNode).add(startNode);
                    // 统计身后节点数
                    Integer parent = fromNode;
                    while(parent != null){
                        nodesBehind.putIfAbsent(parent, 0);
                        nodesBehind.compute(parent, (k, v) -> v + 1);
                        parent = nodesParent.get(parent);
                    }

                    List<int[]> divEdges = edgesCache.get(startNode);
                    divEdges.forEach(tempEdge -> {
                        if (reachedNodes[tempEdge[0]] != 1 || reachedNodes[tempEdge[1]] != 1){
                            queue.offerLast(tempEdge);
                        }
                    });
                }
                curPath += 1;
            }

            ans[i] = distance;
        }

        LinkedList<Integer> children = new LinkedList<>();
        if(nodesChildren.containsKey(0)){
            children.addAll(nodesChildren.get(0));
        }
        while (!children.isEmpty()) {
            for (int i = 0, size = children.size(); i < size; i++) {
                int childNode = children.poll();
                int numOfBehind = 0;
                if(nodesBehind.containsKey(childNode)){
                    numOfBehind = nodesBehind.get(childNode);
                    children.addAll(nodesChildren.get(childNode));
                }
                int parent = nodesParent.get(childNode);
                int parentLength = ans[parent];
                int numOfAhead = N - numOfBehind - 2;
                ans[childNode] = parentLength + numOfAhead - numOfBehind;
            }
        }

        return ans;
    }

}
