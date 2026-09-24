class Solution {
    public int maxStackHeight(int[] r, int[] h) {
        int n = r.length;
        
        int[][] arr =new int[n][2];
        for(int i=0;i<n;i++) {
            arr[i][0] = r[i];
            arr[i][1] = h[i];
        }
        
        Arrays.sort(arr, (a, b) -> {
            if(a[0] == b[0]) {
                return b[1] - a[1];
            }
           return a[0] - b[0]; 
        });
        
        int result = 0;
        int[] dp = new int[1001];
        
        for(int i=0;i<n;i++) {
            int height = arr[i][1];
            int best = dp[height-1];
            
            int current = height + best;
            
            update(height, current, dp);
            result = Math.max(result, current);
        }
        
        return result;
    }
    
    private void update(int index, int value, int[] dp) {
        while(index < dp.length) {
            dp[index] = Math.max(dp[index], value);
            index++;
        }
    }
}