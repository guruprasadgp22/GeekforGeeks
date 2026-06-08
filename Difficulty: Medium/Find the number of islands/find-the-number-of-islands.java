class Solution {
    public int countIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 'L' && !visited[i][j]) {
                    DFS(i, j, visited, grid, m, n);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void DFS(int i, int j, boolean[][] visited, char[][] grid, int m, int n) {
        if(i < 0 || j < 0 || i >= m || j >= n || visited[i][j] || grid[i][j] == 'W') {
            return;
        }
        
        visited[i][j] = true;
        
        DFS(i-1, j, visited, grid, m, n);
        DFS(i-1, j+1, visited, grid, m, n);
        DFS(i, j+1, visited, grid, m, n);
        DFS(i+1, j+1, visited, grid, m, n);
        DFS(i+1, j, visited, grid, m, n);
        DFS(i+1, j-1, visited, grid, m, n);
        DFS(i, j-1, visited, grid, m, n);
        DFS(i-1, j-1, visited, grid, m, n);

    }
}