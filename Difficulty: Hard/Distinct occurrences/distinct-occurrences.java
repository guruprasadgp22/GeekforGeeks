class Solution {
    public int subseqCount(String txt, String pat) {
        int m = txt.length();
        int n = pat.length();
        
        int[][] dp = new int[m+1][n+1];
        
        for(int i=0;i<=m;i++) {
            dp[i][n] = 1;
        }
        
        for(int i=0;i<n;i++) {
            dp[m][i] = 0;
        }
        
        for(int i=m-1;i>=0;i--) {
            for(int j=n-1;j>=0;j--) {
                if(txt.charAt(i) == pat.charAt(j)) {
                    dp[i][j] = dp[i+1][j+1] + dp[i+1][j];
                } else {
                    dp[i][j] = dp[i+1][j];
                }
            }
        }
        
        return dp[0][0];
    }
}