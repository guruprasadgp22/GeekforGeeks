class Graph {
    int n;
    List<List<Integer>> edges;
    
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
    
    int kosaraju() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];
        
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
        
        int count = 0;
        Arrays.fill(visited, false);
        
        while(!stack.isEmpty()) {
            int u = stack.pop();
            
            if(!visited[u]) {
                DFS(u, visited, transpose);
                count++;
            }
        } 
        
        
        return count;
    }
    
    void DFS(int source, boolean[] visited, List<List<Integer>> transpose) {
        visited[source] = true;
        
        for(int v:transpose.get(source)) {
            if(!visited[v]) {
                DFS(v, visited, transpose);
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
    public int kosaraju(int V, int[][] edges) {
        Graph graph = new Graph(V);
        
        for(int[] x: edges) {
            int u = x[0];
            int v = x[1];
            
            graph.addEdges(u, v);
        }
        
        return graph.kosaraju();
    }
}