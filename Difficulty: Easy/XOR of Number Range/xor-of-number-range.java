class Solution {
    public int findXOR(int l, int r) {
        return find(r) ^ find(l-1);
    }
    
    private int find(int n) {
        if(n < 0) {
            return 0;
        }
        
        switch(n % 4) {
            case 0: return n;
            case 1: return 1;
            case 2: return n+1;
            default: return 0;
        }
    }
}