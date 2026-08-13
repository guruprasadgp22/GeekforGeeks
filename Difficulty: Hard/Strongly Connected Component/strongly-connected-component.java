class Graph {
    int n;
    List<List<Integer>> edges;
    ArrayList<ArrayList<Integer>> result;
    
    Graph(int n) {
        this.n = n;
        edges = new ArrayList<>();
        
        for(int i=0;i<n;i++) {
            edges.add(new ArrayList<>());
        }
    }
    
    void addEdges(int u, int v) {
        edges.get(u).add(v);
    }
    
    
    ArrayList<ArrayList<Integer>> kosaraju() {
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                topoSort(i, visited, stack);
            }
        }
        
        List<List<Integer>> transpose = new ArrayList<>();
        for(int i=0;i<n;i++) {
            transpose.add(new ArrayList<>());
        }
        
        for(int u=0;u<n;u++) {
            for(int v: edges.get(u)) {
                transpose.get(v).add(u);
            }
        }
        
        Arrays.fill(visited, false);
        
        result = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(!stack.isEmpty()) {
            int v = stack.pop();
            ans = new ArrayList<>();
            
            if(!visited[v]) {
                DFS(v, visited, transpose, ans);
                Collections.sort(ans);
                result.add(ans);
                // ans.clear();
            }
        }
        
        result.sort((a, b) -> {
            return Integer.compare(a.get(0), b.get(0));
        });
        
        return result;
        
    }
    
    void DFS(int source, boolean[] visited, List<List<Integer>> transpose, ArrayList<Integer> ans) {
        visited[source] = true;
        ans.add(source);
        
        for(int v: transpose.get(source)) {
            if(!visited[v]){
                DFS(v, visited, transpose, ans);
            }
        }
    }
    
    void topoSort(int source, boolean[] visited, Stack<Integer> stack) {
        visited[source] = true;
        
        for(int v: edges.get(source)) {
            if(!visited[v]) {
                topoSort(v, visited, stack);
            }
        }
        
        stack.add(source);
    }
}

class Solution {
    public ArrayList<ArrayList<Integer>> tarjans(int V, int[][] adj) {
        Graph graph = new Graph(V);
        
        for(int i=0;i<V;i++) {
            int u = i;
            for(int j=0;j<adj[i].length;j++) {
                int v = adj[i][j];
                graph.addEdges(u, v);
            }
        }
        
        return graph.kosaraju();
    }
}
