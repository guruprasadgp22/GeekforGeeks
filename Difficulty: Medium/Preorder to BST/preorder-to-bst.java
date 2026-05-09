/* class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

class Solution {

    // Function that constructs BST from its preorder traversal.
    public Node preToBST(int pre[]) {
        // code here
        return helper(pre, Integer.MAX_VALUE);
    }
    
    int index = 0;
    public Node helper(int[] arr, int bound) {
        if(index >= arr.length || arr[index] > bound) {
            return null;
        }
        
        Node root = new Node(arr[index]);
        index++;
        
        root.left = helper(arr, root.data);
        root.right = helper(arr, bound);
        
        return root;
    }
}