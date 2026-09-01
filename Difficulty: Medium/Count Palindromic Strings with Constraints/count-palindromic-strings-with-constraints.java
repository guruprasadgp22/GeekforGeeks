class Solution {
    private static final int MOD = 1000000007;

    public int palindromicStrings(int n, int k) {
        long totalAns = 0;

        for (int i = 1; i <= n; i++) {
            int m = (i + 1) / 2; // ceil(i / 2)

            // Pigeonhole principle: cannot pick m distinct characters from k available
            if (m > k) {
                continue;
            }

            // Calculate P(k, m) % MOD
            long permutations = 1;
            for (int j = 0; j < m; j++) {
                permutations = (permutations * (k - j)) % MOD;
            }

            totalAns = (totalAns + permutations) % MOD;
        }

        return (int) totalAns;
    }
}