class Pair implements Comparable<Pair> {
    int v;
    int cost;
    
    Pair(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Pair o) {
        return Integer.compare(this.v, o.v);
    }
}

class Solution {
    public int minimumEdgeReversal(int[][] edges, int n, int src, int dst) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int[] x: edges) {
            int u = x[0];
            int v = x[1];
            
            adj.get(u).add(new Pair(v, 0));
            adj.get(v).add(new Pair(u, 1));
        }
        
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(0, src));
        distance[src] = 0;
        
        while(!queue.isEmpty()) {
            Pair temp = queue.poll();
            int d = temp.v;
            int u = temp.cost;
            
            if(d != distance[u]) {
                continue;
            }
            
            for(Pair next: adj.get(u)) {
                int v = next.v;
                int cost = next.cost;
                
                if(d + cost < distance[v]) {
                    distance[v] = d + cost;
                    queue.add(new Pair(distance[v], v));
                }
            }
        }
        
        
        return distance[dst] == Integer.MAX_VALUE? -1: distance[dst];
    }
}