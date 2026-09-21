/* Structure of binary tree Node
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
    public boolean areAnagrams(Node root1, Node root2) {
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        
        q1.add(root1);
        q2.add(root2);
        
        while(!q1.isEmpty() && !q2.isEmpty()) {
            int size1 = q1.size();
            int size2 = q2.size();
            
            if(size1 != size2) {
                return false;
            }
            
            HashMap<Integer, Integer> map1 = new HashMap<>();
            HashMap<Integer, Integer> map2 = new HashMap<>();
            
            for(int i=0;i<size1;i++) {
                Node curr1 = q1.poll();
                map1.put(curr1.data, map1.getOrDefault(curr1.data, 0) + 1);
                
                if(curr1.left != null) {
                    q1.add(curr1.left);
                }
                
                if(curr1.right != null) {
                    q1.add(curr1.right);
                }
                
                Node curr2 = q2.poll();
                map2.put(curr2.data, map2.getOrDefault(curr2.data, 0) + 1);
                
                if(curr2.left != null) {
                    q2.add(curr2.left);
                }
                
                if(curr2.right != null) {
                    q2.add(curr2.right);
                }
            }
            
            if(!map1.equals(map2)) {
                return false;
            }
        }
        
        if(q1.size()> 0 || q2.size() > 0) {
            return false;
        }
        
        return true;
    }
}
