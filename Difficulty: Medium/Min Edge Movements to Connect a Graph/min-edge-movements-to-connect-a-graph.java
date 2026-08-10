class Solution {
    int minEdgesReq(int n, int[][] edges) {
        int edge = edges.length;
        
        if(edge < n-1) {
            return -1;
        }
        
        List<List<Integer>> adjMatrix = new ArrayList<>();
        
        for(int i=0;i<n;i++) {
            adjMatrix.add(new ArrayList<>());
        }
        
        for(int[] x: edges) {
            int u = x[0];
            int v = x[1];
            
            adjMatrix.get(u).add(v);
            adjMatrix.get(v).add(u);
        }
        
       
        boolean[] visited = new boolean[n];
        int component = 0;
        int extraEdges = 0;
        
        for(int i=0;i<n;i++) {
            if(visited[i]){
                continue;
            }
            
            component++;
            int vertice = 0;
            int edgeCount = 0;
            
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            visited[i] = true;
            
            while(!queue.isEmpty()) {
                int u = queue.poll();
                vertice++;
                edgeCount += adjMatrix.get(u).size();
                
                for(int v: adjMatrix.get(u)) {
                    if(!visited[v]) {
                        visited[v] = true;
                        queue.add(v);
                    }
                }
            }
            
            int actualEdge = edgeCount/2;
            extraEdges += actualEdge - vertice + 1; 
        }
        
        int required =  component - 1;
        
        if(extraEdges >= required) {
            return required;
        }
        
        return -1;
    }
}