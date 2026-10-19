class Solution {
    int[] visited;
    public int goodIndices(int[] arr) {
        int n = arr.length;
        visited = new int[n];
        
        for(int i=0;i<n;i++) {
            if(visited[i] == 0) {
                DFS(i, arr, visited, n);
            }
        }
        
        int count = 0;
        for(int ele: visited) {
            if(ele == 1) {
                count++;
            }
        }
        
        return count;
    }
    
    private int DFS(int source, int[] arr, int[] visited, int n) {
        if(source < 0 || source >= n) {
            return 1;
        }
        
        if(visited[source] == 1 || visited[source] == 2) {
            return visited[source];
        }
        
        if(arr[source] == 0) {
            return visited[source] = 2;
        }
        
        if(visited[source] == 3) {
            return 2;
        }
        visited[source] = 3;
        
        return visited[source] = DFS(source + arr[source], arr, visited, n);
    }
}