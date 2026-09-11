class Solution {
    public int sameMod(int[] arr) {
        int gcd = 0;
        for(int i=1;i<arr.length;i++) {
            int diff = Math.abs(arr[i] - arr[0]);
            gcd = GCD(gcd, diff);
        }
       
        if(gcd == 0) {
            return -1;
        }
        
        int count = 0;
        
        for(int i=1;i*i <= gcd; i++) {
            if(gcd % i == 0) {
                count += 2;
                
                if(i * i == gcd) {
                    count--;
                }
            }
        }
       
        return count;
    }
    
    private int GCD(int a, int b) {
        while( b!= 0) {
            int t = b;
            b = a % b;
            a = t;
        }   
        
        return a;
    }
}