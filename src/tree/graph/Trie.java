package tree.graph;

/**
 * This implementation can index all characters (except '/'), lower and upper case would be considered separately.
 * It is memory intensive since it's general purpose
 */

public class Trie {

    TrieNode root;

    public TrieNode insert(String s) {
        if (root == null) {
            root = new TrieNode('/', false);
        }
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
        return root;
    }

    public boolean search(String word) {
        if (root == null) return false;
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            if (!temp.children.containsKey(word.charAt(i))) return false;
            temp = temp.children.get(word.charAt(i));
        }
        return temp.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for (int i = 0; i < prefix.length() && temp != null; i++) {
            if (!temp.children.containsKey(prefix.charAt(i))) return false;
            temp = temp.children.get(prefix.charAt(i));
        }
        return temp != null;
    }


    @Override
    public String toString() {
        if (root == null) return "null";
        return root.children.keySet().toString();
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println(trie.insert("cap"));
        System.out.println(trie.insert("car"));
        System.out.println(trie.insert("pen"));
        System.out.println(trie.insert("a"));
        System.out.println(trie.insert("ab"));
        System.out.println(trie.root.children.get('c').children.get('a'));
        System.out.println(trie.search("care"));//false
        System.out.println(trie.search("pen"));//true
        System.out.println(trie.startsWith("ca"));//true
        System.out.println(trie.startsWith("a"));//true
        System.out.println(trie.startsWith("cap")); //true
        System.out.println(trie.search("book"));//false

    }
}
