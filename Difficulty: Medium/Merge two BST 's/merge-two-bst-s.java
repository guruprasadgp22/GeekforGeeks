/*
class Node {
    int data;
    Node left, right;

    public Node(int val)
    {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    int i = 0;
    public ArrayList<Integer> merge(Node root1, Node root2) {
        // code here
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        inOrder(root1, arr1);
        i = 0;
        inOrder(root2, arr2);
        
        int a = 0;
        int b = 0;
        ArrayList<Integer> list = new ArrayList<>();
        
        while(a < arr1.size() && b < arr2.size()) {
            if(arr1.get(a) < arr2.get(b)) {
                list.add(arr1.get(a));
                a++;
            } else {
                list.add(arr2.get(b));
                b++;
            }
        }
        
        while(a < arr1.size()) {
            list.add(arr1.get(a));
            a++;
        }
        
        while(b < arr2.size()) {
            list.add(arr2.get(b));
            b++;
        }
        
        return list;
    }
    public void inOrder(Node root, ArrayList<Integer> arr) {
        if(root == null) {
            return;
        }
        
        inOrder(root.left, arr);
        arr.add(root.data);
        inOrder(root.right, arr);
    }
}