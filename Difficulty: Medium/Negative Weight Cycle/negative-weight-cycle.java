class Pair {
    int v;
    int w;
    
    Pair(int v, int w) {
        this.v = v;
        this.w = w;
    }
}

class Solution {
    public boolean isNegativeWeightCycle(int V, int[][] edges) {
        // code here
        List<List<Pair>> list = new ArrayList<>();
        for(int i=0;i<V;i++) {
            list.add(new ArrayList<>());
        }
        
        for(int[] x: edges) {
            int u = x[0];
            int v = x[1];
            int w = x[2];
            
            list.get(u).add(new Pair(v, w));
        }
        
        boolean[] visited = new boolean[V];
        boolean[] recursive = new boolean[V];
        
        for(int i=0;i<V;i++) {
            if(!visited[i]) {
                if(DFS(i, visited, recursive, list)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean DFS(int source, boolean[] visited, boolean[] recursive, List<List<Pair>> list) {
        visited[source] = true;
        recursive[source] = true;
        
        for(Pair neigh: list.get(source)) {
            int v = neigh.v;
            if(!visited[v]) {
                if(DFS(v, visited, recursive, list)) {
                    return true;
                }
            } else if(recursive[v]) {
                return true;
            }
        }
        recursive[source] = false;
        return false;
    }
}




















