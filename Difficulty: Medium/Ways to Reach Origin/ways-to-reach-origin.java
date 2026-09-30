class Solution {
    static final int MOD = 1_000_000_007;

    public int ways(int x, int y) {
        int n = x + y;
        long[] fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        long numerator = fact[n];
        long denominator = (fact[x] * fact[y]) % MOD;
        long invDenominator = power(denominator, MOD - 2, MOD);

        long ans = (numerator * invDenominator) % MOD;
        return (int) ans;
    }

    private long power(long base, long exp, long mod) {
        base %= mod;
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}