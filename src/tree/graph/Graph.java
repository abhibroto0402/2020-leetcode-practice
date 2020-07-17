package tree.graph;

import java.util.*;
public class Graph{
    HashMap<String, LinkedList<String>> map = new HashMap<>();
    public void addEdge(String src, String dest ){
        if(!map.containsKey(src)){
            LinkedList<String> l = new LinkedList<>();
            l.add(dest);
            map.put(src, l);
        }
        else{
            LinkedList<String> l = map.get(src);
            l.add(dest);
            map.put(src,l);
        }
    }
    public boolean isConnected(String src, String dest){
        if(!map.containsKey(src)) return false;
        LinkedList<String> l = map.get(src);
        return l.contains(dest);
    }
    public int getNumberOfVertices(){
        return map.size();
    }
    public LinkedList<String> getAdjacentVertices(String vertex){
        if(!map.containsKey(vertex)) return null;
        if(map.get(vertex).isEmpty()){
            return null;
        }
        return map.get(vertex);
    }
    public boolean hasVertex(String vertex){
        return map.containsKey(vertex);
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(String c: map.keySet()){
            sb.append(c+": "+ map.get(c) +"\n");
        }
        return sb.toString();
    }
    public static void main(String [] args){
        Graph g= new Graph();
        g.addEdge("a","k");
        g.addEdge("a","s");
        g.addEdge("a","f");
        g.addEdge("b","s");
        g.addEdge("b","j");
        g.addEdge("k","j");
        System.out.println(g);
        System.out.println(g.isConnected("a", "b"));
        System.out.println(g.isConnected("a", "s"));
    }
}
