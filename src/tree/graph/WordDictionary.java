package tree.graph;

class WordDictionary {

    TrieNode root;
    public WordDictionary() {
        this.root = new TrieNode('/', false);
    }

    public void addWord(String s) {
        if(s.equals("")) return;
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

    public boolean search(String word) {
        return searchInNode(word, root);
    }

    public boolean searchInNode(String word, TrieNode node) {
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            if (!node.children.containsKey(ch)) {
                // if the current character is '.'
                // check all possible nodes at this level
                if (ch == '.') {
                    for (char x : node.children.keySet()) {
                        TrieNode child = node.children.get(x);
                        if (searchInNode(word.substring(i + 1), child)) {
                            return true;
                        }
                    }
                }
                // if no nodes lead to answer
                // or the current character != '.'
                return false;
            } else {
                // if the character is found
                // go down to the next level in trie
                node = node.children.get(ch);
            }
        }
        return node.isEnd;
    }

    public static void main(String[] args) {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("bad");
        dictionary.addWord("dad");
        dictionary.addWord("mad");


    }
}
