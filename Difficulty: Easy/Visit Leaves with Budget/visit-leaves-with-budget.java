/* Binary Tree Node Structure
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    public int getCount(Node root, int k) {
       int[] freq = new int[k+1];
       
       DFS(root, 1, k, freq);
       
       int ans = 0;
       int budget = k;
       
       for(int i=1;i<=k;i++) {
           int count = freq[i];
           while(count > 0 && budget >= i) {
               ans++;
               budget -= i;
               count--;
           }
       }
       
       return ans;
    }
    
    private void DFS(Node root, int level, int k, int[] freq) {
        if(root == null) {
            return;
        }
        
        if(level > k) {
            return;
        }
        
        if(root.left == null && root.right == null) {
            freq[level]++;
            return;
        }
        
        DFS(root.left, level+1, k, freq);
        DFS(root.right, level + 1, k, freq);
    }
}