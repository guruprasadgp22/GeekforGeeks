class Solution {
    int[][] dp;
    public int maxProfit(int arr[]) {
        int n = arr.length;
        dp = new int[n][2];
        for(int[] x: dp) {
            Arrays.fill(x, -1);
        }
        return solve(0, true, arr);
    }
    
    private int solve(int day, boolean isBuy, int[] arr) {
        if(day >= arr.length) {
            return 0;
        }
        
        int j = isBuy? 1: 0;
        if(dp[day][j] != -1) {
            return dp[day][j];
        }
        
        int profit = 0;
        
        if(isBuy) {
            int buy = solve(day+1, false, arr) - arr[day];
            int notBuy = solve(day+1, true, arr);
            profit = Math.max(profit, Math.max(buy, notBuy));
        } else {
            int sell = solve(day+2, true, arr) + arr[day];
            int notSell = solve(day+1, false, arr);
            profit = Math.max(profit, Math.max(sell, notSell));
        }
        
        return dp[day][j] = profit;
    }
}
