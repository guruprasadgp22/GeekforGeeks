class Solution {
    int m;
    int n;
    int[][] dp;
    public int uniquePaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new int[m][n];
        for(int[] x: dp) {
            Arrays.fill(x, -1);
        }
        
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1) {
            return 0;
        }
        
        return solve(0, 0, grid);
    }
    
    private int solve(int i, int j, int[][] grid) {
        if(i == m-1 && j == n-1 && grid[i][j] == 0) {
            return 1;
        }
        
        if(i>=m || j>=n || grid[i][j] == 1) {
            return 0;
        }
        
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        
        return dp[i][j] = solve(i+1, j, grid) + solve(i, j+1, grid);
    }
};