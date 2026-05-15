/*
Definition for Node
class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int val) {
        data = val;
        left = right = null;
    }
};
*/

class Solution {
    public int inOrderSuccessor(Node root, Node k) {
        // code here
        if(root == null) {
            return -1;
        }
        
        Node succ = null;
        Node curr = root;
        
        while(curr != null) {
            if(k.data < curr.data) {
                succ = curr;
                curr = curr.left;
            } else if(k.data > curr.data) {
               curr = curr.right;
            } else {
                
                if(curr.right != null) {
                    succ = rightMostLeft(curr.right);
                }
                
                break;
            }
        }
        
        return succ == null ? -1: succ.data;
    }
    
    private Node rightMostLeft(Node root) {
        Node ans = null;
        
        while(root != null) {
            ans = root;
            root = root.left;
        }
        
        return ans;
    }
}