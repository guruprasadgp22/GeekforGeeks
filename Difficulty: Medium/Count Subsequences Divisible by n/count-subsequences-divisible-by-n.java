class Solution {
    int MOD = 1000000007;
    public int countSubsequences(String s, int n) {
        // code here
        long[] dp = new long[n];
        
        for(int i=0; i<s.length();i++) {
            int d = s.charAt(i) - '0';
            
            long next[] = dp.clone();
            next[d % n]++;
            
            for(int rem =0; rem < n; rem++) {
                int newRem = (rem * 10 + d) % n;
                next[newRem] = (next[newRem] + dp[rem]) % MOD;
            }
            
            dp = next;
        }
        
        return (int)dp[0];
    }
}