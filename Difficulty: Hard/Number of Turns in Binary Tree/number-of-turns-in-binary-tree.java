/* Structure of Binary Tree Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    public int numberOfTurns(Node root, int p, int q) {
        // code here
        
        Node lca = LCA(root, p, q);
        
        StringBuilder pathP = new StringBuilder();
        findPath(lca, p, pathP);
        
        StringBuilder pathQ = new StringBuilder();
        findPath(lca, q, pathQ);
        
        String str = pathP.reverse().toString() + pathQ.toString();
        int turnsCount = 0;
        
        for(int i=1;i<str.length();i++) {
            if(str.charAt(i) != str.charAt(i-1)) {
                turnsCount++;
            }
        }
        
        return turnsCount == 0? -1: turnsCount;
        
    }
    
    private Node LCA(Node root, int p, int q) {
        if(root == null) {
            return null;
        }
        
        if(root.data == p || root.data == q) {
            return root;
        }
        
        Node leftLCA = LCA(root.left, p, q);
        Node rightLCA = LCA(root.right, p, q);
        
        if(leftLCA != null && rightLCA != null) {
            return root;
        } else if(leftLCA != null) {
            return leftLCA;
        } else {
            return rightLCA;
        }
    }
    
    private boolean findPath(Node root, int target, StringBuilder path) {
        if(root == null) {
            return false;
        }
        
        if(root.data == target) {
            return true;
        }
        
        path.append("L");
        if(findPath(root.left, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length()-1);
        
        path.append("R");
        if(findPath(root.right, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        
        return false;
    }
}