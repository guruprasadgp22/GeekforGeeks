class Solution {
    int dp[][];
    public int maxTask(int[] h, int[] l) {
        int n = h.length;
        
        dp = new int[n+1][2];
        for(int i=0;i<n+1;i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return solve(0, false, h, l);
    }
    
    private int solve(int index, boolean prevTask, int[] h, int[] l) {
        if(index == h.length) {
            return 0;
        }
        int state = prevTask? 1: 0;
        
        if(dp[index][state] != -1) {
            return dp[index][state];
        }
        
        int skip = solve(index+1, false, h, l);
        int low = l[index] + solve(index+1, true, h, l);
        
        int high = 0;
        if(!prevTask) {
            high = h[index] + solve(index+1, true, h, l);
        }
        
        return dp[index][state] = Math.max(skip, Math.max(high, low));
    }
}