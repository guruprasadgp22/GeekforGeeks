class Solution {
    public ArrayList<ArrayList<Integer>> findSubsets(int[] arr) {
        // code here
        Arrays.sort(arr);
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        LinkedList<Integer> curr = new LinkedList<>();
        int i = 0;
        
        subset(arr, i, res, curr);
        
        return res;
    }
    
    public void subset(int[] arr, int i, ArrayList<ArrayList<Integer>> res, LinkedList<Integer> curr) {
        if(i == arr.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        
        curr.addLast(arr[i]);
        subset(arr, i+1, res, curr);
        
        curr.removeLast();
        int index = i + 1;
        
        while(index < arr.length && arr[index] == arr[index-1]) {
            index++;
        }
        
        subset(arr, index, res, curr);
    }
}
