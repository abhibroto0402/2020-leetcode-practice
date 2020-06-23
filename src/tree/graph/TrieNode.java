package tree.graph;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEnd;
    Character val;

    TrieNode(Character val, Boolean isEnd) {
        this.val = val;
        this.isEnd = isEnd;
        this.children = new HashMap<>();
    }

    @Override
    public String toString() {
        return "Children: " + children.keySet().toString() + "; Val: " + val + "; IsEnd: "+ isEnd ;
    }
}
