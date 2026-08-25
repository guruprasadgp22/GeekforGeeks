class Solution {
    public int maxValue(int[] arr) {
        // code here
        int n = arr.length;
        
        if(n == 0) {
            return 0;
        }
        
        if( n== 1) {
            return arr[0];
        }
        
        if(n == 2) {
            return Math.max(arr[0], arr[1]);
        }
        
        return Math.max(solve(arr, 0, n-2), solve(arr, 1, n-1));
    }
    
    private int solve(int[] arr, int start, int end) {
        int n = arr.length;
        int[] dp = new int[n-1];
        dp[0] = arr[start];
        dp[1] = Math.max(arr[start], arr[start+1]);
        
        for(int i=start+2, j=2; i <= end; i++, j++) {
            int take = arr[i] + dp[j-2];
            int skip = dp[j-1];
            dp[j] = Math.max(take, skip);
        }
        
        return dp[n-2];
    }
}
