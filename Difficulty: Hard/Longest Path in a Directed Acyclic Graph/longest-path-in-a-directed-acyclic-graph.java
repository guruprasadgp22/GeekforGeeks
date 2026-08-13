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
    public int[] maxDistance(int V, int src, ArrayList<ArrayList<Integer>> edges) {
       List<List<Pair>> adjMatrix = new ArrayList<>();
       for(int i=0;i<V;i++) {
           adjMatrix.add(new ArrayList<>());
       }
       
       for(ArrayList<Integer> edge: edges) {
           int u = edge.get(0);
           int v = edge.get(1);
           int w = edge.get(2);
           
           adjMatrix.get(u).add(new Pair(v, w));
       }
       
       int[] distance = new int[V];
       Arrays.fill(distance, Integer.MIN_VALUE);
       distance[src] = 0;
       
       PriorityQueue<Pair> queue = new PriorityQueue<>();
       queue.add(new Pair(src, 0));
       
       while(!queue.isEmpty()) {
           Pair temp = queue.poll();
           int u = temp.v;
           
           for(Pair neigh: adjMatrix.get(u)) {
               int v = neigh.v;
               int w = neigh.w;
               
               if(distance[v] < distance[u] + w) {
                   distance[v] = distance[u] + w;
                   queue.add(new Pair(v, distance[v]));
               }
           }
       }
       
       return distance;
    }
}
