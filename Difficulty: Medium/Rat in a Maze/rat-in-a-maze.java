class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        ArrayList<String> result = new ArrayList<>();
        int n = maze.length;
        int row = 0;
        int col = 0;
        String path = "";
        boolean[][] visited = new boolean[n][n];
        findPath(maze, n, row, col, path, result, visited);
        
        return result;
    }
    
    public void findPath(int[][] arr, int n, int row, int col, String path, ArrayList<String> result, boolean[][] visited) {
        if(row < 0 || col < 0 || col >= n || row >= n || arr[row][col] == 0 || visited[row][col] == true) {
            return;
        }
        if(row == n-1 && col == n-1) {
            result.add(path);
            return;
        }
        
        visited[row][col] = true;
        
        findPath(arr, n, row+1, col, path+"D", result, visited);
        findPath(arr, n, row, col-1, path+"L", result, visited);
        findPath(arr, n, row, col+1, path+"R", result, visited);
        findPath(arr, n, row-1, col, path+"U", result, visited);
        
        
        visited[row][col] = false;
    }  
}