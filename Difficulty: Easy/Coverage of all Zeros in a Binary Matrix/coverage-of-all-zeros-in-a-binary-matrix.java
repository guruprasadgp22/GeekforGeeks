class Solution {
    public int findCoverage(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        
        boolean[][] up = new boolean[m][n];
        boolean[][] down = new boolean[m][n];
        boolean[][] left = new boolean[m][n];
        boolean[][] right = new boolean[m][n];
        
        // up
        for (int j = 0; j < n; j++) {
            boolean seen = false;
            for (int i = 0; i < m; i++) {
                up[i][j] = seen;
                if (mat[i][j] == 1) seen = true;
            }
        }
        
        // down
        for (int j = 0; j < n; j++) {
            boolean seen = false;
            for (int i = m - 1; i >= 0; i--) {
                down[i][j] = seen;
                if (mat[i][j] == 1) seen = true;
            }
        }
        
        // left
        for (int i = 0; i < m; i++) {
            boolean seen = false;
            for (int j = 0; j < n; j++) {
                left[i][j] = seen;
                if (mat[i][j] == 1) seen = true;
            }
        }
        
        // right
        for (int i = 0; i < m; i++) {
            boolean seen = false;
            for (int j = n - 1; j >= 0; j--) {
                right[i][j] = seen;
                if (mat[i][j] == 1) seen = true;
            }
        }
        
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    if (up[i][j]) ans++;
                    if (down[i][j]) ans++;
                    if (left[i][j]) ans++;
                    if (right[i][j]) ans++;
                }
            }
        }
        
        return ans;
    }
}