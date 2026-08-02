class Solution {
    int[][] dp;
    public int count(int n, int m) {
        // code here
        dp = new int[n+1][m+1];
        for(int x[]: dp) {
            Arrays.fill(x, -1);
        }
        
        
        if(n == 1) {
            return m;
        }
        
        int ans = 0;
        
        for(int i=1;i<=m;i++) {
            ans += solve(n, m, 1, i);
        }
        
        return ans;
    }
    
    public int solve(int n, int m, int index, int prevVal) {
        if(index == n) {
            return 1;
        }
        
        if(dp[index][prevVal] != -1) {
            return dp[index][prevVal];
        }
        
        int ans = 0;
        
        for(int curr=1;curr<=m;curr++) {
            if(curr%prevVal == 0 || prevVal % curr == 0) {
                ans += solve(n, m, index+1, curr);
            }
        }
        
        return dp[index][prevVal] = ans;
    }
} 