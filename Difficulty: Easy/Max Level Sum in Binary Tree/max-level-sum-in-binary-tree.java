/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        this.data = val;
        left = right = null;
    }
}
*/

class Solution {
    HashMap<Integer, Integer> map;
    public int maxLevelSum(Node root) {
        // code here
        
        map = new HashMap<>();
        solve(root, 0);
        
        int max = Integer.MIN_VALUE;
        
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(max < entry.getValue()) {
                max = entry.getValue();
            }
        }
        
        return max;
    }
    
    private void solve(Node root, int depth) {
        if(root == null) {
            return;
        }
        
        if(map.containsKey(depth)) {
            int sum = map.get(depth) + root.data;
            map.put(depth, sum);
        } else {
            map.put(depth, root.data);
        }
        
        solve(root.left, depth+1);
        solve(root.right, depth+1);
    }
}