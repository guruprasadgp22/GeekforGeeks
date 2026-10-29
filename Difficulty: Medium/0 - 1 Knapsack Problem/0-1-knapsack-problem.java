class Solution {
    int n;
    int[][] dp;
    public int knapsack(int W, int val[], int wt[]) {
        n = val.length;
        dp = new int[n][W+1];
        for(int[] x: dp) {
            Arrays.fill(x, -1);
        }
        return solve(0, W, val, wt);
    }
    
    private int solve(int i, int W, int[] val, int[] wt) {
        if(i >= n || W == 0) {
            return 0;
        }
        
        if(dp[i][W] != -1) {
            return dp[i][W];
        }
        
        int skip = solve(i+1, W, val, wt);
        int take = 0;
        if(wt[i] <= W) {
            take = val[i] + solve(i+1, W - wt[i], val, wt);
        }
        
        return dp[i][W] = Math.max(skip, take);
    }
}
