class Tuple implements Comparable<Tuple> {
    int u;
    int v;
    int w;
    
    Tuple(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
    
    @Override
    public int compareTo(Tuple other) {
        return Integer.compare(this.w, other.w);
    }
}

class Solution {
    int[] parent;
    int[] rank;
    
    private boolean union(int u, int v) {
        int parentU = find(u);
        int parentV = find(v);
        
        if(parentU == parentV) {
            return false;
        }
        
        if(rank[parentU] == rank[parentV]) {
            parent[parentV] = parentU;
            rank[parentU] += 1;
        } else if(rank[parentU] > rank[parentV]) {
            parent[parentV] = parentU;
        } else {
            parent[parentU] = parentV;
        }
        
        return true;
    }
    
    private int find(int x) {
        if(x == parent[x]) {
            return parent[x];
        }
        
        return find(parent[x]);
    }
    
    public int minCost(int[][] houses) {
        int n = houses.length;
        PriorityQueue<Tuple> queue = new PriorityQueue<>();
        
        rank = new int[n];
        parent = new int[n];
        
        for(int i=0;i<n;i++) {
            rank[i] = 0;
            parent[i] = i;
        }
        
        
        for(int i=0;i<n-1;i++) {
            int x1 = houses[i][0];
            int y1 = houses[i][1];
            
            for(int j=i+1; j<n;j++) {
                int x2 = houses[j][0];
                int y2 = houses[j][1];
                
                int distance = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                queue.add(new Tuple(i, j, distance));
            }
        }
        
        int minCost = 0;
        
        while(!queue.isEmpty()) {
            Tuple temp = queue.poll();
            int u = temp.u;
            int v = temp.v;
            int w = temp.w;
            
            if(union(u, v)) {
                minCost += w;
            }
        }
        
        return minCost;
    }
}
