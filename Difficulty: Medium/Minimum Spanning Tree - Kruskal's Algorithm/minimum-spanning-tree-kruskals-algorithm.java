class Pair implements Comparable<Pair> {
    int u;
    int v;
    int w;
    
    Pair(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
    
    @Override
    public int compareTo(Pair other) {
        return Integer.compare(this.w, other.w);
    }
}

class Solution {
    int parent[];
    int rank[];
    int kruskalsMST(int V, int[][] edges) {
        // code here
        parent = new int[V];
        rank = new int[V];
        for(int i=0;i<V;i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        
        List<Pair> list = new ArrayList<>();
        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            list.add(new Pair(u, v, w));
        }
        
        Collections.sort(list);
        int minCost = 0;
        
        for(Pair p: list) {
            int u = p.u;
            int v = p.v;
            int w = p.w;
            
            int parentU = find(u);
            int parentV = find(v);
            
            if(parentU != parentV) {
                minCost += w;
                if(parent[parentU] == parent[parentV]) {
                    parent[parentV] = parentU;
                    rank[parentU] += 1;
                } else if(parent[parentU] > parent[parentV]) {
                    parent[parentV] = parentU;
                } else {
                    parent[parentU] = parentV;
                }
            }
        }
        
        return minCost;
    }
    
    private int find(int x) {
        if(x == parent[x]) {
            return parent[x];
        }
        
        return find(parent[x]);
    }
}
