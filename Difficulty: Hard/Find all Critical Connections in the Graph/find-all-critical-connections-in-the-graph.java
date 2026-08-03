class Solution {
    int time;
    int[] dt;
    int[] low;
    public ArrayList<ArrayList<Integer>> criticalConnections(int v, ArrayList<ArrayList<Integer>> adj) {
        time = 0;
        dt = new int[v];
        Arrays.fill(dt, -1);
        low = new int[v];
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        for(int i=0;i<v;i++) {
            if(dt[i] == -1) {
                DFS(i, -1, adj, result);
            }
        }
        result.sort((a, b) -> {
            if (!a.get(0).equals(b.get(0))) {
                return Integer.compare(a.get(0), b.get(0));
            }
            return Integer.compare(a.get(1), b.get(1));
        });
        
        return result;
    }
    
    private void DFS(int u, int parentU, ArrayList<ArrayList<Integer>> adj, ArrayList<ArrayList<Integer>> result) {
        dt[u] = low[u] = ++time;
        
        for(int v: adj.get(u)) {
            if(dt[v] == -1) {
                DFS(v, u, adj, result);
                
                low[u] = Math.min(low[u], low[v]);
                
                if(low[v] > dt[u]) {
                    ArrayList<Integer> ans = new ArrayList<>();
                    ans.add(Math.min(u,v));
                    ans.add(Math.max(u,v));
                    result.add(ans);
                }
            } else if(v != parentU) {
                low[u] = Math.min(low[u], dt[v]);
            }
        }
    }
}