class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int arr[]) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> curr = new LinkedList<>();
        int i = 0;
        
        subset(arr, i, ans, curr);
        return ans;
    }
    
    public void subset(int[] arr, int i, ArrayList<ArrayList<Integer>> ans, LinkedList<Integer> curr) {
        if(i == arr.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        curr.addLast(arr[i]);
        subset(arr, i+1, ans, curr);
        
        curr.removeLast();
        subset(arr, i+1, ans, curr);
    }
}