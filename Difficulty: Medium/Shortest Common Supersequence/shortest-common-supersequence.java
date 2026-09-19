class Solution {
    static int[][] dp;
    public static int minSuperSeq(String s1, String s2) {
        int i = 0;
        int j = 0;
        
        dp = new int[s1.length()][s2.length()];
        for(int[] x: dp) {
            Arrays.fill(x, -1);
        }
        
        return solve(i, j, s1, s2);
    }
    
    private static int solve(int i, int j, String s1, String s2) {
        if(i >= s1.length()) {
            return s2.length() - j;
        }
        
        if(j >= s2.length()) {
            return s1.length() - i;
        }
        
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        
        if(s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + solve(i+1, j+1, s1, s2);
        } else {
            int skipI = 1 + solve(i+1, j, s1, s2);
            int skipJ = 1 + solve(i, j+1, s1, s2);
            
            return dp[i][j] = Math.min(skipI, skipJ);
        }
    }
}