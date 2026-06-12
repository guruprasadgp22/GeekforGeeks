class Graph {
    int v;
    List<List<Integer>> list;
    
    Graph(int v) {
        this.v = v;
        list = new ArrayList<>();
        
        for(int i=0;i<v;i++) {
            list.add(new ArrayList<>());
        }
    }
    
    void addEdge(int u, int v) {
        list.get(u).add(v);
    }
    
    ArrayList<Integer> topo() {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<v;i++) {
            map.put(i, 0);
        }
        
        for(int i=0;i<v;i++) {
            for(int niegh: list.get(i)) {
                map.put(niegh, map.get(niegh)+1);
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }
        
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            ans.add(temp);
            
            for(int j: list.get(temp)) {
                map.replace(j, map.get(j)-1);
                
                if(map.get(j) == 0) {
                    queue.add(j);
                }
            }
        }
        
        return ans;
    }
}

class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        Graph graph = new Graph(V);
        
        for(int[] e: edges) {
            int u = e[0];
            int v = e[1];
            
            graph.addEdge(u, v);
        }
        
        return graph.topo();
    }
}