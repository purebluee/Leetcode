class TrieNode {
    // Initialize your data structure here.
    TrieNode[] children;
    char val;
    boolean leaf;
    
    TrieNode(char val, boolean leaf){
        this.val = val;
        this.leaf = leaf;
        children = new TrieNode[26];
    }
    
    TrieNode(){
        val = '\0';
        children = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        char[] wordArr = word.toCharArray();
        int len = word.length();
        TrieNode curr = root;
        for (int i = 0; i < len; i++){
            if (curr.children[wordArr[i] - 'a'] == null){
                curr.children[wordArr[i] - 'a'] = new TrieNode(wordArr[i], 
                i == len - 1 ? true : false);
            }else if (i == len - 1){
                curr.children[wordArr[i] - 'a'].leaf = true;
            }
            curr = curr.children[wordArr[i] - 'a'];
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        char[] wordArr = word.toCharArray();
        int len = wordArr.length;
        TrieNode curr = root;
        for (int i = 0; i < len; i++){
            if (curr.children[wordArr[i] - 'a'] == null){
                return false;
            }
            curr = curr.children[wordArr[i] - 'a'];
        }
        if (curr != null && !curr.leaf){
            return false;
        }
        return true;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        char[] prefixArr = prefix.toCharArray();
        int len = prefix.length();
        TrieNode curr = root;
        for (int i = 0; i < len; i++){
            if (curr.children[prefixArr[i] - 'a'] == null){
                return false;
            }
            curr = curr.children[prefixArr[i] - 'a'];
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");