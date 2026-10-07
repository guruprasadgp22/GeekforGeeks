/* Node Structure
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */
class Solution {
    int maxSum;
    int leafCount;
    public int maxPathSum(Node root) {
        if(root == null) {
            return -1;
        }
        
        maxSum = Integer.MIN_VALUE;
        leafCount = 0;
        
        DFS(root);
        if(leafCount < 2) {
            return -1;
        }
        
        return maxSum;
    }
    
    private int DFS(Node root) {
       if(root.left == null && root.right == null) {
           leafCount++;
           return root.data;
       }
       
       if(root.left == null) {
           return root.data + DFS(root.right);
       }
       
       if(root.right == null) {
           return root.data + DFS(root.left);
       }
       
       int left = DFS(root.left);
       int right = DFS(root.right);
       
       maxSum = Math.max(maxSum, left + right + root.data);
       
       return Math.max(left, right) + root.data;
    }
}