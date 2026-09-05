class Solution {
    public int longestSubseq(int[] arr) {
        int[] dp = new int[1000000];
        int ans = 0;
        for(int x: arr) {
            dp[x] = Math.max(dp[x-1], dp[x+1]) + 1;
            ans = Math.max(ans, dp[x]);
        }
        
        return ans;
    }
}
