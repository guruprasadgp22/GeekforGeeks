class Solution {
    int countConnected(int V, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) {
            adj.add(new ArrayList<>());
        }
        
        for(ArrayList<Integer> l: edges) {
            int u = l.get(0);
            int v = l.get(1);
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int count = 0;
        boolean[] visited = new boolean[V];
        
        for(int i=0;i<V;i++) {
            if(!visited[i]) {
                dfs(i, adj, visited);
                count++;
            }
        }
        
        return count;
    }
    
    void dfs(int source, ArrayList<ArrayList<Integer>> edges, boolean[] visited) {
        visited[source] = true;
        
        for(int number: edges.get(source)) {
            if(!visited[number]) {
                dfs(number, edges, visited);
            }
        }
    }
}