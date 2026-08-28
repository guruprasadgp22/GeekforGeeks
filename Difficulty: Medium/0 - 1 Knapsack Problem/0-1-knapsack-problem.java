class Solution {
    int dp[][];
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = val.length;
        dp = new int[n+1][W+1];
        for(int i=0;i<n+1;i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return solve(val, wt, W, n-1);
    }
    
    private int solve(int[] val, int[] wt, int W, int n) {
        if(n < 0 || W ==  0) {
            return 0;
        }
        
        if(dp[n][W] != -1) {
            return dp[n][W];
        }
        
        if(wt[n] <= W) {
            int take = val[n] + solve(val, wt, W - wt[n], n-1);
            int skip = solve(val, wt, W, n-1);
            
            return dp[n][W] =  Math.max(skip, take);
        } else {
            return dp[n][W] = solve(val, wt, W, n-1);
        }
    }
}
