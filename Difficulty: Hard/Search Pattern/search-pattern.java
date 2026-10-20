class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        int m = pat.length();
        int n = txt.length();
        int[] LPS = new int[m];
        lps(pat, LPS);
        
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        
        while(i < n) {
            if(pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }
            
            if(j == m) {
                result.add(i-m);
                j = LPS[j-1];
            } else if(i < n && (j == 0 || pat.charAt(j) != txt.charAt(i))) {
                if(j != 0) {
                    j = LPS[j-1];
                } else {
                    i++;
                }
            }
        }
        
        return result;

    }
    
    void lps(String pat, int[] LPS) {
        int m = pat.length();
        int i = 1;
        int len = 0;
        
        while(i < m) {
            if(pat.charAt(i) == pat.charAt(len)) {
                len++;
                LPS[i] = len;
                i++;
            } else {
                if(len != 0) {
                    len = LPS[len-1];
                } else {
                    LPS[i] = 0;
                    i++;
                }
            }
        }
    }
}