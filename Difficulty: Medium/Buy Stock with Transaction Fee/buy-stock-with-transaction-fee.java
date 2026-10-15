class Solution {
    public int maxProfit(int arr[], int k) {
        int n = arr.length;
        int[][] dp = new int[n][2];
        for(int i=n-1;i>=0;i--) {
            dp[i][1] = Math.max((i+1 < n? dp[i+1][0]: 0) - arr[i], (i+1 < n? dp[i+1][1]: 0));
            dp[i][0] = Math.max((i+1 < n? dp[i+1][1]: 0) + arr[i] - k, (i+1 < n? dp[i+1][0]: 0));
        }
        
        return dp[0][1];
    }
}