/* Structure of Binary Tree Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = this.right = null;
    }
}*/

class Solution {
    ArrayList<Integer> result;
    public ArrayList<Integer> leftView(Node root) {
        // code here
        result = new ArrayList<>();
        solve(root, 0);
        return result;
    }
    
    private void solve(Node root, int depth) {
        if(root == null) {
            return;
        }
        
        if(result.size() == depth) {
            result.add(root.data);
        }
        
        solve(root.left, depth + 1);
        solve(root.right, depth + 1);
    }
}