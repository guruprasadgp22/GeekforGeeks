class Solution {
    
    HashSet<ArrayList<Integer>> unique = new HashSet<>();
    
    public ArrayList<ArrayList<Integer>> targetSumComb(int[] arr, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        int index = 0;
        int n = arr.length;
        
        combSum(arr, n, target, index, result, current);
        
        return result;
        
    }
    
    public void combSum(int[] arr, int n, int k, int index, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> current) {
        if(k == 0) {
            if(!unique.contains(current)) {
                unique.add(new ArrayList<>(current));
                result.add(new ArrayList<>(current));
            }
            
            return;
        }
        
        if(k < 0 || index == n) {
            return;
        }
        
        current.addLast(arr[index]);
        combSum(arr, n, k - arr[index], index+1, result, current);
        combSum(arr, n, k - arr[index], index, result, current);
        current.removeLast();
        combSum(arr, n, k, index+1, result, current);
    }
}