// User function Template for Java

class Solution {
    String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    HashMap<Long, String> map = new HashMap<>();
    
    String idToShortURL(long n) {
        // code here
        
        map.put(n, generate(n));
        
        return map.get(n);
        
    }
    
    String generate(long num) {
        StringBuilder sb = new StringBuilder();
        
        while(num > 0) {
            int temp = (int)(num%62);
            
            sb.append(chars.charAt(temp));
            num/=62;
        }
        
        return sb.reverse().toString();
    }
}