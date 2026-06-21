class Pair {
    int destination;
    int weight;
    
    Pair(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        List<List<Pair>> list = new ArrayList<>();
        for(int i=0;i<V;i++) {
            list.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            list.get(u).add(new Pair(v, w));
            list.get(v).add(new Pair(u, w));
        }
        
        int distance[] = new int[V];
        for(int i=0;i<V;i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> {
            return a.weight - b.weight;
        });
        
        distance[src] = 0;
        queue.add(new Pair(src, 0));
        
        while(!queue.isEmpty()) {
            Pair temp = queue.poll();
            int u = temp.destination;
            
            if(temp.weight > distance[u]) {
                continue;
            }
            
            for(Pair v: list.get(u)) {
                if(distance[v.destination] > distance[u] + v.weight) {
                    distance[v.destination] = distance[u] + v.weight;
                    queue.add(new Pair(v.destination, distance[v.destination]));
                }
            }
        }
        
        return distance;
    }
}