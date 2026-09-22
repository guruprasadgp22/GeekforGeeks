class Solution {
    public String findLongestWord(String s, List<String> d) {
        int n = d.size();
        
        d.sort((a, b) -> {
            if(a.length() == b.length()) {
                return a.compareTo(b);
            }
            return b.length() - a.length();
        });
        
        for(String str: d) {
            int ans = longestCommonSubsequence(str, s);
            
            if(ans == str.length()) {
                return str;
            }
        }
        
        return "";
    }
    
    private int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        
        int[][] dp = new int[m+1][n+1];
        
        for(int i=m-1;i>=0;i--) {
            for(int j=n-1;j>=0;j--) {
                if(s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else {
                    int skipI = dp[i+1][j];
                    int skipJ = dp[i][j+1];
                    
                    dp[i][j] = Math.max(skipI, skipJ);
                }
            }
        }
        
        return dp[0][0];
    }
}