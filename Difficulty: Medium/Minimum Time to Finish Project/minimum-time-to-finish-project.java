class Solution {
    public int minTime(int[] duration, int[][] dependencies) {
        int n = duration.length;
        int[] inDegree = new int[n];
        List<List<Integer>> adjMat = new ArrayList<>();
        for(int i=0;i<n;i++) {
            adjMat.add(new ArrayList<>());
        }
        
        for(int[] x: dependencies) {
            int u = x[0];
            int v = x[1];
            adjMat.get(u).add(v);
            inDegree[v]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        int[] finishTime = new int[n];
        for(int i=0;i<n;i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
                finishTime[i] = duration[i];
            }
        }
        
        int completed = 0;
        int ans = 0;
        
        while(!queue.isEmpty()) {
            int u = queue.poll();
            ans = Math.max(ans, finishTime[u]);
            completed++;
            
            for(int v: adjMat.get(u)) {
                finishTime[v] = Math.max(finishTime[v], duration[v] + finishTime[u]);
                inDegree[v]--;
                if(inDegree[v] == 0){
                    queue.add(v);
                }
            }
        }
        
        if(completed != n){
            return -1;
        }
        return ans;
    }
}