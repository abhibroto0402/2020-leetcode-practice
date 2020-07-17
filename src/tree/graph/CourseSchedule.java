package tree.graph;

import java.util.*;

public class CourseSchedule {
    HashMap<Integer, List<Integer>> adj;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.adj = buildAdjList(numCourses, prerequisites);
        if (detectCycle(numCourses)) return new int[0];
        boolean[] visited = new boolean[numCourses];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < numCourses; ++i) {
            if(!visited[i]){
                dfs(visited, stack, i);
            }
        }
        int [] ans = new int [numCourses];
        for(int i=0; i<numCourses && !stack.isEmpty();++i){
            ans[i] = stack.pop();
        }
        return ans;
    }

    private void dfs(boolean[] visited, Deque<Integer> stack, int i) {
        visited[i] =true;
        for(int children: adj.get(i)){
            if(!visited[children]){
                dfs(visited, stack, children);
            }
        }
        stack.push(i);
    }

    private boolean detectCycle(int V) {

        // Mark all the vertices as not visited and
        // not part of recursion stack
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];


        // Call the recursive helper function to
        // detect cycle in different DFS trees
        for (int i = 0; i < V; i++)
            if (isCyclicUtil(i, visited, recStack))
                return true;

        return false;
    }

    private boolean isCyclicUtil(int i, boolean[] visited,
                                 boolean[] recStack) {
        if (recStack[i])
            return true;

        if (visited[i])
            return false;

        visited[i] = true;

        recStack[i] = true;
        List<Integer> children = adj.get(i);

        for (Integer c : children)
            if (isCyclicUtil(c, visited, recStack))
                return true;

        recStack[i] = false;

        return false;
    }

    private HashMap<Integer, List<Integer>> buildAdjList(int numCourses, int[][] prerequisites) {
        // Create an empty map for starters
        HashMap<Integer, List<Integer>> adj = new HashMap<>();

        // Initialize each course with an empty list to prevent null pointer exceptions in the firstOrder method
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }

        // Create a mapping of some course X -> all the courses that depend on X
        for (int[] arr : prerequisites) {
            int course = arr[0];
            int dependency = arr[1];

            List<Integer> list = adj.get(dependency);
            list.add(course);

            // Example: [1, 0], course 1 depends on course 0, so the mapping here will be 0 -> [1]
            adj.put(dependency, list);
        }

        return adj;
    }

    public static void main(String[] args) {
        CourseSchedule schedule = new CourseSchedule();
        int [] [] arr = {
                {1,0},
                {2,1}
        };
        System.out.println(Arrays.toString(schedule.findOrder(3, arr)));
    }
}
