class Solution {
    int MOD = 1_000_000_007;
    int[] prevIndex;
    int[] dp;
    int distinctSubseq(String str) {
        int n = str.length();
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        
        prevIndex = new int[n+1];
        
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);
        
        for(int i=1;i<=n;i++) {
            int idx = str.charAt(i-1) - 'a';
            prevIndex[i] = lastSeen[idx];
            lastSeen[idx] = i;
        }
        
        return solve(n);
    }
    
    private int solve(int n) {
        if(n == 0) {
            return 1;
        }
        
        if(dp[n] != -1) {
            return dp[n];
        }
        
        int total = (solve(n-1) * 2) % MOD;
        
        if(prevIndex[n] != -1) {
            int duplicate = solve(prevIndex[n] - 1) % MOD;
            total = (total - duplicate + MOD) % MOD;
        }
        
        return dp[n] = total;
    }
}