class Graph {
    int v;
    List<List<Integer>> list;
    
    Graph(int v) {
        this.v = v;
        list = new ArrayList<>(v);
        
        for(int i=0;i<v;i++) {
            list.add(new ArrayList<>());
        }
    }
    
    void addEdge(int u, int v) {
        list.get(u).add(v);
    }
    
    boolean isCycle() {
        boolean[] visited = new boolean[v];
        boolean[] recursive = new boolean[v];
        
        for(int i=0;i<v;i++) {
            if(!visited[i]) {
                if(DFS(i, visited, recursive)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    boolean DFS(int source, boolean[] visited, boolean[] recursive) {
        visited[source] = true;
        recursive[source] = true;
        
        for(int neighbor: list.get(source)) {
            if(!visited[neighbor]) {
                if(DFS(neighbor, visited, recursive)) {
                    return true;
                }
            } else if(recursive[neighbor]) {
                return true;
            }
        }
        
        recursive[source] = false;
        
        return false;
    }
}
class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        Graph graph = new Graph(V);
        
        for(int i=0;i<edges.length;i++) {
            graph.addEdge(edges[i][0], edges[i][1]);
        }
        
        return graph.isCycle();
    }
}