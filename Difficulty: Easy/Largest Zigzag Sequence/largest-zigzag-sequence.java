class Solution {
    int dp[][];
    public int zigzagSequence(int[][] mat) {
        int n = mat.length;
        dp = new int[n][n];
        
        for(int i=0;i<n;i++) {
            Arrays.fill(dp[i], -1);
        }
        
        int result = 0;
        
        for(int col=0;col<n;col++) {
            result = Math.max(result, solve(0, col, mat));
        }
        
        return result;
    }
    
    private int solve(int row, int col, int[][] mat) {
        if(row == mat.length-1) {
            return mat[row][col];
        }
        
        if(dp[row][col] != -1) {
            return dp[row][col];
        }
        
        int maxElement = 0;
        
        for(int nextCol = 0; nextCol < mat.length; nextCol++) {
            if(nextCol != col) {
                maxElement = Math.max(maxElement, solve(row+1, nextCol, mat));
            }
        }
        
        return dp[row][col] = maxElement + mat[row][col];
    }
}