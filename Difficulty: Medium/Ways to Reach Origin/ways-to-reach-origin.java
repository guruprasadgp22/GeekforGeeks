class Solution {
    int[][] dp;
    int MOD = 1_000_000_007;
    public int ways(int x, int y) {
        dp = new int[x+1][y+1];
        for(int[] a: dp) {
            Arrays.fill(a, -1);
        }
        
        return solve(x, y);
    }
    
    private int solve(int x, int y){
        if(x < 0 || y < 0) {
            return 0;
        }
        
        if(dp[x][y] != -1) {
            return dp[x][y];
        }
        
        if(x == 0 && y == 0){
            return dp[x][y] = 1;
        }
        
        return dp[x][y] = (solve(x-1, y) + solve(x, y-1))%MOD;
    }
}