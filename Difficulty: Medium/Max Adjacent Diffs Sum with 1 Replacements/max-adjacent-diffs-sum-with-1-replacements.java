class Solution {
    int[][] dp;
    public int maxDiffSum(int[] arr) {
        int n = arr.length;
        int maxVal = Integer.MIN_VALUE;
        for(int ele: arr) {
            maxVal = Math.max(maxVal, ele);
        }
        
        dp = new int[n+1][maxVal+1];
        for(int[] x: dp) {
            Arrays.fill(x, -1);
        }
        
        int index =1;
        int keep = solve(index, arr[0], arr);
        int replace = solve(index, 1, arr);
        
        return Math.max(keep, replace);
    }
    
    private int solve(int index, int prev, int[] arr) {
        if(index == arr.length) {
            return 0;
        }
        
        if(dp[index][prev] != -1) {
            return dp[index][prev];
        }
        
        int keep = Math.abs(prev - arr[index]) + solve(index+1, arr[index], arr);
        int replace = Math.abs(prev - 1) + solve(index+1, 1, arr);
        
        return dp[index][prev] = Math.max(keep, replace);
    }
}