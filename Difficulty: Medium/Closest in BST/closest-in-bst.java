/* Structure of a Binary Search Tree node
class Node {
    int data;
    Node left, right;

    public Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public int minDiff(Node root, int k) {
        return solve(root, k);
    }
    
    private int solve(Node root, int k) {
        if(root == null) {
            return Integer.MAX_VALUE;
        }
        
        int left = solve(root.left, k);
        int right = solve(root.right, k);
        return Math.min(Math.abs(root.data - k), Math.min(left, right));
    }
}