/*
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    public int leftLeavesSum(Node root) {
        // code here
        return solve(root, false);
    }
    
    private int solve(Node root, boolean isLeft) {
        if(root == null) {
            return 0;
        }
        
        if(root.left == null && root.right == null && isLeft) {
            return root.data;
        }
        
        return solve(root.left, true) + solve(root.right, false);
    }
}
