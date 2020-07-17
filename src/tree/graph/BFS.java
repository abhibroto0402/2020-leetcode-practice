package tree.graph;

import java.util.*;
public class BFS {
    public boolean graphContains(Graph g, String source, String element){
        if(!g.hasVertex(source)) return false;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(source);
        queue.add(source);
        while(queue.size()!=0){
            source = queue.poll();
            if(g.getAdjacentVertices(source)==null) continue;
            ListIterator<String> i = g.getAdjacentVertices(source).listIterator();
            while(i.hasNext()){
                String s =i.next();
                if(s.equals(element)) {
                    System.out.println("Source: "+ source);
                    return true;
                }
                if(!visited.contains(s)){
                    visited.add(s);
                    queue.add(s);
                }
            }
        }
        return false;
    }
    public static void main(String [] args){
        Graph g= new Graph();
        //g.addEdge("a","k");
        g.addEdge("a","c");
        g.addEdge("f","b");
        g.addEdge("a","s");
        g.addEdge("a","f");
        g.addEdge("b","s");
        g.addEdge("b","j");
        g.addEdge("k","j");
        BFS search = new BFS();
        System.out.println(search.graphContains(g, "a", "b"));
        System.out.println(search.graphContains(g, "a", "j"));
        System.out.println(search.graphContains(g, "f", "p"));
        System.out.println(search.graphContains(g, "x", "j"));


    }
}
