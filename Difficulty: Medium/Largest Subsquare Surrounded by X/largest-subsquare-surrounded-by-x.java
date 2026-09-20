class Solution {
    public int largestSubsquare(char mat[][]) {
        int n = mat.length;
        
        int[][] right = new int[n][n];
        for(int i=n-1;i>=0;i--) {
            for(int j=n-1;j>=0;j--) {
                if(mat[i][j] == 'X') {
                    right[i][j] = 1;
                    if(j+1 < n) {
                        right[i][j] += right[i][j+1];
                    }
                }
            }
        }
        
        int down[][] = new int[n][n];
        for(int j=n-1;j>=0;j--) {
            for(int i=n-1;i>=0;i--) {
                if(mat[j][i] == 'X') {
                    down[j][i] = 1;
                    if(j+1 < n) {
                        down[j][i] += down[j+1][i];
                    }
                }
            }
        }
        
        for(int size=n;size>=1;size--) {
            for(int i=0;i+size<=n;i++) {
                for(int j=0;j+size<=n;j++) {
                    if(down[i][j]>=size && right[i][j] >= size && down[i][j+size-1] >= size && right[i+size-1][j] >= size) {
                        return size;
                    }
                }
            }
        }
        
        return 0;
    }
};