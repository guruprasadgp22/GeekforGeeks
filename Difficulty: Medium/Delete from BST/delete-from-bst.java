/* Structure of a Binary Search Tree node
class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int val) {
        data = val;
        left = right = null;
    }
}; */

class Solution {
    public Node delNode(Node root, int x) {
        if(root == null) {
            return root;
        }
        
        if(x < root.data) {
            root.left = delNode(root.left, x);
        } else if(x > root.data) {
            root.right = delNode(root.right, x);
        } else {
            if(root.left == null) {
                return root.right;   
            } else if(root.right == null) {
                return root.left;
            } else {
                root.data = minVal(root.right);
                root.right = delNode(root.right, root.data);
            }
        }
        
        return root;
    }
    
    private int minVal(Node root) {
        int min = root.data;
        
        while(root.left != null) {
            min = root.left.data;
            root = root.left;
        }
        
        return min;
    }
}