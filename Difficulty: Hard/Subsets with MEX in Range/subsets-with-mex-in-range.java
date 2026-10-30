class Solution {
    public int cntSubsets(int arr[], int l, int r) {
        final long MOD = 1_000_000_007L;
        int n = arr.length;

        int[] cnt = new int[n + 2];
        for (int x : arr) cnt[x]++;

        long[] pow2 = new long[n + 1];
        pow2[0] = 1;
        for (int i = 1; i <= n; i++) pow2[i] = pow2[i - 1] * 2 % MOD;

        long ans = 0;
        long prod = 1;      // ∏ (2^cnt[v] − 1) for v < m
        int seen = 0;       // cnt[0] + … + cnt[m]

        for (int m = 0; m <= r; m++) {
            seen += cnt[m];
            if (m >= l) ans = (ans + prod * pow2[n - seen]) % MOD;

            if (cnt[m] == 0) break;     // value m is missing, so no larger MEX is possible
            prod = prod * ((pow2[cnt[m]] - 1 + MOD) % MOD) % MOD;
        }
        return (int) ans;
    }
}