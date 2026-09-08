class Solution {
    public ArrayList<ArrayList<Integer>> searchWord(char[][] mat, String word) {
        int m = mat.length;
        int n = mat[0].length;
        
        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(mat[i][j] == word.charAt(0)) {
                   for(int k=0;k<8;k++) {
                        if(DFS(mat, m, n, word, 0, i, j, dx[k], dy[k])) {
                            ArrayList<Integer> ans = new ArrayList<>();
                            ans.add(i);
                            ans.add(j);
                            
                            result.add(ans);
                            break;
                        }
                   }
                }
            }
        }
        
        return result;
    }
    
    private boolean DFS(char[][] grid, int m, int n, String word, int sidx, int x, int y, int dx, int dy) {
        if(sidx == word.length()) {
            return true;
        }
        
        if(x >= 0 && y >=0 && x < m && y < n && word.charAt(sidx) == grid[x][y]) {
            return DFS(grid, m, n, word, sidx+1, x + dx, y + dy, dx, dy);
        }
        
        return false;
    }
}