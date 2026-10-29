class Solution {
    static boolean equalPartition(int arr[]) {
        int n = arr.length;
        int sum = 0;
        for(int ele: arr) {
            sum += ele;
        }
        
        if(sum % 2== 1) {
            return false;
        }
        
        sum /= 2;
        
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int i=0;i<=n;i++) {
            dp[i][0] = true;
        }
        
        for(int i=n-1;i>=0;i--) {
            for(int j=0;j<=sum;j++) {
                boolean take = false;
                if(arr[i] <= j) {
                    take |= dp[i+1][j-arr[i]];
                }
                
                boolean skip = dp[i+1][j];
                dp[i][j] = skip | take;
            }
        }
        
        return dp[0][sum];
        
    }
}