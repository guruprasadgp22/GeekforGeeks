class Solution {
    int[][][] dp;
    public int countWithout(int n, int d) {
        dp = new int[11][2][2];
        
        for(int i=0;i<11;i++) {
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        String num = String.valueOf(n);
        
        return solve(0, 1, 0, num, d)-1;
    }
    
    private int solve(int index, int tight, int started, String num, int d) {
        if(index == num.length()) {
            return 1;
        }
        
        if(dp[index][tight][started] != -1) {
            return dp[index][tight][started];
        }
        
        int ans = 0;
        int limit = 9;
        
        if(tight == 1) {
            limit = num.charAt(index) - '0';
        }
        
        for(int i=0;i<=limit;i++) {
            int ntight = (tight == 1) && (i == limit) ? 1: 0;
            int nstarted = (started == 1 || i != 0) ? 1: 0;
            
            if(nstarted == 1 && i == d) {
                continue;
            }
            
            ans += solve(index+1, ntight, nstarted, num, d);
        }
        
        return dp[index][tight][started] = ans;
    }
}