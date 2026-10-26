class Solution {
    public int maxIncSubarraySum(int arr[]) {
        int curr = arr[0];
        int max = curr;
        int n = arr.length;
        for(int i=1;i<n;i++) {
            if(arr[i] > arr[i-1]) {
                curr+= arr[i];
            } else {
                curr = arr[i];
            }
            
            max = Math.max(curr, max);
        }
        return max;
    }
}