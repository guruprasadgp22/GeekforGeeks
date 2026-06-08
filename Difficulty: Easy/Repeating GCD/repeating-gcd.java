// User function Template for Java

class Solution {
    public String FindGcd(long N, int x, int y) {
        // Code here
        int len = gcd(x, y);
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<len;i++) {
            sb.append(N);
        }
        
        return sb.toString();
    }
    
    public int gcd(int number, int num) {
        
        while(num != 0) {
            int temp = num;
            num = number % num;
            number = temp;
        }
        
        return number;
    }
}