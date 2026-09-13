class Solution {
    public int maxChainLen(int arr[][]) {
        int n = arr.length;
        
        int dp[] = new int[n+1];
        Arrays.fill(dp, 1);
        
        Arrays.sort(arr, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        
        int result = 1;
        for(int i=1;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(arr[i][0] > arr[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    result = Math.max(result, dp[i]);
                }
            }
        }
        
        return result;
    }
}
