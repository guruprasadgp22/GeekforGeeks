// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Info {
    int min;
    int max;
    int size;
    
    Info(int min, int max, int size) {
        this.min = min;
        this.max = max;
        this.size = size;
    }
}

class Solution {
    
    static Info helper(Node root) {
        if(root == null) {
            return new Info(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        
        Info left = helper(root.left);
        Info right = helper(root.right);
        
        if(root.data > left.max && root.data < right.min) {
            int currMin = Math.min(root.data, left.min);
            int currMax = Math.max(root.data, right.max);
            int currSize = left.size + right.size + 1;
            
            return new Info(currMin, currMax, currSize);
        }
        
        return new Info(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.size, right.size));
    }
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root) {
        // Write your code here
        Info info = helper(root);
        return info.size;
    }
}