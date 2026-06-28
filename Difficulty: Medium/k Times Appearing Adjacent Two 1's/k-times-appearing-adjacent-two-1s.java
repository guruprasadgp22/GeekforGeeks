class Solution {
    final int mod = 1_000_000_007;
    int[][][] dp;
    public int countStrings(int n, int k) {
        // code here
        dp = new int[n+1][k+1][2];
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        return solve(0, 0, 0, n, k);
    }
    
    public int solve(int pos, int pairs, int prev, int n, int k) {
        if(pairs > k) {
            return 0;
        }
        
        if(pos == n) {
            return (pairs == k)? 1: 0;
        }
        
        if(dp[pos][pairs][prev] != -1) {
            return dp[pos][pairs][prev];
        }
        long ways = 0;
        ways += solve(pos+1, pairs, 0, n, k);
        
        if(prev == 1) {
            ways += solve(pos+1, pairs+1, 1, n, k);
        } else {
            ways += solve(pos+1, pairs, 1, n, k);
        }
        
        return dp[pos][pairs][prev] = (int)(ways%mod);
    }
}