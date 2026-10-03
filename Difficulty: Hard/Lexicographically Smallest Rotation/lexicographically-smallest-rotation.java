class Solution {
    public String lexiString(String s) {
        int n = s.length();
        String doubleS = s + s;
        
        int i = 0;
        int j = 1;
        int k = 0;
        
        while(i < n && j < n && k < n) {
            if(doubleS.charAt(i+k) == doubleS.charAt(j+k)){
                k++;
            } else if(doubleS.charAt(i+k) > doubleS.charAt(j+k)){
                i = i+k+1;
                if(i == j){
                    i++;
                }
                k = 0;
            } else {
                j = j + k+1;
                if(j == i){
                    j++;
                }
                
                k= 0;
            }
        }
        
        return doubleS.substring(Math.min(i, j), Math.min(i, j)+n);
    }
}