class Solution {
    static int findPerimeter(int[][] mat) {
        int total = 0;
        int m = mat.length;
        int n = mat[0].length;
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(mat[i][j] == 1){
                    total += 4;
                    if(i-1 >=0 && mat[i-1][j] == 1){
                        total--;
                    }
                    if(j-1>=0 && mat[i][j-1] == 1){
                        total--;
                    }
                    
                    if(i+1 < m && mat[i+1][j] == 1){
                        total--;
                    }
                    
                    if(j+1 < n && mat[i][j+1] == 1){
                        total--;
                    }
                }
            }
        }
        
        return total;
    }
}