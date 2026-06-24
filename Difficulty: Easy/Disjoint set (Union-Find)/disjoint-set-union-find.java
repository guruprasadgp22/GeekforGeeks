class Solution {
    int[] parent;

    public ArrayList<Integer> DSU(int n, int[][] queries) {
        // code here
        parent = new int[n+1];

        for(int i=1;i<=n;i++) {
            parent[i] = i;
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int[] q: queries) {
            int i = q[0];
            
            if(i == 2) {
                ans.add(find(q[1]));
            } else {
                union(q[1], q[2]);
            }
        }
        
        return ans;
    }
    
    void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);
        
        if(parA != parB) {
            parent[parA] = parB;
        }
    }
    
    int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        } 
    
        return parent[x];
    }
} 