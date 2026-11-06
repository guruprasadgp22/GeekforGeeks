class Solution {
    public int countBT(int h) {
        final long MOD = 1_000_000_007L;
        long prev2 = 1;   // T(0)
        long prev1 = 1;   // T(1)

        for (int i = 2; i <= h; i++) {
            long curr = (prev1 * prev1 % MOD + 2 * prev1 % MOD * prev2 % MOD) % MOD;
            prev2 = prev1;
            prev1 = curr;
        }
        return (int) prev1;
    }
}