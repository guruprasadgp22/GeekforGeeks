class Solution {
    public int getMaxWeight(String s) {
        int n = s.length();
        int[] dp = new int[n + 2];          // dp[i] = best weight for s[i..n-1]

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1 + dp[i + 1];                          // s[i] stays single
            if (i + 1 < n) {
                int pair = (s.charAt(i) != s.charAt(i + 1)) ? 4 : 3;
                dp[i] = Math.max(dp[i], pair + dp[i + 2]);  // pair s[i] with s[i+1]
            }
        }
        return dp[0];
    }
}