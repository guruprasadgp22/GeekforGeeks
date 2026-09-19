/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> result;
    public ArrayList<Integer> rightView(Node root) {
        // code here
        result = new ArrayList<>();
        solve(root, 0);
        return result;
    }
    
    private void solve(Node root, int depth) {
        if(root == null) {
            return;
        }
        
        if(depth == result.size()) {
            result.add(root.data);
        }
        
        solve(root.right, depth + 1);
        solve(root.left, depth + 1);
    }
}