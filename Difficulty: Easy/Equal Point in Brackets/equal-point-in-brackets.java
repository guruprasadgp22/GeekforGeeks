class Solution {
    public int findIndex(String s) {
        // code here
       int closed = 0;
       int open = 0;
       
       for(char ch: s.toCharArray()) {
           if(ch == ')') {
               closed++;
           }
       }
       
       for(int i=0;i<s.length();i++) {
           if(s.charAt(i) == '(') {
               open++;
           } else {
               closed--;
           }
           
           if(open == closed) {
               return i+1;
           }
       }
       
       return (open > closed)? 0: s.length();
    }
}