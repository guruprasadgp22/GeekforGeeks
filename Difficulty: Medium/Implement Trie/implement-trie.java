// User function Template for Java
class Trie {
    Trie children[];
    boolean eow;
    
    Trie root;
    
    public Trie() {
        // Implement Trie
        children = new Trie[26];
        
        for(int i=0;i<26;i++) {
            children[i] = null;
        }
        
        eow = false;
    }

    // Insert a word into the Trie
    public void insert(String word) {
        Trie curr = this;
        
        for(int i=0;i<word.length();i++) {
            int index = word.charAt(i) - 'a';
            
            if(curr.children[index] == null) {
                curr.children[index] = new Trie();
            }
            
            curr = curr.children[index];
        }
        
        curr.eow = true;
    }

    // Search for a word in the Trie
    public boolean search(String word) {
        Trie curr = this;
        
        for(int i=0;i<word.length();i++) {
            int index = word.charAt(i) - 'a';
            
            if(curr.children[index] == null) {
                return false;
            }
            
            curr = curr.children[index];
        }
        
        return curr.eow;
    }

    // Check if a prefix exists in the Trie
    public boolean isPrefix(String word) {
        Trie curr = this;
        
        for(int i=0;i<word.length();i++) {
            int index = word.charAt(i) - 'a';
            
            if(curr.children[index] == null) {
                return false;
            }
            
            curr = curr.children[index];
        }
        
        return true;
    }
}