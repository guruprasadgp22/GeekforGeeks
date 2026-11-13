/* Structure of a Binary Search Tree node
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
    HashSet<Integer> set1 = new HashSet<>();
    HashSet<Integer> set2 = new HashSet<>();
    public ArrayList<Integer> findCommon(Node r1, Node r2) {
        inOrder1(r1);
        inOrder2(r2);
        
        ArrayList<Integer> res = new ArrayList<>();
        for(int ele: set1) {
            if(set2.contains(ele)) {
                res.add(ele);
            }
        }
        
        Collections.sort(res);
        return res;
    }
    
    private void inOrder1(Node root) {
        if(root == null) {
            return;
        }
        inOrder1(root.left);
        set1.add(root.data);
        inOrder1(root.right);
    }
    
    private void inOrder2(Node root) {
        if(root == null) {
            return;
        }
        
        inOrder2(root.left);
        set2.add(root.data);
        inOrder2(root.right);
    }
}