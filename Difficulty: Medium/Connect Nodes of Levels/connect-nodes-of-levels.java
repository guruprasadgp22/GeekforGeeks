/*
   class Node{
       int data;
       Node left;
       Node right;
       Node nextRight;
       Node(int data){
           this.data = data;
           left=null;
           right=null;
           nextRight = null;
       }
   }

   */

class Solution {
    public Node connect(Node root) {
        // code here.
        
        if(root == null) {
            return null;
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        
        Node prev = null;
        
        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            
            if(curr == null) {
                if(queue.size() == 0) {
                    break;
                }
                
                queue.add(null);
            } else {
                if(curr.left != null) {
                    queue.add(curr.left);
                }
                
                if(curr.right != null) {
                    queue.add(curr.right);
                }
                
                if(prev != null) {
                    prev.nextRight = curr;
                }
            }
            
            prev = curr;
        }
        
        return root;
    }
}