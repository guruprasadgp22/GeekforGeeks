class Solution {
    public int minThrows(int n, int[] lad, int[] sn) {
        // code here
        int total = n * n;
        int[] jump = new int[total+1];
        for(int i=1;i<=total;i++) {
            jump[i] = i;
        }
        
        for(int i=0;i<lad.length;i+=2) {
            jump[lad[i]] = lad[i+1];
        }
        
        for(int i=0;i<sn.length;i+=2) {
            jump[sn[i]] = sn[i+1];
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});
        
        boolean[] visited = new boolean[total+1];
        visited[1] = true;
        
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int u = temp[0];
            int v = temp[1];
            
            if(u == n*n) {
                return v;
            }
            
            for(int i=1;i<=6;i++) {
                int next = u + i;
                
                if(next <= total) {
                    int nextU = jump[next];
                    
                    if(!visited[nextU]) {
                        visited[nextU] = true;
                        queue.add(new int[]{nextU, v+1});
                    }
                }
            }
        }
        
        return -1;
    }
}