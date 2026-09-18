class Solution {
    int[][] dp;
    public int maxSumIS(int arr[]) {
        int n = arr.length;
        dp = new int[n+1][n+1];
        for(int[] x: dp) {
            Arrays.fill(x, -1);
        }
        
        
        int i = 0;
        int prevI = -1;
        
        return solve(i, prevI, arr);
    }
    
    private int solve(int i, int prevI, int[] arr) {
        if(i >= arr.length) {
            return 0;
        }
        
        int prev = prevI + 1;
        if(dp[i][prev] != -1) {
            return dp[i][prev];
        }
        
        int skip = solve(i+1, prevI, arr);
        
        int take = 0;
        if(prevI == -1 || arr[i] > arr[prevI]) {
            take += arr[i] + solve(i+1, i, arr);
        }
        
        return dp[i][prev] = Math.max(skip, take);
    }
}