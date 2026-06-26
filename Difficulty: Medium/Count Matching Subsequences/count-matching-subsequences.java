class Solution {
    final int mod = 1_000_000_007;
    public int solve(int i, int j, String s, String t, int[][] dp) {
        
        if(j == t.length()) {
            return 1;
        }
        
        if(i == s.length()) {
            return 0;
        }
        
        if(dp[i][j] != -1) {
            return dp[i][j] % mod;
        }
        
        if(s.charAt(i) == t.charAt(j)) {
            int take = solve(i+1, j+1, s, t, dp);
            int skip = solve(i+1, j, s, t, dp);
            dp[i][j] = take + skip;
            return dp[i][j] % mod;
        } else {
            int skip = solve(i+1, j, s, t, dp);
            dp[i][j] = skip;
            return dp[i][j] % mod;
        }
    }
    public int countWays(String s1, String s2) {
        // code here
        if(s2.length() == 0) {
            return 0;
        }
        int[][] dp = new int[s1.length()][s2.length()];
        for(int i=0;i<s1.length();i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, 0, s1, s2,dp);
    }
}
