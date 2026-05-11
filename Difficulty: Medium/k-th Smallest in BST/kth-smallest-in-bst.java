/*
class Node {
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    int prevOrder = 0;
    public int kthSmallest(Node root, int k) {
        // code here
        if(root == null) {
            return -1;
        }
        
        if(root.left != null) { 
            int leftKey = kthSmallest(root.left, k);
            
            if(leftKey != -1) {
                return leftKey;
            }
        }
        
        if(prevOrder + 1 == k) {
            return root.data;
        }
        
        prevOrder += 1;
        
        if(root.right != null) { 
            int rightKey = kthSmallest(root.right, k);
            
            if(rightKey != -1) {
                return rightKey;
            }
        }
        
        return -1;
    }
}