package tree.graph;

import java.util.ArrayList;

public class UndirectedGraphDiameter {
    int diameter;

    public int treeDiameter(int[][] edges) {
        if (edges == null || edges.length == 0) return 0;
        diameter = 0;

        ArrayList<Integer>[] graph = new ArrayList[edges.length+1];
        boolean[] visited = new boolean[edges.length+1];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }

        applyDFS(graph, visited, 0);

        return diameter;
    }

    private int applyDFS(ArrayList<Integer>[] graph, boolean[] visited, int startNode) {
        int m1 = 0;
        int m2 = 0;
        visited[startNode] = true;

        for (int x : graph[startNode]) {
            if (!visited[x]) {
                int height = applyDFS(graph, visited, x);

                if (height > m1) { // this value beats both the height of left and right subtree
                    m2 = m1;
                    m1 = height;
                } else if (height > m2) { // this value beats the second best
                    m2 = height;
                }

                diameter = Math.max(diameter, m1 + m2);
            }
        }
        return m1 + 1; // return the best height + 1 upwards
    }
}
