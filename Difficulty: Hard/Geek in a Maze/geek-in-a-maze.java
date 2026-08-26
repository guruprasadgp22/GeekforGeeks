class Solution {
    public int numberOfCells(int r, int c, int u, int d, char[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        
        if(mat[r][c] == '#') {
            return 0;
        }
        
        int[][] minUp = new int[row][col];
        for(int i=0;i<row;i++) {
            Arrays.fill(minUp[i], Integer.MAX_VALUE);
        }
        
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        minUp[r][c] = 0;
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];
            
            for(int k=0;k<4;k++) {
                int nx = x + dr[k];
                int ny = y + dc[k];
                
                if(nx < 0 || nx >= row || ny < 0 || ny >= col) {
                    continue;
                }
                
                if(mat[nx][ny] == '#') {
                    continue;
                }
                
                int newUp = minUp[x][y];
                
                if(nx < x) {
                    newUp++;
                }
                
                if(newUp > u) {
                    continue;
                }
                
                if(newUp <  minUp[nx][ny]) {
                    minUp[nx][ny] = newUp;
                    queue.add(new int[] {nx, ny});
                }
            }
        }
        
        int ans = 0;
        
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(minUp[i][j] == Integer.MAX_VALUE) {
                    continue;
                }
                
                int up = minUp[i][j];
                int down = up + i - r;
                
                if(down <= d) {
                    ans++;
                }
            }
        }
        
        return ans;
    }
}