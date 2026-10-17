class Solution {
    public boolean isItPossible(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int i = 0;
        int j = 0;
        
        if(m != n) {
            return false;
        }
        
        while(i < m) {
            while(i < m && s1.charAt(i) == '#') {
                i++;
            }
            
            while(j < n && s2.charAt(j) == '#') {
                j++;
            }
            
            if(i >= m && j < n) {
                return false;
            }
            
            if(j >= n && i < m) {
                return false;
            }
            
            if(i < m && j < n && s1.charAt(i) == s2.charAt(j)) {
                if(s1.charAt(i) == 'A' && j > i) {
                    return false;
                }
                
                if(s1.charAt(i) == 'B' && j < i) {
                    return false;
                }
            } 
            
            if(i < m &&  j< n && s1.charAt(i) != s2.charAt(j)) {
                return false;
            }
            i++;
            j++;
            
        }
        
        return true;

    }
};