import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        if(!wordList.contains(beginWord)) wordList.add(beginWord);
        Map<String,List<String>> adjacencyMatrix = getAdjacencyMatrix(wordList);
        if(!adjacencyMatrix.containsKey(beginWord) || !adjacencyMatrix.containsKey(endWord)) return 0;
        Map<String, Integer> distances = new HashMap<>();
        bfsShortestPath(adjacencyMatrix, distances, beginWord, endWord);
        return distances.get(endWord)==0? 0 : distances.get(endWord)+1;
    }

    private void bfsShortestPath(Map<String, List<String>> adjacencyMatrix, Map<String, Integer> distances, String beginWord, String endWord) {
        for(String s: adjacencyMatrix.keySet()){
            distances.put(s,0);
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visited.add(beginWord);

        while (!queue.isEmpty()){
            String word = queue.poll();
            if(adjacencyMatrix.get(word)==null) continue;
            for(String s: adjacencyMatrix.get(word)){
                if(!visited.contains(s)){
                    visited.add(s);
                    queue.add(s);
                    int temp = distances.get(word);
                    distances.put(s, temp+1);
                    if(s.equals(endWord)) return;
                }
            }
        }
    }

    public Map<String, List<String>> getAdjacencyMatrix(List<String> dict){
        Map<String, List<String>> result = new HashMap<>();
        for(String word: dict){
            for(String w: dict){
                if(w.equals(word)) continue;
                if(hasAnEdge(w, word)){
                    if(result.containsKey(word)){
                        result.get(word).add(w);
                    }else {
                        List<String> temp = new ArrayList<>();
                        temp.add(w);
                        result.put(word, temp);
                    }
                }
            }
        }
        return result;
    }

    private boolean hasAnEdge(String w, String word) {
        int count=0;
        for(int i=0; i<w.length();++i){
            if(count>1) return false;
            if(w.charAt(i)!=word.charAt(i)) ++count;
        }
        return count==1;
    }

    public static void main(String[] args) {
        List<String> test = new ArrayList<>(Arrays.asList("hit","hot", "dot", "dog", "lot", "log", "cog"));
        List<String> test2 = new ArrayList<>(Arrays.asList("hot", "dot", "tog", "cog"));
        List<String> test3 = new ArrayList<>(Arrays.asList("hot","dog"));
        WordLadder ladder = new WordLadder();
        System.out.println(ladder.ladderLength("hit", "cog", test));
        System.out.println(ladder.ladderLength("hit", "cog", test2));
        System.out.println(ladder.ladderLength("hot", "dog", test3));

    }
}
