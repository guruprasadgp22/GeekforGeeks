/* Structure of binary tree node
class Node{
    int data;
    Node left, right;
    Node(int val){
        data = val;
        left = right = null;
    }
}*/

class Solution {
    int maxSum;
    int findMaxSum(Node root) {
        // code here
        maxSum = Integer.MIN_VALUE;
        solve(root);
        return maxSum;
    }
    
    private int solve(Node root) {
        if(root == null) {
            return 0;
        }
        
        int left = solve(root.left);
        int right = solve(root.right);
        
        int all = left + right + root.data;
        int skip = Math.max(left, right) + root.data;
        int skipBoth = root.data;
        
        maxSum = Math.max(maxSum, Math.max(all, Math.max(skip, skipBoth)));
        
        return Math.max(skip, skipBoth);
    }
}