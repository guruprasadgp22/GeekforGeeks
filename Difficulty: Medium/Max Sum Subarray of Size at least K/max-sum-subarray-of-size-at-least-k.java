class Solution {
    public int maxSumWithK(int[] arr, int k) {
        int n = arr.length;
        
        int[] best = new int[n];
        best[0] = arr[0];
        for(int i=1;i<n;i++) {
            best[i] = Math.max(arr[i], arr[i]+best[i-1]);
        }
        
        int currentSum = 0;
        for(int i=0;i<k;i++) {
            currentSum += arr[i];
        }
        
        int max = currentSum;
        
        for(int i=k;i<arr.length;i++) {
            currentSum += arr[i] - arr[i-k];
            max = Math.max(currentSum, max);
            
            int index = i - k;
            max = Math.max(max, currentSum + best[index]);
        }
        
        return max; 
    }
}