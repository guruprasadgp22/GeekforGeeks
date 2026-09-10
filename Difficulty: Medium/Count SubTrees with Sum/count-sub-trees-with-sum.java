/* Structure of tree node
class Node
{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/

class Solution {
    int result;
    int countSubtrees(Node root, int x) {
        result = 0;
        postOrder(root,x);
        return result;
    }
    
    private int postOrder(Node root, int x) {
        if(root == null) {
            return 0;
        }
        
        int left = postOrder(root.left, x);
        int right = postOrder(root.right, x);
        if(left + right + root.data == x) {
            result++;
        }
        
        return left + right + root.data;
    }
}