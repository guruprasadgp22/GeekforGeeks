class Solution {
    public int minFlips(String s) {
        return Math.min(solve(0, true, s), solve(0, false, s));
    }
    
    private int solve(int i, boolean isZero, String s) {
        if(i == s.length()) {
            return 0;
        }
        
        int res = 0;
        if(isZero) {
            if(s.charAt(i) == '0') {
                res = solve(i+1, false, s);
            } else {
                res = 1 + solve(i+1, false, s);
            }
        } else {
            if(s.charAt(i) == '1') {
                res = solve(i+1, true, s);
            } else {
                res = 1+ solve(i+1, true, s);
            }
        }
        
        return res;
    }
}