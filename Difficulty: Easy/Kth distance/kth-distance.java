class Solution {
    public boolean checkDuplicatesWithinK(int[] arr, int k) {
        // your code
        HashSet<Integer> window = new HashSet<>();
        for(int i=0;i<arr.length;i++) {
            if(window.contains(arr[i])) {
                return true;
            }
            window.add(arr[i]);
            if(window.size() > k) {
                window.remove(arr[i-k]);
            }
        }
        
        return false;
    }
}