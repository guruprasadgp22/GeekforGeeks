class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // code here
        int old = image[sr][sc];
        filling(image, sr, sc, newColor, old);
        
        return image;
    }
    
    private void filling(int[][] arr, int u, int v, int col, int old) {
        if(u < 0 || v < 0 || u >= arr.length || v >= arr[u].length || arr[u][v] == col || arr[u][v] != old) {
            return;
        }
        
        arr[u][v] = col;
        
        filling(arr, u-1, v, col, old);
        filling(arr, u, v-1, col, old);
        filling(arr, u+1, v, col, old);
        filling(arr, u, v+1, col, old);
    }
}