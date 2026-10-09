class Solution {
    public int minOperation(int n) {
        int op = 0;
        int num = n;
        
        while(num > 0) {
            if(num%2 == 0) {
                num/= 2;
            } else {
                num--;
            }
            op++;
        }
        return op;
        
    }
}