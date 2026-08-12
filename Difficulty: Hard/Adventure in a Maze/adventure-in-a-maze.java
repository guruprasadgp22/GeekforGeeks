class Solution {
    int mod = 1_000_000_007;
    public ArrayList<Integer> findWays(int[][] grid) {
        int n = grid.length;
        
        long[][] path = new long[n][n];
        int[][] maxSum = new int[n][n];
        
        path[0][0] = 1;
        maxSum[0][0] = grid[0][0];
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(path[i][j] == 0) {
                    continue;
                }
                
                if(j + 1 < n && (grid[i][j] == 1 || grid[i][j] == 3)) {
                    path[i][j+1] = (path[i][j] + path[i][j+1]) % mod;
                    maxSum[i][j+1] = Math.max(maxSum[i][j+1], maxSum[i][j] + grid[i][j+1]); 
                }
                
                if(i + 1 < n && (grid[i][j] == 2 || grid[i][j] == 3)) {
                    path[i+1][j] = (path[i][j] + path[i+1][j]) % mod;
                    maxSum[i+1][j] = Math.max(maxSum[i+1][j], maxSum[i][j] + grid[i+1][j]);
                }
            }
        }
        
        
        ArrayList<Integer> result = new ArrayList<>();
        result.add((int)path[n-1][n-1]);
        result.add(maxSum[n-1][n-1]);
        
        return result;
    } 
}