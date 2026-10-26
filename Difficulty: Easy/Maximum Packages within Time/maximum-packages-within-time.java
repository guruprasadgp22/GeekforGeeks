class Solution {
    public int maxPackages(int[] arr, int totalTime) {
        int sum = 0;
        int n = arr.length;
        for(int i=0;i < n && i<totalTime;i++) {
            sum += arr[i];
        }
        
        if(n <= totalTime) {
            return sum;
        }
        int maxSum = sum;
        
        for(int i=totalTime;i<n;i++) {
            sum += arr[i] - arr[i-totalTime];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}