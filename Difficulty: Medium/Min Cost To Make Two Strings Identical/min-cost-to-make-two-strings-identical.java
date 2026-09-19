class Solution {
    public int findMinCost(String s1, String s2, int costS1, int costS2) {
        int n = longestCommonSequence(s1, s2);
        
        int totalCost = 0;
        
        int len1 = s1.length() - n;
        totalCost += costS1 * len1;
        
        int len2 = s2.length() - n;
        totalCost += costS2 * len2;
        
        return totalCost;
        
    }
    
    private int longestCommonSequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        
        int[][] dp = new int[m+1][n+1];
        
        for(int i=m-1;i>=0;i--) {
            for(int j=n-1;j>=0;j--) {
                if(s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else {
                    dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        
        return dp[0][0];
    }
}