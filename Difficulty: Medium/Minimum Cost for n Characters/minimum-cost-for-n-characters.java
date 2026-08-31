class Solution {
    public int minCost(int n, int i, int d, int c) {
        // code here
        return solve(n, i, d, c);
    }
    
    private int solve(int n, int i, int d, int c) {
        if(n == 0) {
            return n;
        }
        
        if(n == 1) {
            return i;
        }
        
        int ans = i * n;
        
        if(n % 2 == 0) {
            int copy = c + solve(n/2, i, d, c);
            ans = Math.min(ans, copy);
        } else {
            int down = i + solve(n-1, i, d, c);
            int up = d + c + solve((n+1)/2, i, d, c);
            ans = Math.min(ans, Math.min(down, up));
        }
        
        return ans;
    }
}