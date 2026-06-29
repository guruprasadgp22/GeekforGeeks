class Solution {
    public int maxDotProduct(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        
        int k = m - n;
        
        int[] dp = new int[k+1];
        
        for(int i=0;i<dp.length;i++) {
            dp[i] = -1;
        }
        
        dp[0] = 0;
        
        for(int i=0;i<m;i++) {
            for(int j=k;j>=0;j--) {
                if(dp[j] == -1) {
                    continue;
                }
                
                if(j != k) {
                    dp[j+1] = Math.max(dp[j+1], dp[j]);
                }
                
                if(i-j < n) {
                    dp[j] += a[i] * b[i-j];
                }
            }
        }
        
        return dp[k];
    }
}