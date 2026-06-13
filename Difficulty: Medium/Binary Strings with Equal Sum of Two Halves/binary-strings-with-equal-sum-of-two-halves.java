class Solution {
    final int MOD = 1_000_000_007;
    public int computeValue(int n) {
        // code here
        long[] fact = new long[2*n+1];
        fact[0] = 1;
        
        for(int i=1;i<=2*n;i++) {
            fact[i] = (fact[i-1] * i) % MOD;
        }
        
        long num = fact[2*n];
        long domi = (fact[n] * fact[n]) % MOD;
        
        long ans = num * power(domi, MOD-2) % MOD;
        
        return (int) ans;
    }
    
    public long power(long b, long e) {
        long ans = 1;
        
        while(e > 0) {
            if((e & 1) == 1) {
                ans = (ans * b) % MOD;
            }
            b = (b * b) % MOD;
            e = e >> 1;
        }
        
        return ans;
    }
}