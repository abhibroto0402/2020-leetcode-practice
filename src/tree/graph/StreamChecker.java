package tree.graph;

import java.util.HashMap;
import java.util.Map;

class StreamChecker {
    class TrieNode{
        Map<Character, TrieNode> children;
        boolean isEnd;
        Character val;

        TrieNode(Character val, Boolean isEnd) {
            this.val = val;
            this.isEnd = isEnd;
            this.children = new HashMap<>();
        }
    }
    TrieNode root = new TrieNode('/', false);
    TrieNode pointer = root;

    public StreamChecker(String[] words) {
        for(String s: words){
            if (!root.children.containsKey(s.charAt(0))) {
                root.children.put(s.charAt(0), new TrieNode(s.charAt(0), false));
            }
            TrieNode temp = root.children.get(s.charAt(0));
            for (int i = 1; i < s.length(); i++) {
                if (!temp.children.containsKey(s.charAt(i))) {
                    temp.children.put(s.charAt(i), new TrieNode(s.charAt(i), false));
                }
                temp = temp.children.get(s.charAt(i));
            }
            temp.isEnd = true;
        }

    }

    public boolean query(char letter) {
        if(pointer.children.containsKey(letter)){
            pointer=pointer.children.get(letter);
            if(pointer.isEnd){
                pointer=root;
                return true;
            }
            return false;
        }
        pointer=root;
        return false;
    }
}
