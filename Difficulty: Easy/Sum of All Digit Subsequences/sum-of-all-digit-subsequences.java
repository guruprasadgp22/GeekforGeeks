class Solution {
    public int subsequenceSum(String s) {
        long MOD = 1_000_000_007;
        long sum = 0;
        for(char ch: s.toCharArray()){
            sum =(sum + (ch - '0')) % MOD;
        }
        
        int n = s.length() - 1;
        long pow = 1;
        for(int i=0;i<n;i++) {
            pow = 2 * pow % MOD;
        }
        long res = (sum * pow) % MOD;
        return (int)res;
    }
}