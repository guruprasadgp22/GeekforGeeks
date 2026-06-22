class Pair implements Comparable<Pair> {
    int v;
    int w;
    
    Pair(int v, int w) {
        this.v = v;
        this.w = w;
    }
    
    @Override
    public int compareTo(Pair other) {
        return Integer.compare(this.w, other.w);
    }
}

class Solution {
    public int spanningTree(int V, int[][] edges) {
        // code here
        List<List<Pair>> list = new ArrayList<>();
        for(int i=0;i<V;i++) {
            list.add(new ArrayList<>());
        }
        
        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            list.get(u).add(new Pair(v, w));
            list.get(v).add(new Pair(u, w));
        }
        
        HashSet<Integer> set = new HashSet<>();
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(0, 0));
        int minCost = 0;
        
        while(!queue.isEmpty()) {
            Pair temp = queue.poll();
            
            if(!set.contains(temp.v)) {
                minCost += temp.w;
                set.add(temp.v);
                for(Pair pair: list.get(temp.v)) {
                    queue.add(new Pair(pair.v, pair.w));
                }
            }
        }
        
        return minCost;
    }
}
