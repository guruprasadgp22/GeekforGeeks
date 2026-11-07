class Solution {
    int result = -1;
    public int longestCycle(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int[] x: edges) {
            int u = x[0];
            int v = x[1];
            adj.get(u).add(v);
        }
        
        boolean[] visited = new boolean[V];
        boolean[] recursion = new boolean[V];
        int[] count = new int[V];
        Arrays.fill(count, 1);
        
        for(int i=0;i<V;i++) {
            if(!visited[i]) {
                DFS(i, adj, visited, recursion, count);
            }
        }
        
        return result;
    }
    
    void DFS(int u, List<List<Integer>> adj, boolean[] visited, boolean[] recursion, int[] count) {
        visited[u] = true;
        recursion[u] = true;
        
        for(int v: adj.get(u)) {
            if(!visited[v]) {
                count[v] = count[u] + 1;
                DFS(v, adj, visited, recursion, count);
            } else if(recursion[v]) {
                result = Math.max(result, count[u] - count[v] + 1);
            }
        }
        
        recursion[u] = false;
    }
}