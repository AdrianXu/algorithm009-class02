class Trie {
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word = null;
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(Character c: word.toCharArray()){
            if(node.next[c - 'a'] == null){
                node.next[c - 'a'] = new TrieNode(); 
            }
            node = node.next[c - 'a'];
        }
        node.word = word;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for(Character c: word.toCharArray()){
            if(node.next[c - 'a'] != null){
                node = node.next[c - 'a'];
            }else{
                return false;
            }
        }
        if(node.word != null){
            return true;
        }
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(Character c: prefix.toCharArray()){
            if(node.next[c - 'a'] != null){
                node = node.next[c - 'a'];
            }else{
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */