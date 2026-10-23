class Solution {
    public int countSquare(int[][] mat, int x) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] sum = new int[m+1][n+1];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                sum[i+1][j+1] = mat[i][j] + sum[i+1][j] + sum[i][j+1] - sum[i][j];
            }
        }
        
        int res = 0;
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                for(int k=1;i+k<=m && j+k<=n;k++) {
                    int s = sum[i+k][j+k] + sum[i][j] - sum[i+k][j] - sum[i][j+k];
                    
                    if(s == x) {
                        res++;
                    }
                }
            }
        }
        
        return res;
    }
}