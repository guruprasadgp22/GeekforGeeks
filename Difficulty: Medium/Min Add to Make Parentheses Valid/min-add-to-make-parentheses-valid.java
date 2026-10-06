class Solution {
    public int minParentheses(String s) {
       int res = 0;
       int count = 0;
       
       for(char ch: s.toCharArray()) {
           if(ch == '(') {
               count++;
           } else {
               if(count > 0){
                   count--;
               }else {
                   res++;
               }
           }
       }
       
       return res+count;
        
    }
}
