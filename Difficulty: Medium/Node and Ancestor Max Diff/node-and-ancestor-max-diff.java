/* Structure of binary tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Solution {
    int max = Integer.MIN_VALUE;
    int maxDiff(Node root) {
		maximumDifference(root.left, root.data);
		maximumDifference(root.right, root.data);
		
		return max;
    }
    
    private void maximumDifference(Node root, int maxAncestor) {
		if(root == null) {
			return;
		}
        
        max = Math.max(max, maxAncestor - root.data);
        maxAncestor = Math.max(maxAncestor, root.data);
        
        maximumDifference(root.left, maxAncestor);
        maximumDifference(root.right, maxAncestor);
	}
}