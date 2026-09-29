class Pair {
    int x;
    int y;
    
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int minStepToReachTarget(int knightPos[], int targetPos[], int n) {
        int ux = knightPos[0]-1;
        int uy = knightPos[1]-1;
        int vx = targetPos[0]-1;
        int vy = targetPos[1]-1;
        
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
        
        boolean[][] visited = new boolean[n][n];
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(ux, uy));
        visited[ux][uy] = true;
        
        int moves = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            while(size > 0) {
                Pair temp = queue.poll();
                int x = temp.x;
                int y = temp.y;
                
                if(x == vx && y == vy) {
                    return moves;
                }
                
                for(int i=0;i<8;i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    
                    if(nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new Pair(nx, ny));
                    }
                }
                
                size--;
            }
            
            moves++;
        }
        return -1;
        
    }
}