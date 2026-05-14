/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    Node first = null;
    Node sec = null;
    Node prev = null;
    void correctBST(Node root) {
        // code here.
        inOrder(root);
        int temp = first.data;
        first.data = sec.data;
        sec.data = temp;
    }
    
    void inOrder(Node root) {
        if(root == null) {
            return;
        }
        
        inOrder(root.left);
        
        if(prev != null && root.data < prev.data) {
            if(first == null) {
                first = prev;
            }
            
            sec = root;
        }
        
        prev = root;
        inOrder(root.right);
    }
}