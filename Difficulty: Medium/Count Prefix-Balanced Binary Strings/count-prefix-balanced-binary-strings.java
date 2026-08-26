class Solution {
    long[] dp;
    int MOD = 1000000007;
    public int prefixStrings(int n) {
        // code here
        if(n == 1) {
            return 1;
        }
        
        dp = new long[2*n+1];
        Arrays.fill(dp, -1);
        
        
        long nominator = fact(2*n);
        long denominator = (fact(n) * fact(n)) % MOD;
        denominator = (denominator * (n+1)) % MOD;
        
        long result = (nominator * inverse(denominator)) % MOD;
        
        return (int)result;
    }
    
    private long inverse(long base) {
        long exp = MOD - 2;
        base %= MOD;
        long result = 1;
        
        while(exp > 0) {
            if((exp & 1) == 1) {
                result = (result * base) % MOD;
            }
            
            base = (base * base) % MOD;
            exp >>= 1;
        }
        
        return result;
    }
    
    private long fact(int n) {
        if(n<=1) {
            return 1;
        }
        
        if(dp[n] !=-1) {
            return dp[n];
        }
        
        return dp[n] = (n * fact(n-1)) % MOD;
    }
}