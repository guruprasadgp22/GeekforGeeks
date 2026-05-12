/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public boolean isBST(Node root) {
        // code here
        return checkForBST(root, null, null);
    }
    
    public boolean checkForBST(Node root, Node min, Node max) {
        if(root == null) {
             return true;
        }
        
        if(min != null && root.data <= min.data) {
            return false;
        }
        
        if(max != null && root.data >= max.data) {
            return false;
        }
        
        return checkForBST(root.left, min, root) && checkForBST(root.right, root, max);
    }
}