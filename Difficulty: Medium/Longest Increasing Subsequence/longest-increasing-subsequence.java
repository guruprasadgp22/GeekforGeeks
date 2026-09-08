class Solution {
    int[][] dp;
    public int lis(int arr[]) {
        // code here
        int n = arr.length;
        
        dp = new int[n+1][n+1];
        for(int[] x: dp) {
            Arrays.fill(x, -1);
        }
        
        return solve(0, -1, arr);
    }
    
    private int solve(int i, int prev, int[] nums) {
        if(i == nums.length) {
            return 0;
        }
        
        int j = prev + 1;
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        
        int skip = solve(i+1, prev, nums);
        
        int take = 0;
        if(prev == -1 || nums[prev] < nums[i]) {
            take = 1 + solve(i+1, i, nums);
        }
        
        return dp[i][j] = Math.max(take, skip);
    }
}