class Solution {
    int[][][] dp;
    public int minCount(int[] arr) {
        int n = arr.length;
        
        dp = new int[n+1][102][102];
        for(int i=0;i<=n;i++) {
            for(int j=0;j<=101;j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        int incr = Integer.MIN_VALUE;
        int decr = Integer.MAX_VALUE;
        int i = 0;
        return n - solve(i, incr, decr, arr);
    }
    
    private int solve(int i, int incr, int decr, int[] arr) {
        if(i == arr.length) {
            return 0;
        }
        
        
        int newincr = incr == Integer.MIN_VALUE? 0: incr+1;
        int newdecr = decr == Integer.MAX_VALUE? 0: decr+1;
        if(dp[i][newincr][newdecr] != -1) {
            return dp[i][newincr][newdecr];
        }
        
        int skip = solve(i+1, incr, decr, arr);
        
        int takeIncr = 0;
        if(incr < arr[i]) {
            takeIncr = 1 + solve(i+1, arr[i], decr, arr);
        }
        
        int takeDecr = 0;
        if(decr > arr[i]) {
            takeDecr = 1 + solve(i+1, incr, arr[i], arr);
        }
        
        return dp[i][newincr][newdecr] = Math.max(skip, Math.max(takeIncr, takeDecr));
    }
}