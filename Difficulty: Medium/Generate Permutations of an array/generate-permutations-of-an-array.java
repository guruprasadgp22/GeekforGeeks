class Solution {
    public ArrayList<ArrayList<Integer>> permuteDist(int[] arr) {
        // code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int index = 0;
        
        permutation(arr, index, result);
        return result;
    }
    
    public void permutation(int[] arr, int index, ArrayList<ArrayList<Integer>> result) {
        if(index == arr.length) {
            ArrayList<Integer> ans = new ArrayList<>();
            for(int ele: arr) {
                ans.add(ele);
            }
            
            result.add(ans);
            return;
        }
        
        for(int i=index;i<arr.length;i++) {
            swap(arr, index, i);
            permutation(arr, index+1, result);
            swap(arr, index, i);
        }
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
};