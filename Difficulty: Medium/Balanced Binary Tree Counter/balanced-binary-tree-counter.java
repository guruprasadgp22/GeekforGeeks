class Solution {
    public int countBT(int h) {
        long MOD = 1_000_000_007;
        long[] dp = new long[h+1];
        dp[0] = dp[1] = 1;
        for(int i=2;i<=h;i++) {
            dp[i] = (dp[i-1] * dp[i-1] % MOD + 2 * dp[i-1] % MOD * dp[i-2] % MOD) % MOD;
        }
        return (int)dp[h];
    }
}
