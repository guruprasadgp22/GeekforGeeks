/*
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
        if(root == null) {
            return new ArrayList<>();   
        }
        
        ArrayList<Node> list = new ArrayList<>();
        Node prec = null;
        Node succ = null;
        
        Node curr = root;
        
        while(curr != null) {
            if(key < curr.data) {
                succ = curr;
                curr = curr.left;
            } else if(key > curr.data) {
                prec = curr;
                curr = curr.right;
            } else {
                if(curr.left != null) {
                    prec = leftMostRight(curr.left);
                }
                
                if(curr.right != null) {
                    succ = rightMostLeft(curr.right);
                }
                
                break;
            }
        }
        
        list.add(prec);
        list.add(succ);
        
        return list;
    }
    
    private Node leftMostRight(Node root) {
        Node ans = null;
        
        while(root != null) {
            ans = root;
            root = root.right;
        }
        
        return ans;
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