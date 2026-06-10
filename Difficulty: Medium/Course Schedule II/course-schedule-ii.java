class Solution {
    public ArrayList<Integer> findOrder(int n, int[][] arr) {
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        
        for(int i=0;i<n;i++) {
            edges.add(new ArrayList<>());
        }
        
        for(int i=0;i<arr.length;i++) {
            int p = arr[i][1];
            int q = arr[i][0];
            edges.get(p).add(q);
        }
        // code here
        boolean[] visited = new boolean[n];
        boolean[] recursivePath = new boolean[n];
        
        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                if(DFS(i, visited, recursivePath, edges)) {
                    return new ArrayList<>();
                }
            }
        }
        
        Arrays.fill(visited, false);
        Stack<Integer> ans = new Stack<>();
        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                DFSTopo(i, visited, ans, edges);
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        while(!ans.isEmpty()) {
            result.add(ans.pop());
        }
        
        return result;
    }
    
    public void DFSTopo(int source, boolean[] vis, Stack<Integer> ans, ArrayList<ArrayList<Integer>> edges) {
        vis[source] = true;
        for(int neigh: edges.get(source)) {
            if(!vis[neigh]) {
                DFSTopo(neigh, vis, ans, edges);
            }
        }
        
        ans.add(source);
    }
    
    public boolean DFS(int source, boolean[] visited, boolean[] recursivePath, ArrayList<ArrayList<Integer>> edges) {
        visited[source] = true;
        recursivePath[source] = true;
        
        for(int neigh: edges.get(source)) {
            if(!visited[neigh]) {
                if(DFS(neigh, visited, recursivePath, edges)) {
                    return true;
                }
            } else if(recursivePath[neigh]) {
                return true;
            }
        }
        
        recursivePath[source] = false;
        return false;
    }
}