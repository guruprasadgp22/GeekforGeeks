class Node {
    Node[] children;
    boolean eow;
    
    Node() {
        children = new Node[26];
        
        for(int i=0;i<26;i++) {
            children[i] = null;
        }
        
        eow = false;
    }
}

class Solution {
    static Node root;
    
    public static void insert(String word) {
        Node curr = root;
        
        for(int i=0;i<word.length();i++) {
            int index = word.charAt(i) - 'a';
            if(curr.children[index] == null) {
                curr.children[index] = new Node();
            }
            
            curr = curr.children[index];
        }
        
        curr.eow = true;
    }
    
    public static int countSubs(String s) {
        // code here
        root = new Node();
        for(int i=0;i<s.length();i++) {
            String suffix = s.substring(i);
            insert(suffix);
        }
        
        return counting(root) - 1;
    }
    
    public static int counting(Node root) {
        if(root == null) {
            return 0;
        }
        int count = 0;
        for(int i=0;i<26;i++) {
            if(root.children[i] != null) {
                count += counting(root.children[i]);
            }
        }
        
        return count + 1;
    }
}