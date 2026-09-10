class Solution {
    public int pairCount(int x, int y) {
        if(y % x != 0) {
            return 0;
        }
        
        int count = 0;
        int product = x *  y;
        
        for(int a = x; a <= y; a++) {
            if(product % a == 0) {
                int b = product/a;
                
                if(gcd(a, b) == x) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private int gcd(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        
        return a;
    }
}