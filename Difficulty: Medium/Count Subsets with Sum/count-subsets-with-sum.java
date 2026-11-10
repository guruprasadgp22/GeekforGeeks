class Solution {
    int[][] dp;
    int perfectSum(int[] arr, int target) {
        dp = new int[arr.length][target+1];
        for(int[] x: dp) {
            Arrays.fill(x, -1);
        }
        return solve(0, target, arr);
    }
    
    private int solve(int i, int target, int[] arr) {
        if(i == arr.length) {
            return target == 0? 1: 0;
        }
        if(target < 0) {
            return 0;
        }
        
        if(dp[i][target] != -1) {
            return dp[i][target];
        }
        
        int skip = solve(i+1, target, arr);
        int take = solve(i+1, target - arr[i], arr);
        
        return dp[i][target] = skip + take;
    }
}