class Solution {
    public int countPS(String s) {
        int n = s.length();
        int count = 0;
        
        for(int i=0;i<n;i++) {
            count += checkPalindrome(i, i, s);
            count += checkPalindrome(i, i+1, s);
        }
        
        return count;
    }
    
    private int checkPalindrome(int i, int j, String s) {
        int count = 0;
        
        while(i >=0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            if(j - i + 1 >= 2) {
                count++;
            }
            i--;
            j++;
        }
        
        return count;
    }
}