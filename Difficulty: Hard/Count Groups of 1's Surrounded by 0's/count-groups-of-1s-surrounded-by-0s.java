class Solution {
    int m;
    int n;
    public int countGroups(int[][] mat) {
        int count = 0;
        m = mat.length;
        n = mat[0].length;
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(mat[i][j] == 1) {
                    if(DFS(i, j, mat)) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
    
    private boolean DFS(int i, int j, int[][] mat) {
        if(i < 0 || j < 0 || i >= m || j >= n) {
            return false;
        }
        
        if(mat[i][j] == 0) {
            return true;
        }
        
        mat[i][j] = 0;
        
        boolean left = DFS(i-1, j, mat);
        boolean right = DFS(i+1, j, mat);
        boolean up = DFS(i, j-1, mat);
        boolean down = DFS(i, j+1, mat);
        
        return left & right & up & down;
    } 
}