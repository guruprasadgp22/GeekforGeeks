class Solution {
    public static int countBitsFlip(int a, int b) {
        int flip = 0;
        
        while(a != 0 || b != 0) {
            if((b & 1) == 0) {
                if((a & 1) == 1) {
                    flip++;
                }
            } else {
                if((a & 1) == 0) {
                    flip++;
                }
            }
            
            a >>= 1;
            b >>= 1;
        }
        
        return flip;
    }
}
