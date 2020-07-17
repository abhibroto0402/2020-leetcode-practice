package tree.graph;

import java.util.*;
public class DFS {
    boolean found;
    public boolean graphContains(Graph g, String src, String element){
        this.found=false;
        if(!g.hasVertex(src)) {
            return false;
        }
        Set<String> visited = new HashSet<>();
        searchElement(g, src, visited, element);
        return found;
    }
    public void searchElement(Graph g, String src, Set<String> visited, String element){
        visited.add(src);
        LinkedList<String> list = g.getAdjacentVertices(src);
        if(list==null) {
            return;
        }
        ListIterator<String> iterator = list.listIterator();
        while(iterator.hasNext() && !found){
            String s = iterator.next();
            if(s.equals(element)) {
                this.found=true;
            }
            if(!visited.contains(s)){
                visited.add(s);
                if(g.getAdjacentVertices(s)!=null){
                    searchElement(g, s, visited, element);
                }
            }
        }
    }
    public static void main(String [] args){
        Graph g= new Graph();
        g.addEdge("a","k");
        g.addEdge("a","b");
        g.addEdge("f","b");
        g.addEdge("a","s");
        g.addEdge("a","f");
        g.addEdge("b","s");
        g.addEdge("b","j");
        g.addEdge("k","j");
        DFS search = new DFS();
        System.out.println(g);
        System.out.println(search.graphContains(g, "a", "b"));
        System.out.println(search.graphContains(g, "a", "j"));
        System.out.println(search.graphContains(g, "f", "p"));
        System.out.println(search.graphContains(g, "x", "j"));
    }
}