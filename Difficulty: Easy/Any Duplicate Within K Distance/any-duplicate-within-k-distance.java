class Solution {
    public boolean checkWithinK(int[] arr, int k) {
        HashSet<Integer> seen = new HashSet<>();
        for(int i=0;i<arr.length;i++) {
            if(seen.contains(arr[i])) {
                return true;
            }
            seen.add(arr[i]);
            if(seen.size() > k) {
                seen.remove(arr[i-k]);
            }
        }
        return false;
    }
}